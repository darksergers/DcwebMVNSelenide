package test.page;

import org.openqa.selenium.By;
import test.Utils.SelenideTable;
import test.page.ShortScenarioElements.Condition;
import test.page.ShortScenarioElements.Main;
import test.page.ShortScenarioElements.Meteo;
import test.page.ShortScenarioElements.Results;

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

    public  void   result(){
        $(By.xpath("//*[@id=\'main-content\']/div/div/div[1]/div/div/label[6]")).click();
        tab= Tab.Results;
    }

    /*public  void play(){
        $("#start-calculation").click();
    }*/
    public void back(){
        $(By.xpath("//*[@id=\'main-content\']/div/div/div[1]/div/div/label[1]")).click();
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
    public Results getResults(){
        if (tab==Tab.Results)return results;
        return null;
    }
    public void  main(){
        $(By.xpath("//*[@id=\'main-content\']/div/div/div[1]/div/div/label[2]")).click();
        tab=Tab.Main;
    }
    public void meteo(){
     $(By.xpath("//*[@id=\'main-content\']/div/div/div[1]/div/div/label[3]")).click();
        tab=Tab.Meteo;
    }
    public void condition(){
        $(By.xpath("//*[@id=\'main-content\']/div/div/div[1]/div/div/label[4]")).click();
        tab=Tab.Condition;
    }

}
