package test.page;

import org.openqa.selenium.By;

import java.sql.Time;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 05.08.2016.
 */
public class ShortModel {
    private boolean diologIsOpen;
    public void create() {
        $(By.xpath("//*[@id=\'main-content\']/div/div[1]/div/div[1]/div[1]/button[1]")).click();
        diologIsOpen=!diologIsOpen;
    }
    public void  typeNameScenario(String text){
        if (diologIsOpen==true){
            $("#scenarioName").setValue(text );
        }
    }
    public ShortScenario createScenario(){
        $("#createScenario").click();
        return new ShortScenario();
    }
    //*[@id="inflow-table"]/div[1]/div[1]/div/div[1]/table/tbody/tr[1]/td[1]
    //*[@id="inflow-table"]/div[1]/div[1]/div/div[1]/table/tbody/tr[1]/td[2]
}
