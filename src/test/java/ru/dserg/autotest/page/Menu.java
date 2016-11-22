package ru.dserg.autotest.page;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import ru.dserg.autotest.page.Manuals.DataDirectoryGES;
import ru.dserg.autotest.page.Manuals.ExpenseCharacteristicsGA;
import ru.dserg.autotest.page.Reports.*;
import ru.dserg.autotest.page.menuElements.LongModelSpisok;
import ru.dserg.autotest.page.menuElements.ShortModelSpisok;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 06.08.2016.
 */
public class Menu {


    private ShortModelSpisok shortModelSpisok= new ShortModelSpisok();
    private LongModelSpisok longModelSpisok = new LongModelSpisok();

    public  ShortModel choiceShortGes(int a){//выбор гэс

        shortModelSpisok.clickSpisok();
        switch (a){
            case 1:  {
                shortModelSpisok.cheboxGES();
                return new ShortModel();
            }
            case 2:{
                shortModelSpisok.saratovGES();
                return new ShortModel();
            }
            case 3:{
                shortModelSpisok.kamskayaGES();
                return new ShortModel();
            }
            case 4:{
                shortModelSpisok.votkinskayaGES();
                return new ShortModel();
            }
            case 5:{
                shortModelSpisok.volzhskayaGES();
                return new ShortModel();
            }
            case 6:{
                shortModelSpisok.zhigulevskayaGES();
                return new ShortModel();
            }
            case 7:{
                shortModelSpisok.nizhegorodskayaGES();
                return new ShortModel();
            }
            default:{
                return  null;
            }
        }
    }

    public OptimizationPage optimization(){
        shortModelSpisok.clickSpisok();
        shortModelSpisok.optimization();
        return new OptimizationPage();

    }

    public LongModel longModel(){//// TODO: 15.09.2016 свитч кейс по всем станциям 
        longModelSpisok.clickSpisok();
        longModelSpisok.volzhskoKamskii();
        return  new LongModel();
        
    }
    private  void  otchet(){
        $("#menu").$(By.linkText("Отчёты")).waitUntil(Condition.visible,30000);
        $("#menu").$(By.linkText("Отчёты")).click();

    }
    private void  spavochnik(){

        $("#menu").$(By.linkText("Справочники")).waitUntil(Condition.visible,30000);
        $("#menu").$(By.linkText("Справочники")).click();
    }

    public OtchetRashodaGESPage otchetRashodaGESPage(){
        otchet();
        $("#menu").$(By.linkText("Отчёт расхода ГЭС")).click();
        return new OtchetRashodaGESPage();
    }
    public DataDirectoryGES dataDirectoryGES(){
        spavochnik();
        $("#menu").$(By.linkText("Справочные данные по ГЭС")).click();
        return new  DataDirectoryGES();
    }

    public ExpenseCharacteristicsGA expenseCharacteristicsGA(){
        spavochnik();
        $("#menu").$(By.linkText("Расходные характеристики ГА")).click();
        return  new ExpenseCharacteristicsGA();
    }

    public RepairReport repairReport(){
        otchet();
        $("#menu").$(By.linkText("Отчёт по выполнению плана ремонтов оборудования")).click();
        return new RepairReport();

    }
    public RepairTimeReport repairTimeReport(){
        otchet();
        $("#menu").$(By.linkText("Отчет по времени оборудования в ремонте")).click();
        return  new RepairTimeReport();
    }
    public AvailablePowerReport availablePowerReport(){
        otchet();
        $("#menu").$(By.linkText("Отчёт о проверке располагаемой мощности")).click();
        return  new AvailablePowerReport();
    }
    public ReportEquipmentOperatingRegime reportEquipmentOperatingRegime(){
        otchet();
        $("#menu").$(By.linkText("Отчёт о режимах эксплуатации оборудования")).click();
        return  new ReportEquipmentOperatingRegime();
    }

    public static void logOut(){
        $("#menu").$(By.partialLinkText("Weber")).click();
        $("#menu").$(By.linkText("Выйти")).click();
    }

    public static void logOutWithExceptiom(){
        $("#menu").$(By.linkText("Выйти")).click();
    }


}
