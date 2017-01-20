package ru.dserg.autotest.page.MediumTerm;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.dserg.autotest.page.MediumTerm.LongModelElements.*;
import ru.dserg.autotest.page.MediumTerm.LongScenarioElements.Characteristics;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Kalinin.S on 11.08.2016.
 */
public class LongModel {
    private enum Tab{
        Main,Create,Characteristics,Settings,Dg,Limits
    }
    private Tab tab = Tab.Main;
    private Create create=new Create();
    private Characteristics characteristics = new Characteristics();
    private DG dg = new DG();
    private Limits limits = new Limits();
    private Settings settings = new Settings();

    @Step("открытие формы для создания среднесрочного сценария")
    public void create(){//кликнуть по кнопки создать
        $(By.className("create-button")).click();
        tab=Tab.Create;

    }
    public void charakteristiki(){//по кнопке характерестики

        $("#static-characteristics").click();
        tab=Tab.Characteristics;
    }
    public void settings(){//по кнопке настройки

        $("#precisions").click();
        tab=Tab.Settings;
    }
    public void  clickDG(){//по кнопке ДГ

        $("#disp-graphs").click();
        tab=Tab.Dg;
    }
    public void limits(){//по кнопке ограничения

        $("#static-limits").click();
        tab=Tab.Limits;
    }

    public void setTab() {

        tab=Tab.Main;
    }

    public Create getCreate(){
       if (tab ==Tab.Create)return create;
        return null;
    }

    public Characteristics getCharacteristics() {
        if (tab ==Tab.Create) return characteristics;
        return null;
    }

    public DG getDg() {
        if (tab ==Tab.Create)return dg;
        return null;
    }

    public Limits getLimits() {
        if (tab ==Tab.Create) return limits;
        return null;
    }

    public Settings getSettings() {
        if (tab ==Tab.Create)  return settings;
        return null;
    }
    public void deleteScenario(String str){
        $("#scenariosTable").waitUntil(Condition.visible,30000);
        ElementsCollection arr= $$(By.partialLinkText(str));
        for (SelenideElement element:arr  ) {
            element.parent().parent().$(By.tagName("input")).click();
        }

        if(arr.size()>0) {
            $(By.className("delete-button")).click();
            $("#delete-button").waitUntil(Condition.visible, 30000);
            $("#delete-button").click();
        }

    }
}
