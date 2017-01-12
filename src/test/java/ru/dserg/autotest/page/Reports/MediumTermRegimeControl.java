package ru.dserg.autotest.page.Reports;

import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 23.12.2016.
 */
public class MediumTermRegimeControl {

    @Step("Выбор Волжско-Камский каскад")
    public void  selectStation(){

        $("#filter-form").$(By.tagName("select")).selectOption("Волжско-Камский каскад");
}
    @Step("Нажатие применить")
    public void clickShowTable(){
        $("#show-table").click();
    }


}
