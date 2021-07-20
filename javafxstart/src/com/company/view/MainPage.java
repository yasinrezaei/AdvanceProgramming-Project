package com.company.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class MainPage extends VBox {
    private Label mainLBL;
    private Button addStudentBtn,addBookBtn,reserveBookBtn,settingsBtn,exitBtn;
    public MainPage(){
        mainLBL=new Label("Welcome To Shiraz University Library");
        addStudentBtn=new Button("Add Student");
        addBookBtn=new Button("Add Book");
        reserveBookBtn=new Button("Reserve Book");
        settingsBtn=new Button("Settings");
        exitBtn=new Button("Exit");

        //style
        mainLBL.setStyle("-fx-font-size: 32");
        addStudentBtn.setStyle("-fx-background-color: #094945; -fx-background-radius: 15px; -fx-text-fill: #ffffff;");
        addStudentBtn.setPrefSize(100,60);

        addBookBtn.setStyle("-fx-background-color: #094945; -fx-background-radius: 15px; -fx-text-fill: #ffffff;");
        addBookBtn.setPrefSize(100,60);

        reserveBookBtn.setStyle("-fx-background-color: #094945; -fx-background-radius: 15px; -fx-text-fill: #ffffff;");
        reserveBookBtn.setPrefSize(100,60);

        settingsBtn.setStyle("-fx-background-color: #094945; -fx-background-radius: 15px; -fx-text-fill: #ffffff;");
        settingsBtn.setPrefSize(100,60);

        exitBtn.setStyle("-fx-background-color: #bb0707; -fx-background-radius: 15px; -fx-text-fill: #ffffff;");
        exitBtn.setPrefSize(100,60);



        //

        HBox hBox=new HBox(addStudentBtn,addBookBtn,reserveBookBtn,settingsBtn,exitBtn);
        hBox.setSpacing(20);
        hBox.setAlignment(Pos.CENTER);

        this.getChildren().addAll(mainLBL,hBox);
        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);

    }

    public Button getAddStudentBtn() {
        return addStudentBtn;
    }

    public Button getAddBookBtn() {
        return addBookBtn;
    }

    public Button getReserveBookBtn() {
        return reserveBookBtn;
    }

    public Button getSettingsBtn() {
        return settingsBtn;
    }

    public Button getExitBtn() {
        return exitBtn;
    }
}
