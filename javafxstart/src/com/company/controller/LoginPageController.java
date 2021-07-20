package com.company.controller;

import com.company.Main;
import com.company.view.LoginPage;
import com.company.view.SetAdaptorPage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginPageController {
    private LoginPage loginPage;


    public LoginPageController(){
        loginPage=new LoginPage();
        initButton();
    }

    private void initButton(){
        loginPage.getButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(Main.admin.getUsername().equals(loginPage.getUsernameField().getText()) && Main.admin.getPassword().equals(loginPage.getPasswordField().getText())){
                    loginPage.getScene().getWindow().hide();

                    Stage mainPageStage=new Stage();
                    mainPageStage.setScene(new Scene( new MainPageController().getMainPage()));
                    mainPageStage.setWidth(1000);
                    mainPageStage.setHeight(600);
                    mainPageStage.show();
                }
                else{
                    loginPage.getErrorLBL().setTextFill(Color.RED);
                    loginPage.getErrorLBL().setText("User Name or Password is not correct");
                }
            }
        });
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }
}
