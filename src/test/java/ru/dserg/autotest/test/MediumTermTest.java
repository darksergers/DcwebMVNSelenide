package ru.dserg.autotest.test;

import org.junit.After;
import org.junit.Test;
import ru.dserg.autotest.page.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Kalinin.S on 27.09.2016.
 */

public class MediumTermTest {

    static Date d = new Date();
    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @After
    public void aftr(){
        Menu.logOut();
    }

    @Test
    public void testCharacteristicsIsAvailable(){
        LoginPage loginPage = new LoginPage();
        loginPage.typeUserName();
        loginPage.typePassword();
        HomePage homePage = loginPage.login();
        LongModel longModel = homePage.longModel();
        longModel.create();
        longModel.getCreate().name("CharacteristicsIsAvailable"+format.format(d));
        longModel.getCreate().beginDatePritok("2015-09-05");
        longModel.getCreate().beginDateCalculation("2015-09-15");
        longModel.getCreate().endDateCalculation("2015-09-25");
        LongScenario longScenario = longModel.getCreate().create();
        longScenario.characteristics();
        longScenario.getCharacteristics().vbCurves(0);
        longScenario.getCharacteristics().nbCurves();
        longScenario.getCharacteristics().nbWinter();
        longScenario.getCharacteristics().hidroVB();
        longScenario.getCharacteristics().spillwayCapacity();
        longScenario.getCharacteristics().ownExpensesLosses();
        longScenario.getCharacteristics().expenseChars();
    }

    
}
