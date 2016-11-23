package ru.dserg.autotest.test;

import com.codeborne.selenide.Configuration;
import com.gurock.testrail.APIException;
import com.gurock.testrail.DDtestrail;
import org.junit.*;
import ru.dserg.autotest.Utils.Util;
import ru.dserg.autotest.page.HomePage;
import ru.dserg.autotest.page.LoginPage;
import ru.dserg.autotest.page.Manuals.CardGES;
import ru.dserg.autotest.page.Manuals.DataDirectoryGES;
import ru.dserg.autotest.page.Manuals.ExpenseCharacteristicsGA;
import ru.dserg.autotest.page.Menu;
import ru.dserg.autotest.page.ShortModel;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.fail;

/**
 * Created by Kalinin.S on 02.11.2016.
 */
public class ManualsTest {
    static Date d = new Date();
    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH.mm");
    private static HashMap data = new HashMap();



    @BeforeClass
    public static  void bfr(){

        for (int i=0;i<2;i++){
            data.put(i,4);
        }
    }

    @Test
    public void testDataDirectoryGES() throws Exception {

        data.put(0,5);
        HomePage homePage= Util.entry();
        DataDirectoryGES dataDirectoryGES =  homePage.dataDirectoryGES();
        CardGES cardGES=dataDirectoryGES.volges();
        cardGES.rgeOk();
        cardGES.gtpOk();
        cardGES.gaOk();
        data.put(0,1);
    }

    @Test
    public void testExpenseCharacteristicsGA() throws Exception {

        data.put(1,5);
        HomePage homePage=Util.entry();
        ExpenseCharacteristicsGA expenseCharacteristicsGA = homePage.expenseCharacteristicsGA();
        expenseCharacteristicsGA.choice();
        expenseCharacteristicsGA.clickCharacteristic();
        if (!expenseCharacteristicsGA.ok()) fail("пустая таблица");
        data.put(1,1);

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


        DDtestrail testrail = new DDtestrail(58, 2559, Configuration.baseUrl.equals("http://dc-web.vdrsk.digdes.com:8099"));
        testrail.completeTest(data, "Справочники "+Configuration.baseUrl + format.format(d));

    }

}
