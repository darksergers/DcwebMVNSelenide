package ru.dserg.autotest.page.Manuals;

import ru.dserg.autotest.page.Manuals.CardGESElements.GA;
import ru.dserg.autotest.page.Manuals.CardGESElements.GTP;
import ru.dserg.autotest.page.Manuals.CardGESElements.RGE;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 02.11.2016.
 */
public class CardGES {

    RGE rge = new RGE();
    GTP gtp = new GTP();
    GA ga = new GA();
    @Step("Переход на вкладку РГЕ")
    public void rgeOk() throws Exception {
        $("#rge-tab").parent().click();
        rge.rowsExist();
    }
    @Step("Переход на вкладку ГТП")
    public  void  gtpOk() throws Exception {

        $("#gtp-tab").parent().click();
        gtp.rowsExist();
    }
    @Step("Переход на вкладку ГА")
    public void gaOk() throws Exception {

        $("#ga-tab").parent().click();
        ga.rowsExist();
    }

}
