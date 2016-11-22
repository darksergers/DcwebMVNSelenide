package ru.dserg.autotest.page.Reports;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import ru.dserg.autotest.Utils.SelenideTable;
import ru.dserg.autotest.Utils.Util;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 11.11.2016.
 */
public class AvailablePowerReport {
    SelenideTable table= new SelenideTable($("#ap-report-content").$(By.tagName("table")));
    public void selectStation(){
        $("#station").selectOption("Волжская ГЭС");
    }
    public void beginDate(){
        Util.choiceDate("#beginDate","2016-11-09");
    }
    public void endDate(){
        Util.choiceDate("#endDate","2016-11-10");
    }
    public void selectStepSize(){
        $("#stepSize").selectOption("60");
    }
    public void clickApplyButton() throws Exception {
        $("#apply-button").click();
        Util.findError();
    }
    public void completeDH(){
        $("#ap-report-content").$(By.tagName("tbody")).waitUntil(Condition.visible,30000);
        for (int i = 0;i<$("#ap-report-content").$(By.tagName("tbody")).$$(By.tagName("tr")).size()-1;i++){
            table.typeInTable(i,4,"#ap-report-content > div.handsontableInputHolder > textarea","1.5");
        }

    }
    public void clickCountButton() throws Exception {
        ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        $("#count-button").click();
        Util.findError();

    }
    public boolean ok(){

        for (int i = 0;i<$("#ap-report-content").$(By.tagName("tbody")).$$(By.tagName("tr")).size()-1;i++){
            for(int j = 6; j<10;j++){
                if(Float.parseFloat(table.choiceTr(i,j).getText().replace(',','.'))<=0) return  false;

            }
        }
        for(int i = 0; i<$("#ap-report-content").$(By.tagName("tbody")).$$(By.tagName("tr")).size()-1;i++){
            if(Float.parseFloat(table.choiceTr(i,13).getText().replace(',','.'))>20) return  false;
        }
        return true;
    }


    }
