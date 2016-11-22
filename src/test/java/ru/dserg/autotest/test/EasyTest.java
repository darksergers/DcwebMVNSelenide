package ru.dserg.autotest.test;





import com.codeborne.selenide.Configuration;
import com.gurock.testrail.APIException;
import com.gurock.testrail.DDtestrail;
import org.junit.*;
import ru.dserg.autotest.Utils.Util;
import ru.dserg.autotest.page.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import static com.codeborne.selenide.Selenide.close;
import static  com.codeborne.selenide.Selenide.screenshot;



/**
 * Created by Kalinin.S on 05.08.2016.
 */

public class EasyTest {
    static Date d = new Date();
    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh-mm");
    private static HashMap data = new HashMap();



    @BeforeClass
    public static  void bfr(){
        for (File file: new File("build/reports/tests").listFiles())
            if (file.isFile()) file.delete();
        for (int i=0;i<3;i++){
            data.put(i,4);
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



    @Test
    public void testKratkosrochka() throws Exception {
        data.put(0,5);

        HomePage homePage=Util.entry();
        ShortModel shortModel=homePage.openKratkosrochSpisok(1);
        shortModel.create();
        shortModel.typeNameScenario("Мониторинг_"+format.format(d));
        shortModel.time();
        ShortScenario shortScenario = shortModel.createScenario();
        //shortScenario.getMain().changeTablePritok(0,1,"5");
        shortScenario.getMain().save();
        shortScenario.meteo();
        Util.pnotifyClose();
        shortScenario.condition();
        Util.pnotifyClose();
        shortScenario.getCondition().editTable(4,4,"ХР");
        shortScenario.result();
        shortScenario.getResults().showGA();
        shortScenario.getResults().optTime(1);
        shortScenario.getResults().play();
        screenshot("Ololo1");
        shortScenario.back();
        data.put(0,1);


    }






    @Test
    public void testOptimization() throws Exception {
        data.put(2,5);
        HomePage homePage=Util.entry();
        OptimizationPage optimizationPage = homePage.openOptimization();
        optimizationPage.select(14);
        optimizationPage.show();
        screenshot("Ololo2");
        data.put(2,1);


    }


    @Test
    public void testSrednesrochka() throws Exception {
        data.put(1,5);
        HomePage homePage=Util.entry();
        LongModel longModel = homePage.longModel();
        longModel.create();
        longModel.getCreate().name("test"+format.format(d));
        longModel.getCreate().beginDatePritok("2015-09-05");
        longModel.getCreate().beginDateCalculation("2015-09-15");
        longModel.getCreate().endDateCalculation("2015-09-25");
        LongScenario longScenario = longModel.getCreate().create();
        longScenario.characteristics();
        screenshot("Ololo3");
        data.put(1,1);
    }
   @AfterClass
    public static void testrail() throws IOException, APIException {

        //File myPath = new File("S:/Topics/ДРСК/Тестирование/DcWebScreenshot/Мониторинг"+format.format(d));
        //myPath.mkdir();
        //for (File file: new File("build/reports/tests").listFiles())
         //   if (file.isFile()) copy(file, Paths.get("S:/Topics/ДРСК/Тестирование/DcWebScreenshot/Мониторинг"+format.format(d)+"/"+file.getName()));

       //if(Configuration.baseUrl.equals("http://dc-web.vdrsk.digdes.com")) {
           DDtestrail testrail = new DDtestrail(58, 2537,Configuration.baseUrl.equals("http://dc-web.vdrsk.digdes.com"));
           testrail.completeTest(data, "Мониторинг" + format.format(d));
       //}
    }
    public static void copy(File source, Path dest) throws IOException {
        Files.copy(source.toPath(), dest);
    }


}
