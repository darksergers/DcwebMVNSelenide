package ru.dserg.autotest.page;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import ru.dserg.autotest.Utils.Util;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Kalinin.S on 05.08.2016.
 */
public class LoginPage {

    public void typeUserName() {
       $(By.name("UserName")).setValue("Weber");
    }

    public LoginPage() {
        System.setProperty("webdriver.chrome.driver","C:\\tools\\chromedriver.exe");
        Configuration.baseUrl="http://dc-web.vdrsk.digdes.com:8099";
        Configuration.browser="chrome";
        open(Configuration.baseUrl);
    }
//-Dwebdriver.chrome.driver=C:\tools\chromedriver.exe -Dselenide.baseUrl=http://dc-web.vdrsk.digdes.com


    public void typePassword(){
        $(By.name("Password")).setValue("Weber");
    }

public HomePage login() throws Exception {
$(By.xpath("//*[@id=\'main\']/form/div/fieldset/p/input")).click();
    Util.findError();
    return new HomePage();
}

}
