package ru.dserg.autotest.Utils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 06.08.2016.
 */
public class SelenideTable {

    private SelenideElement element;

    public SelenideTable(SelenideElement element) {
        this.element = element;
    }//передается таблица!! не тело таблицы
    public SelenideElement choiceTr(int str,int rows){
        return element.$(By.tagName("tr"),str+1).$(By.tagName("td"),rows);//функция возвращающая элемент
    }

    public void typeInTable(int str, int rows, String query, String number){//функция для заполнения тамблицы
        choiceTr(str, rows).doubleClick();
        choiceTr(str, rows).click();
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript(
                "var textarea= document.querySelector('"+query+"') ;"+
                        "textarea.value="+number+";");//если исполюзуется дробное число через запятую/текст требуется' '
        //либо через точку так как передается напрямую без ковычек
        choiceTr(str, rows).pressEnter();

    }
    }

