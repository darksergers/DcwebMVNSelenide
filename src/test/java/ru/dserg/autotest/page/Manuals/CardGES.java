package ru.dserg.autotest.page.Manuals;

import ru.dserg.autotest.page.Manuals.CardGESElements.GA;
import ru.dserg.autotest.page.Manuals.CardGESElements.GTP;
import ru.dserg.autotest.page.Manuals.CardGESElements.RGE;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 02.11.2016.
 */
public class CardGES {

    RGE rge = new RGE();
    GTP gtp = new GTP();
    GA ga = new GA();
    public void rgeOk(){
        $("#rge-tab").parent().click();
        rge.rowsExist();
    }
    public  void  gtpOk(){

        $("#gtp-tab").parent().click();
        gtp.rowsExist();
    }
    public void gaOk(){

        $("#ga-tab").parent().click();
        ga.rowsExist();
    }

}
