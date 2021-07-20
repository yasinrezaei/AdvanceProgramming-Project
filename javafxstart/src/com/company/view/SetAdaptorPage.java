package com.company.view;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SetAdaptorPage extends VBox {
    private Label mainText;
    private Label method1;
    private Label method2;
    private Label method3;
    private Label method4;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    private TextField fixrec;
    private TextField fixstr1;
    private TextField fixstr2;
    private Label fixrecLBL;
    private Label fixstr1LBL;
    private Label fixstr2LBL;

    public SetAdaptorPage(){
        mainText=new Label("Please Select Save Strategy");
        method1=new Label("FixRecFixStrAdaptor");
        method2=new Label("FixRecDynStrAdaptor");
        method3=new Label("DynRecFixStrAdaptor");
        method4=new Label("DynRecDynStrAdaptor");

        button1=new Button("select");
        button2=new Button("select");
        button3=new Button("select");
        button4=new Button("select");



        method1.underlineProperty().set(true);
        method2.underlineProperty().set(true);
        method3.underlineProperty().set(true);
        method4.underlineProperty().set(true);

        VBox vBox1=new VBox(method1,button1);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(10);

        VBox vBox2=new VBox(method2,button2);
        vBox2.setAlignment(Pos.CENTER);
        vBox2.setSpacing(10);

        VBox vBox3=new VBox(method3,button3);
        vBox3.setAlignment(Pos.CENTER);
        vBox3.setSpacing(10);

        VBox vBox4=new VBox(method4,button4);
        vBox4.setAlignment(Pos.CENTER);
        vBox4.setSpacing(10);

        ///
        fixrec=new TextField();
        fixstr1=new TextField();
        fixstr2=new TextField();

        fixrecLBL=new Label("Fix Rec Size :");
        fixstr1LBL=new Label("Fix Str1 Size :");
        fixstr2LBL=new Label("Fix Str2 Size :");

        HBox fixrecHbox=new HBox(fixrecLBL,fixrec);
        fixrecHbox.setSpacing(20);
        fixrecHbox.setAlignment(Pos.CENTER);

        HBox fixstr1Hbox=new HBox(fixstr1LBL,fixstr1);
        fixstr1Hbox.setSpacing(20);
        fixstr1Hbox.setAlignment(Pos.CENTER);

        HBox fixstr2Hbox=new HBox(fixstr2LBL,fixstr2);
        fixstr2Hbox.setSpacing(20);
        fixstr2Hbox.setAlignment(Pos.CENTER);

        HBox size=new HBox(fixrecHbox,fixstr1Hbox,fixstr2Hbox);
        size.setAlignment(Pos.CENTER);
        size.setSpacing(20);

        ///




        HBox hBox=new HBox(vBox1,vBox2,vBox3,vBox4);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(20);
        this.getChildren().addAll(mainText,hBox,size);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);

        //style
        mainText.setStyle("-fx-font-size: 32");

        button1.setStyle("-fx-background-color: #094945; -fx-background-radius: 15px; -fx-text-fill: #ffffff;");
        button1.setPrefSize(60,40);

        button2.setStyle("-fx-background-color: #094945; -fx-background-radius: 15px; -fx-text-fill: #ffffff;");
        button2.setPrefSize(60,40);

        button3.setStyle("-fx-background-color: #094945; -fx-background-radius: 15px; -fx-text-fill: #ffffff;");
        button3.setPrefSize(60,40);

        button4.setStyle("-fx-background-color: #094945; -fx-background-radius: 15px; -fx-text-fill: #ffffff;");
        button4.setPrefSize(60,40);

    }

    public Button getButton1() {
        return button1;
    }

    public Button getButton2() {
        return button2;
    }

    public Button getButton3() {
        return button3;
    }

    public Button getButton4() {
        return button4;
    }

    public TextField getFixrec() {
        return fixrec;
    }

    public TextField getFixstr1() {
        return fixstr1;
    }

    public TextField getFixstr2() {
        return fixstr2;
    }
}
