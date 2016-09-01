package test.page;

import test.page.LongModelElements.SpisoGES;
import test.page.LongScenarioElements.Characteristics;

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
        $("#characteristics\\2f vbCurves").click();
        tab = Tab.Characteristics;
    }
    public void choiceGes(int choice){
        spisoGES.click();
        spisoGES.choice(choice);
    }



}
