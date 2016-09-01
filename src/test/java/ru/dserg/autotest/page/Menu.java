package ru.dserg.autotest.page;

import ru.dserg.autotest.page.menuElements.ShortModelSpisok;

/**
 * Created by Kalinin.S on 06.08.2016.
 */
public class Menu {

   private ShortModelSpisok shortModelSpisok= new ShortModelSpisok();

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

}
