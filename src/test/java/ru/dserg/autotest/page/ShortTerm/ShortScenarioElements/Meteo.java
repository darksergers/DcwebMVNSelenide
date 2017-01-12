package ru.dserg.autotest.page.ShortTerm.ShortScenarioElements;

import org.openqa.selenium.By;
import ru.dserg.autotest.Utils.SelenideTable;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 08.08.2016.
 */
public class Meteo {

    private SelenideTable tableWind=
            new SelenideTable($(By.xpath("//*[@id='windsurge-table']/div[1]/div[1]/div/div[1]/table")));
    private SelenideTable tablePressure=
            new SelenideTable($(By.xpath("//*[@id='avgatm-table']/div[1]/div[1]/div/div[1]/table")));
    private SelenideTable tableTemperature=
            new SelenideTable($(By.xpath("//*[@id='avgtemperature-table']/div[1]/div[1]/div/div[1]/table")));




    public void changeTableWind(int str,String number) throws Exception {//внести значение в ячейку таблицы ветровой нагон

        tableWind.typeInTable(str,1,"#windsurge-table > div.handsontableInputHolder > textarea",number);
    }
    public void changeTablePressure(int str, int rows,String number) throws Exception {//внести значение в ячейку среднее атмосферное...
        tablePressure.typeInTable(str,rows,"#avgatm-table > div.handsontableInputHolder > textarea",number);
    }
    public void changeTableTemperature(int str,String number) throws Exception {//внести значение в ячейку средняя тепература

        tableTemperature.typeInTable(str,1,"#avgtemperature-table > div.handsontableInputHolder > textarea",number);
    }
    public  void reefreshMeteo(){//кнопка загрузить данные о погоде
        $("#refresh-meteo").click();
    }
    public void save(){//кнопка сохранить
        $("#save").click();
    }

}
