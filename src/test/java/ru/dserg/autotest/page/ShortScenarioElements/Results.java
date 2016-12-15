package ru.dserg.autotest.page.ShortScenarioElements;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import ru.dserg.autotest.Utils.SelenideTable;
import ru.dserg.autotest.Utils.Util;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 08.08.2016.
 */
public class Results {
    SelenideTable table =
            new SelenideTable($(By.xpath("//*[@id=\'results-table\']/div[1]/div[2]/div/div/div[1]/table")));

    private void  editCell(int str,int rows,String text) throws Exception {//внутреняя функция
        table.typeInTable(str, rows,"#results-table > div.handsontableInputHolder > textarea",text);
    }
    // заполняют столбики в результируещей таблице
    public void editHpot(int str,String text) throws Exception {
        editCell(str, 5,text);
    }
    public void editQturb(int str,String text) throws Exception {
        editCell(str,7,text);
    }
    public void editP1(int str,String text) throws Exception {
        editCell(str,9,text);
    }
    public void editP2(int str,String text) throws Exception {
        editCell(str, 10,text);
    }
    public void editCost(int str,String text) throws Exception {
        editCell(str, 15,text);
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
    @Step("Нажатие на чекбокс Показать: ГА")
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
    @Step("Нажатие кнопки play")
    public  void play(){
        $("#start-calculation").click();
    }
    public void refresh(){
        $("#refresh").click();
    }
    @Step("Нажатие кнопки сохранить")
    public void save(){
        $("#save-results").click();
    }
    public void export(){
        $("#export").click();
    }
    @Step("Выбор оптимизации {0}")
    public void optTime(int choice){
        Util.selectSelelector($("#opt-type"),choice).click();
        ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("window.scrollTo(0, document.head.scrollHeight)");
    }
}
