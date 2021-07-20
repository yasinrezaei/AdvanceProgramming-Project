package com.company.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class LoginPage extends VBox {
    private TextField usernameField;
    private PasswordField passwordField;
    private Label errorLBL,mainLBL;
    private Button button;
    public LoginPage(){
        mainLBL=new Label("Shiraz University Library");
        Label usernameLBL =new Label("username : ");
        usernameField=new TextField();
        HBox usernameHbox=new HBox(usernameLBL,usernameField);
        usernameHbox.setAlignment(Pos.CENTER);


        Label passwordLBL =new Label("password : ");
        passwordField=new PasswordField();
        HBox passwordHbox=new HBox(passwordLBL,passwordField);
        passwordHbox.setAlignment(Pos.CENTER);
        errorLBL=new Label("");
        button=new Button("Log In");


        //style
        mainLBL.setStyle("-fx-font-size: 25");
        button.setStyle("-fx-background-color: #094945; -fx-background-radius: 15px; -fx-text-fill: #ffffff;");
        button.setPrefSize(80,40);

        usernameLBL.setStyle("-fx-font-size: 15");
        passwordLBL.setStyle("-fx-font-size: 15");




        this.getChildren().addAll(mainLBL,usernameHbox,passwordHbox,errorLBL,button);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);

    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(TextField usernameField) {
        this.usernameField = usernameField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(PasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public Label getErrorLBL() {
        return errorLBL;
    }

    public void setErrorLBL(Label errorLBL) {
        this.errorLBL = errorLBL;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
