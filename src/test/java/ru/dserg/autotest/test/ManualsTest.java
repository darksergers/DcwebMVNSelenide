package ru.dserg.autotest.test;

import org.junit.Ignore;
import org.junit.Test;
import ru.dserg.autotest.page.HomePage;
import ru.dserg.autotest.page.LoginPage;
import ru.dserg.autotest.page.Manuals.CardGES;
import ru.dserg.autotest.page.Manuals.DataDirectoryGES;
import ru.dserg.autotest.page.Manuals.ExpenseCharacteristicsGA;
import ru.dserg.autotest.page.ShortModel;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.fail;

/**
 * Created by Kalinin.S on 02.11.2016.
 */
public class ManualsTest {
    static Date d = new Date();
    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh-mm");
    @Ignore
    @Test
    public void test() throws Exception {

        LoginPage loginPage = new LoginPage();
        loginPage.typeUserName();
        loginPage.typePassword();
        HomePage homePage = loginPage.login();
        DataDirectoryGES dataDirectoryGES =  homePage.dataDirectoryGES();
        CardGES cardGES=dataDirectoryGES.volges();
        cardGES.rgeOk();
        cardGES.gtpOk();
        cardGES.gaOk();


    }

    @Test
    public void test1() throws Exception {

        LoginPage loginPage = new LoginPage();
        loginPage.typeUserName();
        loginPage.typePassword();
        HomePage homePage = loginPage.login();
        ExpenseCharacteristicsGA expenseCharacteristicsGA = homePage.expenseCharacteristicsGA();
        expenseCharacteristicsGA.choice();
        expenseCharacteristicsGA.clickCharacteristic();
        if (!expenseCharacteristicsGA.ok()) fail("пустая таблица");
        Thread.sleep(6000);

    }

}
