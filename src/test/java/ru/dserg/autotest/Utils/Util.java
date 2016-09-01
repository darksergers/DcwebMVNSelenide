package ru.dserg.autotest.Utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 08.08.2016.
 */
public class Util {

    static public void  typeText(SelenideElement element, String str){

        element.click();
        element.clear();
        element.setValue(str);
    }


    static public  SelenideElement selectSelelector(SelenideElement element,int choice ){

        return element.$(By.tagName("option"),choice);
    }

    static public void choiseDate(SelenideElement element,String day,String month){
        element.click();
        element.sendKeys(day);
        element.sendKeys(month);
    }

}
