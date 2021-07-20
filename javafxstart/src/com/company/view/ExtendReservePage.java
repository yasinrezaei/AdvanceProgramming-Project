package com.company.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.awt.*;

public class ExtendReservePage extends VBox{
    private javafx.scene.control.Label label;
    private DatePicker datePicker;
    private Button button;

    public ExtendReservePage(){
        label=new Label("Set New Reserve Date");
        datePicker=new DatePicker();
        button=new Button("Set");
        VBox vBox=new VBox(label,datePicker,button);
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);
        this.getChildren().add(vBox);
        this.setAlignment(Pos.CENTER);

        //style
        button.setStyle("-fx-background-color: #094945; -fx-background-radius: 15px; -fx-text-fill: #ffffff;");
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public Button getButton() {
        return button;
    }
}
