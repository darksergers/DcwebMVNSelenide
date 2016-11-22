package ru.dserg.autotest.test;

import com.codeborne.selenide.Configuration;
import com.gurock.testrail.APIException;
import com.gurock.testrail.DDtestrail;
import org.junit.*;
import ru.dserg.autotest.Utils.Util;
import ru.dserg.autotest.page.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import static com.codeborne.selenide.Selenide.close;
import static org.junit.Assert.fail;

/**
 * Created by Kalinin.S on 27.09.2016.
 */

public class MediumTermTest {

    static Date d = new Date();
    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH.mm");
    private static HashMap data = new HashMap();
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

    public void granularity(String granularity ) throws Exception {

        HomePage homePage=Util.entry();
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
    }





    @Test
    public void testCharacteristicsIsAvailable() throws Exception {
        data.put(0,5);
        HomePage homePage=Util.entry();
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
        data.put(0,1);
    }





    @Test
    public void testGranularityMonth() throws Exception {
        data.put(1,5);
        granularity("Месяц");
        data.put(1,1);

    }



    @Test
    public void testGranularityPentada() throws Exception {
        data.put(2,5);
        granularity("Пентада");
        data.put(2,1);
    }



    @Test
    public void testGranularityDecada() throws Exception {
        data.put(3,5);
        granularity("Декада");
        data.put(3,1);
    }


    @Ignore
    @Test
    public void testHoldMode() throws Exception {
        data.put(4,5);
        HomePage homePage=Util.entry();
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
        data.put(4,1);


    }



    @Test
    public void testRemont() throws Exception {
        data.put(5,5);
        HomePage homePage=Util.entry();
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
        data.put(5,1);


    }
    @BeforeClass
    public static  void bfr(){
        for (int i=0;i<6;i++){
            data.put(i,4);
        }
    }
    @AfterClass
    public static void testrail() throws IOException, APIException {
        close();
        //File myPath = new File("S:/Topics/ДРСК/Тестирование/DcWebScreenshot/Мониторинг"+format.format(d));
        //myPath.mkdir();
        //for (File file: new File("build/reports/tests").listFiles())
        //   if (file.isFile()) copy(file, Paths.get("S:/Topics/ДРСК/Тестирование/DcWebScreenshot/Мониторинг"+format.format(d)+"/"+file.getName()));

        //if(Configuration.baseUrl.equals("http://dc-web.vdrsk.digdes.com")) {
            DDtestrail testrail = new DDtestrail(58, 2544,Configuration.baseUrl.equals("http://dc-web.vdrsk.digdes.com"));
            testrail.completeTest(data, "Среднесрочка" + format.format(d));
        //}

    }

    /*@Test
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
*/


}
