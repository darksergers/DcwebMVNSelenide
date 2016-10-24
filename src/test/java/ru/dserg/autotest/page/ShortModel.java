package ru.dserg.autotest.page;

import org.openqa.selenium.By;
import ru.dserg.autotest.Utils.Util;
import ru.dserg.autotest.page.ShortScenario;



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
    public ShortScenario createScenario() throws Exception {
        $("#createScenario").click();
        Util.findError();
        return new ShortScenario();
    }
    public void  time(){
        Util.choiseDate("#beginDate","2015-09-08");
    }
    //*[@id="inflow-table"]/div[1]/div[1]/div/div[1]/table/tbody/tr[1]/td[1]
    //*[@id="inflow-table"]/div[1]/div[1]/div/div[1]/table/tbody/tr[1]/td[2]
}
