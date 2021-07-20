package com.company;

import com.company.controller.LoginPageController;
import com.company.model.Admin;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Admin admin=new Admin("yasin","1234");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        LoginPageController loginPageController=new LoginPageController();
        primaryStage.setScene(new Scene(loginPageController.getLoginPage()));
        //primaryStage.setScene(new Scene(new MainPage()));
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.show();


    }

}
