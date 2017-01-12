package ru.dserg.autotest.page.ShortTerm.ShortScenarioElements;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import ru.dserg.autotest.Utils.SelenideTable;
import ru.dserg.autotest.Utils.Util;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 08.08.2016.
 */
public class Main {//описывает главную вкладку
    private SelenideTable tablePritok =
            new SelenideTable($(By.xpath("//*[@id='inflow-table']/div[1]/div[1]/div/div[1]/table")));
    private SelenideTable tablePodpor =
            new SelenideTable($(By.xpath("//*[@id='backwater-table']/div[1]/div[1]/div/div[1]/table")));

    public void changeTablePritok(int str, int rows,String number) throws Exception {//внести значение в ячейку пргнз притока
        tablePritok.typeInTable(str, rows,"#inflow-table > div.handsontableInputHolder > textarea",number);
    }




    public void changeTablePodpor(int str,String number) throws Exception {//внести значение в ячейку пргнз подпора
        tablePodpor.typeInTable(str, 1,"#backwater-table > div.handsontableInputHolder > textarea",number);
    }
    public void typeName(String str) {//внести  название сценария
        Util.typeText($("#name"),str );

    }
    public  void refreshPritok(){//обновить прогноз притока
        $("#inflow-refresh").click();

    }
    public void refreshPodpor(){//обновить прогноз подпора
        $("#backwater-refresh").click();
    }
    @Step("Нажатие кнопки сохранить")
    public void save(){//кнопка сохранить
        $("#save-button").waitUntil(Condition.visible,30000);
        $("#save-button").click();
    }
    public void select(int select){//выбрать суточные или часовые значения
       $("#inflowDiscretness").click();
        Util.selectSelelector($("#inflowDiscretness"),select);
    }

}
