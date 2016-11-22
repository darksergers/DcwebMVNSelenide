package ru.dserg.autotest.test;

import org.junit.Test;
import ru.dserg.autotest.Utils.Util;
import ru.dserg.autotest.page.HomePage;
import ru.dserg.autotest.page.LoginPage;
import ru.dserg.autotest.page.Reports.AvailablePowerReport;
import ru.dserg.autotest.page.Reports.RepairReport;
import ru.dserg.autotest.page.Reports.RepairTimeReport;
import ru.dserg.autotest.page.Reports.ReportEquipmentOperatingRegime;

import static org.junit.Assert.fail;

/**
 * Created by Kalinin.S on 09.11.2016.
 */
public class ReportsTest {
    @Test
    public void test() throws Exception {
        HomePage homePage= Util.entry();
        RepairReport repairReport = homePage.getMenu().repairReport();
        repairReport.selectStation(4);
        repairReport.datebegin();
        repairReport.show();
        if(!repairReport.ok()) fail();


    }
    @Test
    public void test1() throws Exception {
        HomePage homePage=Util.entry();
        RepairTimeReport repairTimeReport = homePage.getMenu().repairTimeReport();
        repairTimeReport.selectStation();
        repairTimeReport.show();
        if(!repairTimeReport.ok()) fail();
        Thread.sleep(6000);


    }

    @Test
    public void test2() throws Exception {
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

        Thread.sleep(6000);


    }
    @Test
    public void test3() throws Exception {
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
        Thread.sleep(6000);

    }


}
