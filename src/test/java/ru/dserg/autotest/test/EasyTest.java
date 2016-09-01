package ru.dserg.autotest.test;





import org.junit.Ignore;
import org.junit.Test;
import ru.dserg.autotest.page.*;

import static  com.codeborne.selenide.Selenide.screenshot;



/**
 * Created by Kalinin.S on 05.08.2016.
 */
public class EasyTest {

    @Ignore
    @Test
    public void test(){

        LoginPage loginPage = new LoginPage();
        loginPage.typeUserName();
        loginPage.typePassword();
        HomePage homePage=loginPage.login();
        ShortModel shortModel=homePage.openKratkosrochSpisok(1);
        shortModel.create();
        shortModel.typeNameScenario("Name1507");
        ShortScenario shortScenario = shortModel.createScenario();
        shortScenario.getMain().changeTablePritok(0,1,"5");
        shortScenario.meteo();
        shortScenario.condition();
        shortScenario.result();
        shortScenario.getResults().play();
        shortScenario.back();
        screenshot("Ololo");


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


    }
    @Ignore
    @Test
    public void test3(){
        LoginPage loginPage = new LoginPage();
        loginPage.typeUserName();
        loginPage.typePassword();
        HomePage homePage=loginPage.login();
    }



}
