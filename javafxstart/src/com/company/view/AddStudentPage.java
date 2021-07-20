package com.company.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddStudentPage extends VBox {
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField studentIdField;
    private Button addBtn;
    public AddStudentPage(){
        Label firstNameLBL=new Label("First Name : ");
        firstNameField=new TextField();
        HBox firstNameHbox=new HBox(firstNameLBL,firstNameField);
        firstNameHbox.setAlignment(Pos.CENTER);

        Label lastNameLBL=new Label("Last Name : ");
        lastNameField=new TextField();
        HBox lastNameHbox=new HBox(lastNameLBL,lastNameField);
        lastNameHbox.setAlignment(Pos.CENTER);

        Label studentIdLBL=new Label("Student Id : ");
        studentIdField=new TextField();
        HBox studentIdHbox=new HBox(studentIdLBL,studentIdField);
        studentIdHbox.setAlignment(Pos.CENTER);

        addBtn=new Button("Add Student");
        addBtn.setAlignment(Pos.CENTER);

        //style
        addBtn.setStyle("-fx-background-color: #094945; -fx-background-radius: 15px; -fx-text-fill: #ffffff;");
        addBtn.setPrefSize(100,40);

        this.getChildren().addAll(firstNameHbox,lastNameHbox,studentIdHbox,addBtn);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
    }

    public TextField getFirstNameField() {
        return firstNameField;
    }

    public TextField getLastNameField() {
        return lastNameField;
    }

    public TextField getStudentIdField() {
        return studentIdField;
    }

    public Button getAddBtn() {
        return addBtn;
    }
}
