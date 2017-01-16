package ru.dserg.autotest.test;

import com.codeborne.selenide.Configuration;
import com.gurock.testrail.APIException;
import com.gurock.testrail.DDtestrail;
import org.junit.*;
import ru.dserg.autotest.Utils.Util;
import ru.dserg.autotest.page.HomePage;
import ru.dserg.autotest.page.Menu;
import ru.dserg.autotest.page.Reports.*;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import static com.codeborne.selenide.Selenide.screenshot;
import static org.junit.Assert.fail;

/**
 * Created by Kalinin.S on 09.11.2016.
 */
@Features("Отчеты")
public class ReportsTest {
    static Date d = new Date();
    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH.mm");
    private static SimpleDateFormat currentF =new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");//формат для input text
    private static HashMap<Integer,String> dataError = new HashMap<Integer,String>();
    private static HashMap<Integer,Integer> data = new HashMap<Integer,Integer>();
        private static String beforeTwoDays;
    private static String beforeTwoDaysFormat;
    private static String yesterday;
    private static String firstDayOfMonth;
    private static String  beforeTwoMonth;



    @BeforeClass
    public static  void bfr() {
        GregorianCalendar g = new GregorianCalendar();

        g.add(Calendar.DAY_OF_MONTH,-1);
        yesterday= currentF.format(g.getTime());
        g.add(Calendar.DAY_OF_MONTH,-1);
        beforeTwoDays= currentF.format(g.getTime());
        beforeTwoDaysFormat = dateFormat.format(g.getTime());
        g.set(Calendar.DAY_OF_MONTH,1);
        firstDayOfMonth = dateFormat.format(g.getTime());
        g.add(Calendar.MONTH,-2);
        beforeTwoMonth = dateFormat.format(g.getTime());

        for (int i = 0; i < 5; i++) {
            data.put(i, 4);
        }
    }
    @Stories("Отчёт по выполнению плана ремонтов оборудования")
    @Test
    public void testRepairReport() throws Exception {
        data.put(0,5);
        try{
        HomePage homePage= Util.entry();
        RepairReport repairReport = homePage.getMenu().repairReport();
        repairReport.selectStation(4);
        repairReport.datebegin( beforeTwoMonth);
        repairReport.show();
        if(!repairReport.ok()) fail();
        data.put(0,1);
        } catch (Throwable e){
            screenshot("Error1");
            Util.attachImage("build/reports/tests/Error1.png");
            dataError.put(0,e.getMessage());
            throw e;
        }


    }
    @Stories("Отчёт по времени оборудования в ремонте")
    @Test
    public void testRepairTimeReport() throws Exception {
        data.put(1,5);
        try{
        HomePage homePage=Util.entry();
        RepairTimeReport repairTimeReport = homePage.getMenu().repairTimeReport();
        repairTimeReport.selectStation();
        repairTimeReport.show();
        if(!repairTimeReport.ok()) fail();
        data.put(1,1);
        } catch (Throwable e){
            screenshot("Error2");
            Util.attachImage("build/reports/tests/Error2.png");
            dataError.put(1,e.getMessage());
            throw e;
        }



    }
    @Stories("Отчёт о проверке располагаемой мощности")
    @Test
    public void testAvailablePowerReport() throws Exception {
        data.put(2,5);
        try {
        HomePage homePage=Util.entry();
        AvailablePowerReport availablePowerReport = homePage.getMenu().availablePowerReport();
        availablePowerReport.selectStation();
        availablePowerReport.beginDate(beforeTwoDays);
        availablePowerReport.endDate(yesterday);
        availablePowerReport.selectStepSize();
        availablePowerReport.clickApplyButton();
        availablePowerReport.completeDH();
        availablePowerReport.clickCountButton();
        if(!availablePowerReport.ok()) fail("В колонках Na в одной из 4х нет данных или dNa%  больше 20");
        data.put(2,1);
        } catch (Throwable e){
            screenshot("Error3");
            Util.attachImage("build/reports/tests/Error3.png");
            dataError.put(2,e.getMessage());
            throw e;
        }





    }
    @Stories("Отчёт о режимах эксплуатации оборудования")
    @Test
    public void testReportEquipmentOperatingRegime() throws Exception {
        data.put(3,5);
        try{
        HomePage homePage=Util.entry();
        ReportEquipmentOperatingRegime reportEquipmentOperatingRegime =
                homePage.getMenu().reportEquipmentOperatingRegime();
        reportEquipmentOperatingRegime.datebegin(firstDayOfMonth);
        reportEquipmentOperatingRegime.selectStation();
        reportEquipmentOperatingRegime.ga();
        reportEquipmentOperatingRegime.show();
        if(!reportEquipmentOperatingRegime.ok()) fail();
        reportEquipmentOperatingRegime.selectSource();
        reportEquipmentOperatingRegime.show();
        if(!reportEquipmentOperatingRegime.ok()) fail();
        data.put(3,1);
        } catch (Throwable e){
            screenshot("Error4");
            Util.attachImage("build/reports/tests/Error4.png");
            dataError.put(3,e.getMessage());
            throw e;
        }


    }
    @Stories("Отчёт расхода ГЭС")
    @Test
    public void testOtchetRashodaGESPage() throws Exception {
        data.put(4,5);
        try {
            HomePage homePage = Util.entry();
            OtchetRashodaGESPage otchetRashodaGESPage = homePage.otchetRashodaGESPage();
            otchetRashodaGESPage.listStation(1);
            otchetRashodaGESPage.date(yesterday);
            otchetRashodaGESPage.clickGetData();
            if (otchetRashodaGESPage.isPositive()) fail();
            data.put(4, 1);
        } catch (Throwable e){
            screenshot("Error5");
            Util.attachImage("build/reports/tests/Error5.png");
            dataError.put(4,e.getMessage());
            throw e;
        }
    }
    @Ignore
    @Stories("Контроль выполнения режимов в среднесрочной модели")
    @Test
    public void testMediumTermRegimeControl(){
        
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
       testrail.completeTest(data,dataError, "Отчеты " +Configuration.baseUrl+" "+ format.format(d));

    }


}
