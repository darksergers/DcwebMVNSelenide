package ru.dserg.autotest.page.Manuals;

import org.openqa.selenium.By;
import ru.dserg.autotest.Utils.SelenideTable;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 02.11.2016.
 */
public class DataDirectoryGES {
    SelenideTable table = new SelenideTable($(By.className("table")));

    public CardGES volges(){
        table.choiceTr(11,0).$(By.tagName("a")).click();
        return new CardGES();
    }
}