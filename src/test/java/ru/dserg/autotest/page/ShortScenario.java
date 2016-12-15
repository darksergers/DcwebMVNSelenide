package ru.dserg.autotest.page;

import org.openqa.selenium.By;
import ru.dserg.autotest.Utils.Util;
import ru.dserg.autotest.page.ShortScenarioElements.*;
import ru.yandex.qatools.allure.annotations.Step;


import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 05.08.2016.
 */
public class ShortScenario {
    /*private SelenideTable table= new SelenideTable($(By.xpath("//*[@id=\"inflow-table\"]/div[1]/div[1]/div/div[1]/table")));
    public void clickTable(int str,int rows){
        table.choiceTr(str,rows).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {

        }
    }*/
    private Condition condition= new Condition();
    private Main main = new Main();
    private Meteo meteo= new Meteo();
    private Results results  = new Results();
    private enum Tab{
        Main,Condition,Meteo,Results
    }
    private Tab tab=Tab.Main;
    @Step("Переход на вкладку результаты")
    public  void   result() throws Exception {
        $(By.xpath("//*[@id=\'main-content\']/div/div/div[1]/div/div/label[6]")).click();
        tab= Tab.Results;
        Util.findError();
    }

    /*public  void play(){
        $("#start-calculation").click();
    }*/
    @Step("Возврат к списку сценариев")
    public void back() throws Exception {
        $(By.xpath("//*[@id=\'main-content\']/div/div/div[1]/div/div/label[1]")).click();
        Util.findError();
    }

    public Main getMain(){
        if (tab==Tab.Main)return main;
        return null;
    }
    public Condition getCondition(){
        if (tab==Tab.Condition)return condition;
        return null;
    }
    public Meteo getMeteo(){
        if (tab==Tab.Meteo)return meteo;
        return null;
    }
    public Results getResults() throws Exception {
        if (tab==Tab.Results)return results;
        return null;

    }
    public void  main() throws Exception {
        $(By.xpath("//*[@id=\'main-content\']/div/div/div[1]/div/div/label[2]")).click();
        tab=Tab.Main;
        Util.findError();
    }
    @Step("Переход на вкладку прогноз погоды")
    public void meteo() throws Exception {
     $(By.xpath("//*[@id=\'main-content\']/div/div/div[1]/div/div/label[3]")).click();
        tab=Tab.Meteo;
        Util.findError();
    }
    @Step("Переход на вкладку состояние ГА")
    public void condition() throws Exception {
        $(By.xpath("//*[@id=\'main-content\']/div/div/div[1]/div/div/label[4]")).click();
        tab=Tab.Condition;
        Util.findError();
    }

}
