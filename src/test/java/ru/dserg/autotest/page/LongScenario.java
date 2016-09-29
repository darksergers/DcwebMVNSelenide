package ru.dserg.autotest.page;

import org.openqa.selenium.By;
import ru.dserg.autotest.page.LongModelElements.SpisoGES;
import ru.dserg.autotest.page.LongScenarioElements.Characteristics;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 11.08.2016.
 */
public class LongScenario {
    private enum Tab{
        Results,Characteristics,Remont,Dg,Compensation,Limits,Hydraulicities,Graphics,Comparison,DisplayFilter,Settings
    }
    private Tab tab= Tab.Results;
    private SpisoGES spisoGES= new SpisoGES();
    private Characteristics characteristics = new Characteristics();



    public void results(){
        $("#results").click();
        tab= Tab.Results;
    }
    public void characteristics(){
        $(By.xpath("//*[@id=\"main-content\"]/div/div[1]/div[1]/div[1]/div/label[2]")).click();
        tab = Tab.Characteristics;
    }

    public Characteristics getCharacteristics() {
        return(tab==Tab.Characteristics)? characteristics:null;
    }

    public void choiceGes(int choice){
        spisoGES.click();
        spisoGES.choice(choice);
    }



}
