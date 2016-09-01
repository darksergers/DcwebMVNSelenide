package ru.dserg.autotest.page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Kalinin.S on 05.08.2016.
 */
public class LoginPage {
    private boolean isFirst;
    public void typeUserName() {
       $(By.name("UserName")).setValue("Weber");

    }

    public LoginPage() {
        open("http://dc-web.vdrsk.digdes.com/");
    }



    public void typePassword(){
        $(By.name("Password")).setValue("Weber");
    }

public HomePage login(){
$(By.xpath("//*[@id=\'main\']/form/div/fieldset/p/input")).click();
    return new HomePage();
}

}
