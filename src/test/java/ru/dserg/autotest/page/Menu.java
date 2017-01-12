package ru.dserg.autotest.page;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import ru.dserg.autotest.page.Manuals.DataDirectoryGES;
import ru.dserg.autotest.page.Manuals.ExpenseCharacteristicsGA;
import ru.dserg.autotest.page.MediumTerm.LongModel;
import ru.dserg.autotest.page.Reports.*;
import ru.dserg.autotest.page.ShortTerm.OptimizationPage;
import ru.dserg.autotest.page.ShortTerm.ShortModel;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 06.08.2016.
 */
public class Menu {



    @Step("Открытие списка ксраткосрочная модель и выбор станции ")
    public ShortModel choiceShortGes(){//выбор гэс
        $("#menu").$(By.partialLinkText("Краткосрочная модель")).waitUntil(Condition.visible,30000);
        $("#menu").$(By.partialLinkText("Краткосрочная модель")).click();
        $("#menu").$(By.partialLinkText("Чебоксарская ГЭС")).waitUntil(Condition.visible,30000);
        $("#menu").$(By.partialLinkText("Чебоксарская ГЭС")).click();
        return  new ShortModel();
    }
    @Step("Открытие списка кракосрочная модель и переход на страницу Оптимизация состава ГА")
    public OptimizationPage optimization(){
        $("#menu").$(By.partialLinkText("Краткосрочная модель")).shouldBe(Condition.visible);
        $("#menu").$(By.partialLinkText("Краткосрочная модель")).click();
        $("#menu").$(By.partialLinkText("Оптимизация состава ГА")).click();
        return new OptimizationPage();

    }

    @Step("Открытие списка Среднесрочная модель и выбор Волжко-Камкий каскад")
    public LongModel longModel(){
        $("#menu").$(By.partialLinkText("Среднесрочная модель")).waitUntil(Condition.visible,30000);
        $("#menu").$(By.partialLinkText("Среднесрочная модель")).click();
        $("#menu").$(By.partialLinkText("Волжско-Камский каскад")).click();

        return  new LongModel();
        
    }
    @Step("Открытие списка Отчеты")
    private  void  otchet(){
        $("#menu").$(By.linkText("Отчёты")).waitUntil(Condition.visible,30000);
        $("#menu").$(By.linkText("Отчёты")).click();

    }
    @Step("Открытие списка Справочники")
    private void  spavochnik(){

        $("#menu").$(By.linkText("Справочники")).waitUntil(Condition.visible,30000);
        $("#menu").$(By.linkText("Справочники")).click();
    }
    @Step("Выбор Отчёт расхода ГЭС")
    public OtchetRashodaGESPage otchetRashodaGESPage(){
        otchet();
        $("#menu").$(By.linkText("Отчёт расхода ГЭС")).click();
        return new OtchetRashodaGESPage();
    }
    @Step("Выбор Справочные данные по ГЭС")
    public DataDirectoryGES dataDirectoryGES(){
        spavochnik();
        $("#menu").$(By.linkText("Справочные данные по ГЭС")).click();
        return new  DataDirectoryGES();
    }
    @Step("Выбор Расходные характеристики ГА")
    public ExpenseCharacteristicsGA expenseCharacteristicsGA(){
        spavochnik();
        $("#menu").$(By.linkText("Расходные характеристики ГА")).click();
        return  new ExpenseCharacteristicsGA();
    }
    @Step("Выбор Отчёт по выполнению плана ремонтов оборудования")
    public RepairReport repairReport(){
        otchet();
        $("#menu").$(By.linkText("Отчёт по выполнению плана ремонтов оборудования")).click();
        return new RepairReport();

    }
    @Step("Выбор Отчет по времени оборудования в ремонте")
    public RepairTimeReport repairTimeReport(){
        otchet();
        $("#menu").$(By.linkText("Отчет по времени оборудования в ремонте")).click();
        return  new RepairTimeReport();
    }
    @Step("Выбор Отчёт о проверке располагаемой мощности")
    public AvailablePowerReport availablePowerReport(){
        otchet();
        $("#menu").$(By.linkText("Отчёт о проверке располагаемой мощности")).click();
        return  new AvailablePowerReport();
    }
    @Step("Выбор Отчёт о режимах эксплуатации оборудования")
    public ReportEquipmentOperatingRegime reportEquipmentOperatingRegime(){
        otchet();
        $("#menu").$(By.linkText("Отчёт о режимах эксплуатации оборудования")).click();
        return  new ReportEquipmentOperatingRegime();
    }
    @Step("Открытие списка Среднесрочная модель и выбор Контроль выполнения режимов")
    public MediumTermRegimeControl mediumTermRegimeControl(){
        $("#menu").$(By.partialLinkText("Среднесрочная модель")).click();
        $("#menu").$(By.partialLinkText("Контроль выполнения режимов")).click();
        return new MediumTermRegimeControl();
    }

    public static void logOut(){
        $("#menu").$(By.partialLinkText("Weber")).click();
        $("#menu").$(By.linkText("Выйти")).click();
    }

    public static void logOutWithExceptiom(){
        $("#menu").$(By.linkText("Выйти")).click();
    }


}
