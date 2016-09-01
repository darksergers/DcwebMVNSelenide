package ru.dserg.autotest.page;



/**
 * Created by Kalinin.S on 05.08.2016.
 */
public class HomePage {


    private Menu menu=new Menu();

    public ShortModel openKratkosrochSpisok(int choice){
       return  menu.choiceShortGes(choice);
    }
    public OptimizationPage openOptimization(){
        return menu.optimization();
    }


}
