package ru.dserg.autotest.page.MediumTerm.LongModelElements;

import ru.dserg.autotest.page.MediumTerm.LongModel;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 11.08.2016.
 * класс описывающий ДГ
 */
public class DG {

    /**
     * вернуться на основную страницу
     * @param model
     */
    public void back(LongModel model){

        $("#back-button").click();
        model.setTab();
 }
    /**
     * кнопка добавить дг
     */
 public void create(){

     $("#create-button").click();

 }

 }

