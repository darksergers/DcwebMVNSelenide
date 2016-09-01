package ru.dserg.autotest.page.menuElements;


import org.openqa.selenium.By;




import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 06.08.2016.
 */

public class ShortModelSpisok  {



    public void clickSpisok(){
       $(By.xpath("//*[@id=\'menu\']/nav/div/div[2]/ul[1]/li[2]/a")).click();
    }

    public void cheboxGES(){
        $(By.xpath("//*[@id=\'menu\']/nav/div/div[2]/ul[1]/li[2]/ul/li[1]/a")).click();

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

        $(By.xpath("//*[@id=\'menu\']/nav/div/div[2]/ul[1]/li[2]/ul/li[9]/a")).click();
    }
}
