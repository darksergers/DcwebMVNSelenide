package ru.dserg.autotest.page;


import ru.dserg.autotest.page.Manuals.DataDirectoryGES;
import ru.dserg.autotest.page.Manuals.ExpenseCharacteristicsGA;
import ru.dserg.autotest.page.MediumTerm.LongModel;
import ru.dserg.autotest.page.Reports.OtchetRashodaGESPage;
import ru.dserg.autotest.page.ShortTerm.OptimizationPage;
import ru.dserg.autotest.page.ShortTerm.ShortModel;

/**
 * Created by Kalinin.S on 05.08.2016.
 */
public class HomePage {


    private Menu menu=new Menu();

    public ShortModel openKratkosrochSpisok(int choice){
       return  menu.choiceShortGes();
    }
    public OptimizationPage openOptimization(){
        return menu.optimization();
    }
    public LongModel longModel(){
        return menu.longModel();
    }
    public OtchetRashodaGESPage otchetRashodaGESPage(){
    return menu.otchetRashodaGESPage();
}
    public DataDirectoryGES dataDirectoryGES(){
        return menu.dataDirectoryGES();
    }
    public ExpenseCharacteristicsGA expenseCharacteristicsGA(){
        return menu.expenseCharacteristicsGA();
    }

    public Menu getMenu() {
        return menu;
    }
}
