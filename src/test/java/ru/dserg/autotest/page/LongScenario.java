package ru.dserg.autotest.page;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import ru.dserg.autotest.page.LongModelElements.SpisoGES;
import ru.dserg.autotest.page.LongScenarioElements.Characteristics;
import ru.dserg.autotest.page.LongScenarioElements.Remont;
import ru.dserg.autotest.page.LongScenarioElements.Results;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 11.08.2016.
 */
public class LongScenario {
    private enum Tab{
        Results,Characteristics,Remont,Dg,Compensation,Limits,Hydraulicities,Graphics,Comparison,DisplayFilter,Settings
    }
    private Tab tab= Tab.Results;
    private SpisoGES spisoGES= new SpisoGES();
    private Characteristics characteristics = new Characteristics();
    private Remont remont = new Remont();
    private Results results = new Results();



    public void results(){
        $("#results").parent().click();
        tab= Tab.Results;
    }
    @Step("Переход на вкладку характеристики")
    public void characteristics(){
        $(By.xpath("//*[@id=\"main-content\"]/div/div[1]/div[1]/div[1]/div/label[2]")).click();
        tab = Tab.Characteristics;
    }

    public Characteristics getCharacteristics() {
        return(tab==Tab.Characteristics)? characteristics:null;
    }
    @Step("Выбор гес номер {0}")
    public void choiceGes(int choice){
        spisoGES.choice(choice);
    }

    public Results getResults() {
        return (tab==Tab.Results)? results: null;
    }
    @Step("Закрытие pnotify уведомления")
    public void pnotifyClose(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("document.body.removeChild(document.body.children[4]);");

    }
    public void remont(){
        $("#repairs").parent().click();
        tab = Tab.Remont;

    }

    public Remont getRemont() {
        return remont;
    }

}
