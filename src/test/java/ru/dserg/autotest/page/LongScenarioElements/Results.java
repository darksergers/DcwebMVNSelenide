package test.page.LongScenarioElements;

import org.openqa.selenium.By;
import test.Utils.SelenideTable;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 11.08.2016.
 */
public class Results {
    SelenideTable table= new SelenideTable($(By.xpath("//*[@id='results-table']/div[1]/div[2]/div/div/div[1]/table")));

    public void play(){
        $("#calculate-button").click();
    }
    public void refresh(){
       $("#refresh-button") .click();

    }
    public void export(int choice){
        $("#grid-region > div > div:nth-child(1) > div:nth-child(1) > div > div.col-md-7 > div > div > button").click();
        $(By.xpath("//*[@id=\"grid-region\"]/div/div[1]/div[1]/div/div[1]/div/div/ul"))
                .$(By.tagName("a"),choice).click();

    }
    public void checkLimits(){
        $("#use-limits").click();
    }


}
