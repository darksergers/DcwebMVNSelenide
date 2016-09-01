package test.page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

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
