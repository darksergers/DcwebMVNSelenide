package test.page.LongModelElements;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 18.08.2016.
 */
public class SpisoGES {
    private String s= "#stationSelect";
    public void click(){
        $("#current-station-button").click();
    }
    public void choice(int choice){
        click();
        $(s).$(By.tagName("a"),choice).click();
    }

    public void setS(String s) {
        this.s = s;
    }
}
