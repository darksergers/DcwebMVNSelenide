package ru.dserg.autotest.page.LongModelElements;

import org.openqa.selenium.By;
import ru.dserg.autotest.Utils.SelenideTable;
import ru.dserg.autotest.page.LongModel;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 09.08.2016.
 */
public class Settings {
    SelenideTable table=
            new SelenideTable($(By.xpath("//*[@id=\'ht_18c7912a26d78d02\']/div[1]/div[2]/div/div/div[1]/table")));

    public void back(LongModel model){//вернуться на основную страницу
        $("#back-button").click();
        model.setTab();
    }
    public void setTable(int str,int rows,String s) throws Exception {
        table.choiceTr(str,rows).setValue(s);
    }
    public void save(){
        $("#save-button").click();
    }
}
