package ru.dserg.autotest.test;

import org.junit.Test;
import ru.dserg.autotest.page.HomePage;
import ru.dserg.autotest.page.LoginPage;
import ru.dserg.autotest.page.Reports.AvailablePowerReport;
import ru.dserg.autotest.page.Reports.RepairReport;
import ru.dserg.autotest.page.Reports.RepairTimeReport;

import static org.junit.Assert.fail;

/**
 * Created by Kalinin.S on 09.11.2016.
 */
public class ReportsTest {
    @Test
    public void test() throws Exception {
        LoginPage loginPage = new LoginPage();
        loginPage.typeUserName();
        loginPage.typePassword();
        HomePage homePage = loginPage.login();
        RepairReport repairReport = homePage.getMenu().repairReport();
        repairReport.selectStation(4);
        repairReport.datebegin();
        repairReport.show();
        if(!repairReport.ok()) fail();


    }
    @Test
    public void test1() throws Exception {
        LoginPage loginPage = new LoginPage();
        loginPage.typeUserName();
        loginPage.typePassword();
        HomePage homePage = loginPage.login();
        RepairTimeReport repairTimeReport = homePage.getMenu().repairTimeReport();
        repairTimeReport.selectStation();
        repairTimeReport.show();
        if(!repairTimeReport.ok()) fail();
        Thread.sleep(6000);


    }

    @Test
    public void test2() throws Exception {
        LoginPage loginPage = new LoginPage();
        loginPage.typeUserName();
        loginPage.typePassword();
        HomePage homePage = loginPage.login();
        AvailablePowerReport availablePowerReport = homePage.getMenu().availablePowerReport();
        availablePowerReport.selectStation();
        availablePowerReport.beginDate();
        availablePowerReport.endDate();
        availablePowerReport.selectStepSize();
        availablePowerReport.clickApplyButton();
        availablePowerReport.completeDH();
        availablePowerReport.clickCountButton();

        Thread.sleep(6000);


    }

}
