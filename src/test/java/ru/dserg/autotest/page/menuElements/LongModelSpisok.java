package ru.dserg.autotest.page.menuElements;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 06.08.2016.
 */
public class LongModelSpisok {

    public void  clickSpisok(){
        $("#menu").$(By.linkText("Среднесрочная модель")).click();
    }
    public void  angaroEnisei(){
        $("#menu").$(By.linkText("Ангаро-Енисейский каскад")).click();
    }
    public void  volzhskoKamskii(){
        $("#menu").$(By.linkText("Волжско-Камский каскад")).click();
    }
    public void  GESnaZeya(){
        $("#menu").$(By.linkText("ГЭС на реках Зея, Бурея")).click();
    }
    public void  kaskadKubanskih(){
        $("#menu").$(By.linkText("Каскад Кубанских ГЭС")).click();
    }
    public void  novosibGes(){
        $("#menu").$(By.linkText("Новосибирская ГЭС")).click();
    }
    public void  sulakskiiKaskad(){
        $("#menu").$(By.linkText("Сулакский каскад")).click();
    }
    /*public void svod(){
        $(By.xpath("//*[@id=\'menu\']/nav/div/div[2]/ul[1]/li[1]/ul/li[8]/a")).click();
    }*/
    public void model(){
        $("#menu").$(By.linkText("Модель планирования притока")).click();
    }

}
