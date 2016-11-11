package ru.dserg.autotest.page.Reports;

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
    public void clickApplyButton(){
        $("#apply-button").click();
    }
    public void completeDH(){
        for (int i = 0;i<$("#ap-report-content").$(By.tagName("tbody")).$$(By.tagName("tr")).size()-1;i++){
            table.typeInTable(i,4,"#ap-report-content > div.handsontableInputHolder > textarea","1.5");
        }

    }
    public void clickCountButton(){
        ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        $("#count-button").click();

    }


    }
