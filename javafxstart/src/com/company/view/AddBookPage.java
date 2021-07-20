package com.company.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddBookPage extends VBox {
    private TextField nameField;
    private TextField bookIdField;
    private Button addBtn;

    public AddBookPage(){
        Label nameLBL=new Label("Name : ");
        nameField=new TextField();
        HBox NameHbox=new HBox(nameLBL,nameField);
        NameHbox.setAlignment(Pos.CENTER);


        Label bookIdLBL=new Label("Book Id : ");
        bookIdField=new TextField();
        HBox bookIdHbox=new HBox(bookIdLBL,bookIdField);
        bookIdHbox.setAlignment(Pos.CENTER);

        addBtn=new Button("Add Book");
        addBtn.setAlignment(Pos.CENTER);

        //style
        addBtn.setStyle("-fx-background-color: #094945; -fx-background-radius: 15px; -fx-text-fill: #ffffff;");
        addBtn.setPrefSize(100,40);

        this.getChildren().addAll(NameHbox,bookIdHbox,addBtn);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
    }

    public TextField getNameField() {
        return nameField;
    }

    public TextField getBookIdField() {
        return bookIdField;
    }

    public Button getAddBtn() {
        return addBtn;
    }
}
