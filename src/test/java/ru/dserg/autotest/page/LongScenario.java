package ru.dserg.autotest.page;

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
        $("#characteristics/vbCurves").click();
        tab = Tab.Characteristics;
    }
    public void choiceGes(int choice){
        spisoGES.click();
        spisoGES.choice(choice);
    }



}
