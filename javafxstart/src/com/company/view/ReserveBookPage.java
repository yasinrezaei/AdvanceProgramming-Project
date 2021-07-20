package com.company.view;

import com.company.model.Book;
import com.company.model.Reserve;
import com.company.model.Student;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReserveBookPage extends BorderPane {
    private TableView<Reserve> tableView;
    private Button reserveBtn;
    private Button extendBtn;
    private Button exitBtn;
    private Button removeBtn;

    public ReserveBookPage(){
        createNewElement();
        TableColumn<Reserve,String> bookIdCol=new TableColumn<>("Book Id");
        TableColumn<Reserve,String> bookNameCol=new TableColumn<>("Book Name");
        TableColumn<Reserve,String> studentIdCol=new TableColumn<>("Student Id");
        TableColumn<Reserve,String> studentNameCol=new TableColumn<>("Student Name");
        TableColumn<Reserve,String> dateCol=new TableColumn<>("Reserve Time");

        bookIdCol.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        bookNameCol.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        studentIdCol.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        studentNameCol.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("time"));



        tableView.getColumns().addAll(bookIdCol,bookNameCol,studentIdCol,studentNameCol,dateCol);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox vBox=new VBox(reserveBtn,extendBtn,removeBtn,exitBtn);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.BOTTOM_CENTER);


        this.setCenter(tableView);
        this.setRight(vBox);
    }
    private void createNewElement(){
        tableView=new TableView<>();
        reserveBtn=new Button("Reserve Book");
        extendBtn=new Button("Extend Book");
        exitBtn=new Button("Exit");
        removeBtn=new Button("Cancel Reserve");

        reserveBtn.setMaxWidth(Double.MAX_VALUE);
        extendBtn.setMaxWidth(Double.MAX_VALUE);
        exitBtn.setMaxWidth(Double.MAX_VALUE);
        //get information from files

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("Reserves.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String reserve = null;
        while (true) {
            try {
                if (!((reserve = bufferedReader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] reserve_info = reserve.split(" ");
            Reserve newReserve=new Reserve(reserve_info[0],reserve_info[1],reserve_info[2],reserve_info[3],reserve_info[4]);
            tableView.getItems().add(newReserve);
        }

        //style

        reserveBtn.setStyle("-fx-background-color: #094945; -fx-text-fill: #ffffff;");
        extendBtn.setStyle("-fx-background-color: #094945; -fx-text-fill: #ffffff;");
        removeBtn.setStyle("-fx-background-color: #094945; -fx-text-fill: #ffffff;");
        exitBtn.setStyle("-fx-background-color: #ee2c2c; -fx-text-fill: #ffffff;-fx-end-margin: 10");


        reserveBtn.setPrefSize(120,60);
        extendBtn.setPrefSize(120,60);
        removeBtn.setPrefSize(120,60);
        exitBtn.setPrefSize(120,60);



        ///

    }

    public TableView<Reserve> getTableView() {
        return tableView;
    }

    public Button getReserveBtn() {
        return reserveBtn;
    }

    public Button getExtendBtn() {
        return extendBtn;
    }

    public Button getExitBtn() {
        return exitBtn;
    }

    public Button getRemoveBtn() {
        return removeBtn;
    }
}
