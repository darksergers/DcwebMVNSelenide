package ru.dserg.autotest.Utils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import ru.dserg.autotest.page.HomePage;
import ru.dserg.autotest.page.LoginPage;
import ru.dserg.autotest.page.Menu;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

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

    static public void choiceDate(String selector, String date){
        /**
         * выбор даты, формат даты yyyy-mm-dd
         */
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript(
                "document.querySelector('input"+selector+"') " + ".value='"+date+"';");

    }
    static public void findError() throws Exception {
        ElementsCollection collection=$$(By.className("ui-pnotify "));
        if (collection.isEmpty()) return;
        for (SelenideElement i: collection){
            if(i.$(By.className("glyphicon-warning-sign")).exists()){

            throw new Exception("pnotify exception:"+i.$(By.className("ui-pnotify-text")).getText());
        }

        }

    }
    static public void pnotifyClose(){

        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("var a = document.getElementsByClassName(\"ui-pnotify\");" +
                "for (var i = a.length-1 ;i >= 0; i--){" +
                "document.body.removeChild(a[i]);" +
                "}");

    }
    static public HomePage entry() throws Exception {
        HomePage homePage;
        LoginPage loginPage = new LoginPage();
        try {
        loginPage.typeUserName();
        loginPage.typePassword();
        homePage = loginPage.login();
        } catch (NoSuchElementException e) {
          homePage =  new HomePage();
        }

          return  homePage;

    }

}
