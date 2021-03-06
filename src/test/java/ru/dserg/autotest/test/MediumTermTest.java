package ru.dserg.autotest.test;

import com.codeborne.selenide.Configuration;
import com.gurock.testrail.DDtestrail;
import org.junit.*;
import ru.dserg.autotest.Utils.Util;
import ru.dserg.autotest.page.*;
import ru.dserg.autotest.page.MediumTerm.LongModel;
import ru.dserg.autotest.page.MediumTerm.LongScenario;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import static com.codeborne.selenide.Selenide.screenshot;
import static org.junit.Assert.fail;

/**
 * Created by Kalinin.S on 27.09.2016.
 */
@Features("Среднесрочная модель")
public class MediumTermTest {

    private static Date d = new Date();
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH.mm");
    private static SimpleDateFormat currentF = new SimpleDateFormat("yyyy-MM-dd");
    private static HashMap<Integer,String> dataError = new HashMap<Integer,String>();
    private static HashMap<Integer,Integer> data = new HashMap<Integer,Integer>();
    private static  String today;
    private static  String tenDaysLater;
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

    private void granularity(String granularity ) throws Exception {

        HomePage homePage=Util.entry();
        LongModel longModel = homePage.longModel();
        Util.findError();
        longModel.create();
        longModel.getCreate().beginDatePritok(today);
        longModel.getCreate().beginDateCalculation(today);
        longModel.getCreate().endDateCalculation(tenDaysLater);
        longModel.getCreate().granularity(granularity);
        longModel.getCreate().name("AutotestGranularity "+granularity+format.format(d));
        longModel.getCreate().create();
        Util.findError();
    }




    @Stories("Работоспособность характеристик (открываются)")
    @Test
    public void testCharacteristicsIsAvailable() throws Exception {
        data.put(0,5);
        try{
        HomePage homePage=Util.entry();
        LongModel longModel = homePage.longModel();
        Util.findError();
        longModel.create();
        longModel.getCreate().name("AutotestCharacteristicsIsAvailable"+format.format(d));
            longModel.getCreate().beginDatePritok(today);
            longModel.getCreate().beginDateCalculation(today);
            longModel.getCreate().endDateCalculation(tenDaysLater);
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
        } catch (Throwable e){
            screenshot("Error");
            Util.attachImage("build/reports/tests/Error.png");
            dataError.put(0,e.getMessage());
            throw e;
        }
    }




    @Stories("Гранулярность")
    @Test
    public void testGranularityMonth() throws Exception {
        data.put(1,5);
        try {
        granularity("Месяц");
        data.put(1,1);
        } catch (Throwable e){
            screenshot("Error1");
            Util.attachImage("build/reports/tests/Error1.png");
            dataError.put(1,e.getMessage());
            throw e;
        }

    }


    @Stories("Гранулярность")
    @Test
    public void testGranularityPentada() throws Exception {
        data.put(2,5);
        try {
        granularity("Пентада");
        data.put(2,1);
        } catch (Throwable e){
            screenshot("Error2");
            Util.attachImage("build/reports/tests/Error2.png");
            dataError.put(2,e.getMessage());
            throw e;
        }
    }


    @Stories("Гранулярность")
    @Test
    public void testGranularityDecada() throws Exception {
        data.put(3,5);
        try {
        granularity("Декада");
        data.put(3,1);
        } catch (Throwable e){
            screenshot("Error3");
            Util.attachImage("build/reports/tests/Error3.png");
            dataError.put(3,e.getMessage());
            throw e;
        }
    }


    @Stories("Выдерживание режима")
    @Test
    public void testHoldMode() throws Exception {
        data.put(4,5);
        try {
        HomePage homePage=Util.entry();
        LongModel longModel = homePage.longModel();
        longModel.create();
        longModel.getCreate().name("AutotestHold"+format.format(d));
        longModel.getCreate().beginDatePritok(today);
        longModel.getCreate().beginDateCalculation(today);
        longModel.getCreate().endDateCalculation(tenDaysLater);
        LongScenario longScenario = longModel.getCreate().create();
        longScenario.pnotifyClose();
        longScenario.choiceGes(3);
        longScenario.getResults().typeInTable(0,"ZВБкон",6,"120");

        longScenario.getResults().typeInTable(1,"QНБ",3,"100");

        longScenario.getResults().typeInTable(2,"NГЭС",4,"10");
        longScenario.getResults().typeInTable(3,"ЭГЭС",4,"0.2");
        longScenario.getResults().choiceDg(4);
       longScenario.getResults().play();

        data.put(4,1);
        } catch (Throwable e){
            screenshot("Error4");
            Util.attachImage("build/reports/tests/Error4.png");
            dataError.put(4,e.getMessage());
            throw e;
        }


    }


    @Stories("Учёт ремонтов")
    @Test
    public void testRemont() throws Exception {
        data.put(5,5);
        try {
        HomePage homePage=Util.entry();
        LongModel longModel = homePage.longModel();
        longModel.create();
        longModel.getCreate().name("AutotestRemont"+format.format(d));
        longModel.getCreate().beginDatePritok(today);
        longModel.getCreate().beginDateCalculation(today);
        longModel.getCreate().endDateCalculation(tenDaysLater);
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
        } catch (Throwable e){
            screenshot("Error5");
            Util.attachImage("build/reports/tests/Error5.png");
            dataError.put(5,e.getMessage());
            throw e;
        }


    }
    @BeforeClass
    public static  void bfr(){
        GregorianCalendar g;
        if (Configuration.baseUrl.equals("http://dc-web.vdrsk.digdes.com:8099")){
            g=new GregorianCalendar(2015,8,5);
            today = currentF.format(g.getTime());

        }else{
            g=new GregorianCalendar();
            today=currentF.format(d);

        }


        g.add(Calendar.DAY_OF_MONTH,10);
        tenDaysLater = currentF.format(g.getTime());

        for (int i=0;i<6;i++){
            data.put(i,4);
            dataError.put(i,"Все ок");
        }
    }
    @AfterClass
    public static void testrail() throws Exception {
       DDtestrail testrail = new DDtestrail(58, 2544,Configuration.baseUrl.equals("http://dc-web.vdrsk.digdes.com:8099"));
       testrail.completeTest(data,dataError, "Среднесрочка "+Configuration.baseUrl+" "+ format.format(d));

        HomePage homePage=Util.entry();
        LongModel longModel = homePage.longModel();
        longModel.deleteScenario("Autotest");




        //File myPath = new File("S:/Topics/ДРСК/Тестирование/DcWebScreenshot/Мониторинг"+format.format(d));
        //myPath.mkdir();
        //for (File file: new File("build/reports/tests").listFiles())
        //   if (file.isFile()) copy(file, Paths.get("S:/Topics/ДРСК/Тестирование/DcWebScreenshot/Мониторинг"+format.format(d)+"/"+file.getName()));

        //if(Configuration.baseUrl.equals("http://dc-web.vdrsk.digdes.com")) {
          // DDtestrail testrail = new DDtestrail(58, 2544,Configuration.baseUrl.equals("http://dc-web.vdrsk.digdes.com:8099"));
           //testrail.completeTest(data, "Среднесрочка "+Configuration.baseUrl+" "+ format.format(d));
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
