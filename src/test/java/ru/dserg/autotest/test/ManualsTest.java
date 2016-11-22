package ru.dserg.autotest.test;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import ru.dserg.autotest.Utils.Util;
import ru.dserg.autotest.page.HomePage;
import ru.dserg.autotest.page.LoginPage;
import ru.dserg.autotest.page.Manuals.CardGES;
import ru.dserg.autotest.page.Manuals.DataDirectoryGES;
import ru.dserg.autotest.page.Manuals.ExpenseCharacteristicsGA;
import ru.dserg.autotest.page.Menu;
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

    @Test
    public void test() throws Exception {

        HomePage homePage= Util.entry();
        DataDirectoryGES dataDirectoryGES =  homePage.dataDirectoryGES();
        CardGES cardGES=dataDirectoryGES.volges();
        cardGES.rgeOk();
        cardGES.gtpOk();
        cardGES.gaOk();
    }

    @Test
    public void test1() throws Exception {

        HomePage homePage=Util.entry();
        ExpenseCharacteristicsGA expenseCharacteristicsGA = homePage.expenseCharacteristicsGA();
        expenseCharacteristicsGA.choice();
        expenseCharacteristicsGA.clickCharacteristic();
        if (!expenseCharacteristicsGA.ok()) fail("пустая таблица");

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

}
