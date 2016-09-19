package ru.dserg.autotest.test;





import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import ru.dserg.autotest.page.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static  com.codeborne.selenide.Selenide.screenshot;



/**
 * Created by Kalinin.S on 05.08.2016.
 */
public class EasyTest {
    Date d = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");



    @BeforeClass
    public static  void bfr(){
        for (File file: new File("build/reports/tests").listFiles())
            if (file.isFile()) file.delete();
    }
    @After
    public void aftr(){
        Menu.logOut();
    }


    @Test
    public void test(){

        LoginPage loginPage = new LoginPage();
        loginPage.typeUserName();
        loginPage.typePassword();
        HomePage homePage=loginPage.login();
        ShortModel shortModel=homePage.openKratkosrochSpisok(1);
        shortModel.create();
        shortModel.typeNameScenario("Мониторинг_"+format.format(d));
        shortModel.time();
        ShortScenario shortScenario = shortModel.createScenario();
        //shortScenario.getMain().changeTablePritok(0,1,"5");
        shortScenario.getMain().save();
        shortScenario.meteo();
        shortScenario.condition();
        shortScenario.getCondition().editTable(4,4,"ХР");
        shortScenario.result();
        shortScenario.getResults().showGA();
        shortScenario.getResults().optTime(1);
        shortScenario.getResults().play();
        shortScenario.back();
        screenshot("Ololo1");


    }



    @Test
    public void test1(){
        LoginPage loginPage = new LoginPage();
        loginPage.typeUserName();
        loginPage.typePassword();
        HomePage homePage=loginPage.login();
        OptimizationPage optimizationPage = homePage.openOptimization();
        optimizationPage.select(14);
        optimizationPage.show();
        screenshot("Ololo2");


    }

    @Ignore
    @Test
    public void test3(){
        LoginPage loginPage = new LoginPage();
        loginPage.typeUserName();
        loginPage.typePassword();
        HomePage homePage = loginPage.login();
        LongModel longModel = homePage.longModel();
        longModel.create();
        longModel.getCreate().name("test"+format.format(d));
        longModel.getCreate().beginDatePritok("2015-09-05");
        longModel.getCreate().beginDateCalculation("2015-09-15");
        longModel.getCreate().endDateCalculation("2015-09-25");
        LongScenario longScenario = longModel.getCreate().create();
        longScenario.characteristics();
        screenshot("Ololo3");
    }



}
