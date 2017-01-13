package ru.dserg.autotest.test;





import com.codeborne.selenide.Configuration;
import com.gurock.testrail.DDtestrail;
import org.junit.*;
import ru.dserg.autotest.Utils.Util;
import ru.dserg.autotest.page.*;
import ru.dserg.autotest.page.MediumTerm.LongModel;
import ru.dserg.autotest.page.MediumTerm.LongScenario;
import ru.dserg.autotest.page.ShortTerm.OptimizationPage;
import ru.dserg.autotest.page.ShortTerm.ShortModel;
import ru.dserg.autotest.page.ShortTerm.ShortScenario;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;

import static  com.codeborne.selenide.Selenide.screenshot;



/**
 * Created by Kalinin.S on 05.08.2016.
 */
@Features("Мониторинг")
public class EasyTest {
    static Date d = new Date();
    static HashMap dataError = new HashMap();
    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH.mm");
    private static HashMap data = new HashMap();
    static SimpleDateFormat currentF = new SimpleDateFormat("yyyy-MM-dd");
    private static GregorianCalendar g;
    private static  String today;
    private static  String tenDaysLater;



    @BeforeClass
    public static  void bfr(){
        if (Configuration.baseUrl.equals("http://dc-web.vdrsk.digdes.com:8099")){
            g=new GregorianCalendar(2015,8,5);
            today = currentF.format(g.getTime());

        }else{
            g=new GregorianCalendar();
            today=currentF.format(d);

        }
        g.add(Calendar.DAY_OF_MONTH,10);
        tenDaysLater = currentF.format(g.getTime());
        for (File file: new File("build/reports/tests").listFiles())
            if (file.isFile()) file.delete();

        for (int i=0;i<3;i++){
            data.put(i,4);
            dataError.put(i,"Все ок");
        }
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




    @Stories("Мониторинг краткосрочки")
    @Test
    public void testKratkosrochka() throws Exception {
        data.put(0,5);
        try {


            HomePage homePage = Util.entry();
            ShortModel shortModel = homePage.openKratkosrochSpisok(1);
            shortModel.create();
            shortModel.typeNameScenario("Autotest Мониторинг_" + format.format(d));
            shortModel.time(today);
            ShortScenario shortScenario = shortModel.createScenario();
            shortScenario.getMain().save();
            shortScenario.meteo();
            Util.pnotifyClose();
            shortScenario.condition();
            Util.pnotifyClose();
            shortScenario.getCondition().editTable(4, 4, "ХР");
            shortScenario.result();
            shortScenario.getResults().showGA();
            shortScenario.getResults().optTime(1);
            shortScenario.getResults().play();
            screenshot("Ololo1");
            shortScenario.back();
            Util.attachImage("build/reports/tests/Ololo1.png");
            data.put(0, 1);
        } catch (Throwable e){
            dataError.put(0,e.getMessage());
            throw e;
        }



    }






    @Stories("Мониторинг оптимизации")
    @Test
    public void testOptimization() throws Exception {
        data.put(2,5);
        try {
            HomePage homePage = Util.entry();
            OptimizationPage optimizationPage = homePage.openOptimization();
            optimizationPage.select(14);
            optimizationPage.show();
            screenshot("Ololo2");
            Util.attachImage("build/reports/tests/Ololo2.png");
            data.put(2, 1);
        } catch (Throwable e){
            dataError.put(2,e.getMessage());
            throw e;
        }


    }


    @Stories("Мониторинг среднесрочки")
    @Test
    public void testSrednesrochka() throws Exception {

        data.put(1,5);
        try {

            HomePage homePage=Util.entry();
            LongModel longModel = homePage.longModel();
            longModel.create();
            longModel.getCreate().name("AutotestMonitoring"+format.format(d));
            longModel.getCreate().beginDatePritok(today);
            longModel.getCreate().beginDateCalculation(tenDaysLater);
            longModel.getCreate().endDateCalculation(tenDaysLater);
            LongScenario longScenario = longModel.getCreate().create();
            longScenario.characteristics();
            screenshot("Ololo3");
            Util.attachImage("build/reports/tests/Ololo3.png");
            data.put(1,1);
    } catch (Throwable e){
            dataError.put(1,e.getMessage());
            throw e;
    }
    }
   @AfterClass
    public static void testrail() throws Exception {



       //DDtestrail testrail = new DDtestrail(58, 2537,Configuration.baseUrl.equals("http://dc-web.vdrsk.digdes.com:8099"));
       //testrail.completeTest(data,dataError, "Мониторинг "+Configuration.baseUrl +" "+ format.format(d));
       HomePage homePage=Util.entry();
       ShortModel shortModel = homePage.openKratkosrochSpisok(1);
       shortModel.delete();

        //File myPath = new File("S:/Topics/ДРСК/Тестирование/DcWebScreenshot/Мониторинг"+format.format(d));
        //myPath.mkdir();
        //for (File file: new File("build/reports/tests").listFiles())
         //   if (file.isFile()) copy(file, Paths.get("S:/Topics/ДРСК/Тестирование/DcWebScreenshot/Мониторинг"+format.format(d)+"/"+file.getName()));

       //if(Configuration.baseUrl.equals("http://dc-web.vdrsk.digdes.com")) {

       //}
    }
    public static void copy(File source, Path dest) throws IOException {
        Files.copy(source.toPath(), dest);
    }


}
