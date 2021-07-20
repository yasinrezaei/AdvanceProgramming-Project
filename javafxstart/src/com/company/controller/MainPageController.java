package com.company.controller;

import com.company.view.BookPage;
import com.company.view.MainPage;
import com.company.view.ReserveBookPage;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainPageController {
    private MainPage mainPage;

    public MainPageController(){
        mainPage=new MainPage();

        mainPage.getAddStudentBtn().setOnAction(e->{
            mainPage.getScene().getWindow().hide();
            Stage studentsPageStage=new Stage();
            studentsPageStage.setScene(new Scene(new StudentsPageController().getStudentPage()));
            studentsPageStage.setHeight(600);
            studentsPageStage.setWidth(1000);
            studentsPageStage.show();
        });

        mainPage.getSettingsBtn().setOnAction(e->{
            Stage setAdaptorPageStage=new Stage();
            setAdaptorPageStage.setScene(new Scene(new SetAdaptorPageController().getSetAdaptorPage()));
            setAdaptorPageStage.setHeight(300);
            setAdaptorPageStage.setWidth(800);
            setAdaptorPageStage.show();
        });

        mainPage.getAddBookBtn().setOnAction(e->{
            mainPage.getScene().getWindow().hide();
            Stage bookPageStage=new Stage();
            bookPageStage.setScene(new Scene(new BookPageController().getBookPage()));
            bookPageStage.setHeight(600);
            bookPageStage.setWidth(1000);
            bookPageStage.show();
        });

        mainPage.getReserveBookBtn().setOnAction(e->{
            mainPage.getScene().getWindow().hide();
            Stage reserveBookPageStage=new Stage();
            reserveBookPageStage.setScene(new Scene(new ReserveBookPageController().getReserveBookPage()));
            reserveBookPageStage.setHeight(600);
            reserveBookPageStage.setWidth(1000);
            reserveBookPageStage.show();
        });

        mainPage.getExitBtn().setOnAction(e->{
            Platform.exit();
        });
    }

    public MainPage getMainPage() {
        return mainPage;
    }
}
