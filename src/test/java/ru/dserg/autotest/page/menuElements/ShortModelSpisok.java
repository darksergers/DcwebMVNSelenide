package ru.dserg.autotest.page.menuElements;


import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;




import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 06.08.2016.
 */

public class ShortModelSpisok  {



    public void clickSpisok(){
        //$("#menu").$(By.partialLinkText("Краткосрочная модель")).waitUntil(Condition.visible,30000);
        $("#menu").$(By.partialLinkText("Краткосрочная модель")).click();
    }

    public void cheboxGES(){
        $("#menu").$(By.linkText("Чебоксарская ГЭС")).click();

    }

    public void saratovGES(){
        $(By.xpath("//*[@id=\'menu\']/nav/div/div[2]/ul[1]/li[2]/ul/li[2]/a")).click();
    }
    public void kamskayaGES(){

        $(By.xpath("//*[@id=\'menu\']/nav/div/div[2]/ul[1]/li[2]/ul/li[3]/a")).click();

    }
    public void votkinskayaGES(){

        $(By.xpath("//*[@id=\'menu\']/nav/div/div[2]/ul[1]/li[2]/ul/li[4]/a")).click();
    }
    public void volzhskayaGES(){

        $(By.xpath("//*[@id=\'menu\']/nav/div/div[2]/ul[1]/li[2]/ul/li[5]/a")).click();
    }
    public void zhigulevskayaGES(){

        $(By.xpath("//*[@id=\'menu\']/nav/div/div[2]/ul[1]/li[2]/ul/li[6]/a")).click();
    }
    public void nizhegorodskayaGES(){

        $(By.xpath("//*[@id=\'menu\']/nav/div/div[2]/ul[1]/li[2]/ul/li[7]/a")).click();
    }
    public void optimization(){

        $("#menu").$(By.linkText("Оптимизация состава ГА")).click();
    }
}
