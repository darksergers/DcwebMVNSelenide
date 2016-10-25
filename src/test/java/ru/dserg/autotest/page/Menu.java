package ru.dserg.autotest.page;

import org.openqa.selenium.By;
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
    public OtchetRashodaGESPage  otchetRashodaGESPage(){
        $("#menu").$(By.linkText("Отчёты")).click();
        $("#menu").$(By.linkText("Отчёт расхода ГЭС")).click();
        return new OtchetRashodaGESPage();
    }
    public static void logOut(){
        $("#menu").$(By.linkText("Weber")).click();
        $("#menu").$(By.linkText("Выйти")).click();
    }
    public static void logOutWithExceptiom(){
        $("#menu").$(By.linkText("Выйти")).click();
    }


}
