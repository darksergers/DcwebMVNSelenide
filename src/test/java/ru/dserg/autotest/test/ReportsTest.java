package ru.dserg.autotest.test;

import com.codeborne.selenide.Configuration;
import com.gurock.testrail.APIException;
import com.gurock.testrail.DDtestrail;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.dserg.autotest.Utils.Util;
import ru.dserg.autotest.page.HomePage;
import ru.dserg.autotest.page.LoginPage;
import ru.dserg.autotest.page.Menu;
import ru.dserg.autotest.page.Reports.AvailablePowerReport;
import ru.dserg.autotest.page.Reports.RepairReport;
import ru.dserg.autotest.page.Reports.RepairTimeReport;
import ru.dserg.autotest.page.Reports.ReportEquipmentOperatingRegime;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.fail;

/**
 * Created by Kalinin.S on 09.11.2016.
 */
public class ReportsTest {
    static Date d = new Date();
    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH.mm");
    private static HashMap data = new HashMap();



    @BeforeClass
    public static  void bfr() {

        for (int i = 0; i < 4; i++) {
            data.put(i, 4);
        }
    }
    @Test
    public void testRepairReport() throws Exception {
        data.put(0,5);
        HomePage homePage= Util.entry();
        RepairReport repairReport = homePage.getMenu().repairReport();
        repairReport.selectStation(4);
        repairReport.datebegin();
        repairReport.show();
        if(!repairReport.ok()) fail();
        data.put(0,1);


    }
    @Test
    public void testRepairTimeReport() throws Exception {
        data.put(1,5);
        HomePage homePage=Util.entry();
        RepairTimeReport repairTimeReport = homePage.getMenu().repairTimeReport();
        repairTimeReport.selectStation();
        repairTimeReport.show();
        if(!repairTimeReport.ok()) fail();
        data.put(1,1);



    }

    @Test
    public void testAvailablePowerReport() throws Exception {
        data.put(2,5);
        HomePage homePage=Util.entry();
        AvailablePowerReport availablePowerReport = homePage.getMenu().availablePowerReport();
        availablePowerReport.selectStation();
        availablePowerReport.beginDate();
        availablePowerReport.endDate();
        availablePowerReport.selectStepSize();
        availablePowerReport.clickApplyButton();
        availablePowerReport.completeDH();
        availablePowerReport.clickCountButton();
        if(!availablePowerReport.ok()) fail();
        data.put(2,1);





    }
    @Test
    public void testReportEquipmentOperatingRegime() throws Exception {
        data.put(3,5);
        HomePage homePage=Util.entry();
        ReportEquipmentOperatingRegime reportEquipmentOperatingRegime =
                homePage.getMenu().reportEquipmentOperatingRegime();
        reportEquipmentOperatingRegime.datebegin();
        reportEquipmentOperatingRegime.selectStation();
        reportEquipmentOperatingRegime.ga();
        reportEquipmentOperatingRegime.show();
        if(!reportEquipmentOperatingRegime.ok()) fail();
        reportEquipmentOperatingRegime.selectSource();
        reportEquipmentOperatingRegime.show();
        if(!reportEquipmentOperatingRegime.ok()) fail();
        data.put(3,1);


    }
   @After
    public void aftr(){
        Util.pnotifyClose();
        try {
            Menu.logOut();
        }catch (Error  e){
            Util.pnotifyClose();
            Menu.logOutWithExceptiom();
        }


    }
    @AfterClass
    public static void testrail() throws IOException, APIException {


        DDtestrail testrail = new DDtestrail(58, 2560, Configuration.baseUrl.equals("http://dc-web.vdrsk.digdes.com:8099"));
        testrail.completeTest(data, "Отчеты " +Configuration.baseUrl+ format.format(d));

    }


}
