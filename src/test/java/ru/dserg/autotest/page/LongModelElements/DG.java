package test.page.LongModelElements;

import test.page.LongModel;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 11.08.2016.
 */
public class DG {

    public void back(LongModel model){//вернуться на основную страницу
        $("#back-button").click();
        model.setTab();
    }
    public void create(){
        $("#create-button").click();
    }

}
