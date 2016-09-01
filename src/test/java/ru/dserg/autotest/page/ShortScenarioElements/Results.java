package test.page.ShortScenarioElements;

import org.openqa.selenium.By;
import test.Utils.SelenideTable;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 08.08.2016.
 */
public class Results {
    SelenideTable table =
            new SelenideTable($(By.xpath("//*[@id=\'results-table\']/div[1]/div[2]/div/div/div[1]/table")));

    public void editHpot(int str,String text){
        table.choiceTr(str, 5).setValue(text);
    }
    public void editQturb(int str,String text){
        table.choiceTr(str, 7).setValue(text);
    }
    public void editP1(int str,String text){
        table.choiceTr(str, 9).setValue(text);
    }
    public void editP2(int str,String text){
        table.choiceTr(str, 10).setValue(text);
    }
    public void editCost(int str,String text){
        table.choiceTr(str, 15).setValue(text);
    }

    public  void  checkBoxUNB(){
        $("#nb").click();
    }
    public  void  checkBoxUVB(){
        $("#vb").click();
    }
    public  void  checkBoxRashod(){
        $("#outflow").click();
    }
    public  void  checkBoxNapor(){
        $("#pressure").click();
    }
    public  void  checkBoxPower(){
        $("#power").click();
    }
    public  void  checkBoxLimits(){
        $("#limits").click();
    }
    public  void showLimits(){
        $("#showRestrictionsTable").click();
    }
    public  void showGA(){
        $("#showGaPower").click();
    }
    public void date(int  choice){
        $("#pagination").$(By.tagName("label"),choice).click();
    }

    public void clickNga(){
        $(By.name("power")).click();
    }
    public void clickThga(){
        $(By.name("efficiency")).click();
    }
    public  void play(){
        $("#start-calculation").click();
    }
    public void refresh(){
        $("#refresh").click();
    }
    public void save(){
        $("#save-results").click();
    }
    public void export(){
        $("#export").click();
    }
}
