package ru.dserg.autotest.test;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import ru.dserg.autotest.Utils.Util;
import ru.dserg.autotest.page.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.fail;

/**
 * Created by Kalinin.S on 27.09.2016.
 */
@Ignore
public class MediumTermTest {

    static Date d = new Date();
    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @After
    public void aftr(){
        Menu.logOut();
    }
    public void granularity(String granularity ) throws Exception {
        LoginPage loginPage = new LoginPage();
        loginPage.typeUserName();
        loginPage.typePassword();
        HomePage homePage = loginPage.login();
        LongModel longModel = homePage.longModel();
        Util.findError();
        longModel.create();
        longModel.getCreate().beginDatePritok("2015-09-05");
        longModel.getCreate().beginDateCalculation("2015-09-15");
        longModel.getCreate().endDateCalculation("2015-09-25");
        longModel.getCreate().granularity("месяц");
        longModel.getCreate().name("Granularity"+granularity+format.format(d));
        longModel.getCreate().create();
        Util.findError();
        Util.pnotifyClose();
    }




    @Test
    public void testCharacteristicsIsAvailable() throws Exception {
        LoginPage loginPage = new LoginPage();
        loginPage.typeUserName();
        loginPage.typePassword();
        HomePage homePage = loginPage.login();
        LongModel longModel = homePage.longModel();
        Util.findError();
        longModel.create();
        longModel.getCreate().name("CharacteristicsIsAvailable"+format.format(d));
        longModel.getCreate().beginDatePritok("2015-09-05");
        longModel.getCreate().beginDateCalculation("2015-09-15");
        longModel.getCreate().endDateCalculation("2015-09-25");
        LongScenario longScenario = longModel.getCreate().create();
        Util.pnotifyClose();
        longScenario.characteristics();
        longScenario.getCharacteristics().vbCurves(0);
        longScenario.getCharacteristics().nbCurves();
        longScenario.getCharacteristics().nbWinter();
        longScenario.getCharacteristics().hidroVB();
        longScenario.getCharacteristics().spillwayCapacity();
        longScenario.getCharacteristics().ownExpensesLosses();
        longScenario.getCharacteristics().expenseChars();
        Util.findError();
    }




    @Test
    public void testGranularityMonth() throws Exception {
        granularity("Месяц");

    }


    @Test
    public void testGranularityPentada() throws Exception {
        granularity("Пентада");
    }


    @Test
    public void testGranularityDecada() throws Exception {
        granularity("Декада");
    }


    @Test
    public void testHoldMode() throws Exception {
        LoginPage loginPage = new LoginPage();
        loginPage.typeUserName();
        loginPage.typePassword();
        HomePage homePage = loginPage.login();
        LongModel longModel = homePage.longModel();
        longModel.create();
        longModel.getCreate().name("test"+format.format(d));
        longModel.getCreate().beginDatePritok("2015-09-05");
        longModel.getCreate().beginDateCalculation("2015-09-05");
        longModel.getCreate().endDateCalculation("2015-09-15");
        LongScenario longScenario = longModel.getCreate().create();
        longScenario.pnotifyClose();
        longScenario.choiceGes(3);
        longScenario.getResults().typeInTable(0,2,"120");
        longScenario.getResults().typeInTable(1,12,"100");
        longScenario.getResults().typeInTable(2,20,"0.55");
        longScenario.getResults().typeInTable(3,19,"10");
        longScenario.getResults().choiceDg(4);
        longScenario.getResults().play();


    }


    @Test
    public void testRemont() throws Exception {
        LoginPage loginPage = new LoginPage();
        loginPage.typeUserName();
        loginPage.typePassword();
        HomePage homePage = loginPage.login();
        LongModel longModel = homePage.longModel();
        longModel.create();
        longModel.getCreate().name("test"+format.format(d));
        longModel.getCreate().beginDatePritok("2015-09-05");
        longModel.getCreate().beginDateCalculation("2015-09-05");
        longModel.getCreate().endDateCalculation("2015-09-15");
        LongScenario longScenario = longModel.getCreate().create();
        longScenario.pnotifyClose();
        longScenario.choiceGes(3);
        longScenario.remont();
        longScenario.getRemont().typeInTable(0,1,"24");
        longScenario.getRemont().typeInTable(0,2,"24");
        longScenario.getRemont().typeInTable(0,3,"24");
        longScenario.getRemont().typeInTable(0,6,"24");
        longScenario.results();
        longScenario.getResults().play();


    }


    @Test
    public void test() throws Exception {
        LoginPage loginPage = new LoginPage();
        loginPage.typeUserName();
        loginPage.typePassword();
        HomePage homePage = loginPage.login();
        OtchetRashodaGESPage otchetRashodaGESPage=homePage.otchetRashodaGESPage();
        otchetRashodaGESPage.listStation(1);
        otchetRashodaGESPage.date("2015-09-09");
        otchetRashodaGESPage.clickGetData();
        if (otchetRashodaGESPage.isPositive())fail();

    }



}
