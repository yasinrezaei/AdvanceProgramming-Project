package com.company.controller;

import com.company.model.adaptors.Adaptor;
import com.company.model.adaptors.DynRecFixStrAdap;
import com.company.model.adaptors.FixRecDynStrAdap;
import com.company.model.adaptors.FixRecFixStrAdap;
import com.company.view.MainPage;
import com.company.view.SetAdaptorPage;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SetAdaptorPageController {
    private SetAdaptorPage setAdaptorPage;

    public SetAdaptorPage getSetAdaptorPage() {
        return setAdaptorPage;
    }

    public SetAdaptorPageController(){
        setAdaptorPage=new SetAdaptorPage();

        //fix rec fix str adaptor
        setAdaptorPage.getButton1().setOnAction(e->{
            Adaptor.isFixRec=true;
            Adaptor.isFixStr=true;
            FixRecFixStrAdap.setFixrec(Integer.parseInt(setAdaptorPage.getFixrec().getText()));
            FixRecFixStrAdap.setFixstr1(Integer.parseInt(setAdaptorPage.getFixstr1().getText()));
            FixRecFixStrAdap.setFixstr2(Integer.parseInt(setAdaptorPage.getFixstr2().getText()));
            setAdaptorPage.getScene().getWindow().hide();
        });

        //fix rec dyn str adaptor
        setAdaptorPage.getButton2().setOnAction(e->{
            Adaptor.isFixRec=true;
            Adaptor.isFixStr=false;
            FixRecDynStrAdap.setFixrec(Integer.parseInt(setAdaptorPage.getFixrec().getText()));
            setAdaptorPage.getScene().getWindow().hide();
        });

        //dyn rec fix str adaptor
        setAdaptorPage.getButton3().setOnAction(e->{
            Adaptor.isFixRec=false;
            Adaptor.isFixStr=true;
            DynRecFixStrAdap.setFixstr1(Integer.parseInt(setAdaptorPage.getFixstr1().getText()));
            DynRecFixStrAdap.setFixstr2(Integer.parseInt(setAdaptorPage.getFixstr2().getText()));
            setAdaptorPage.getScene().getWindow().hide();
        });

        //dyn rec dyn str adaptor
        setAdaptorPage.getButton4().setOnAction(e->{
            Adaptor.isFixRec=false;
            Adaptor.isFixStr=false;
            setAdaptorPage.getScene().getWindow().hide();
        });
    }

}
