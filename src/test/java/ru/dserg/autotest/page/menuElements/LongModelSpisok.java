package test.page.menuElements;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 06.08.2016.
 */
public class LongModelSpisok {

    public void  clickSpisok(){
        $(By.xpath("//*[@id=\'menu\']/nav/div/div[2]/ul[1]/li[1]/ul/li[1]/a")).click();
    }
    public void  angaroEnisei(){
        $(By.xpath("//*[@id='menu']/nav/div/div[2]/ul[1]/li[1]/ul/li[1]/a")).click();
    }
    public void  volzhskoKamskii(){
        $(By.xpath("//*[@id='menu']/nav/div/div[2]/ul[1]/li[1]/ul/li[2]/a")).click();
    }
    public void  GESnaZeya(){
        $(By.xpath("//*[@id='menu']/nav/div/div[2]/ul[1]/li[1]/ul/li[3]/a")).click();
    }
    public void  kaskadKubanskih(){
        $(By.xpath("//*[@id='menu']/nav/div/div[2]/ul[1]/li[1]/ul/li[4]/a")).click();
    }
    public void  novosibGes(){
        $(By.xpath("//*[@id='menu']/nav/div/div[2]/ul[1]/li[1]/ul/li[5]/a")).click();
    }
    public void  sulakskiiKaskad(){
        $(By.xpath("//*[@id='menu']/nav/div/div[2]/ul[1]/li[1]/ul/li[6]/a")).click();
    }
    public void svod(){
        $(By.xpath("//*[@id=\'menu\']/nav/div/div[2]/ul[1]/li[1]/ul/li[8]/a")).click();
    }
    public void model(){
        $(By.xpath("//*[@id=\'menu\']/nav/div/div[2]/ul[1]/li[1]/ul/li[10]/a")).click();
    }

}
