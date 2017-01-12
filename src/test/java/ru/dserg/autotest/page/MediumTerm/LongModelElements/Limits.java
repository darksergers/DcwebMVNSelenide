package ru.dserg.autotest.page.MediumTerm.LongModelElements;

import org.openqa.selenium.By;
import ru.dserg.autotest.Utils.SelenideTable;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 11.08.2016.
 * класс описывающий ограничения
 */
public class Limits {
    private SelenideTable table = new SelenideTable($("#limit-table").$(By.tagName("table")));//
    /**
     * кнопка вернуться
     */
    public void  back(){
       $("#back-to-cascade").click();
    }



    /**
     * кнопка сохранить
     */
    public void save(){
        $("#save-static-limits").click();
    }

    /**
     * Внести данные в таблицу
     */
    public void editTable(int str, int rows,String text) throws Exception {
        table.typeInTable(str,rows,"#limit-table > div.handsontableInputHolder > textarea",text);
    }


}
