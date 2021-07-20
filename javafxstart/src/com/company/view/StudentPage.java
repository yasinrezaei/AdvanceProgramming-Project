package com.company.view;

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

public class StudentPage extends BorderPane {
    private TableView<Student> tableView;
    private Button addBtn;
    private Button removeBtn;
    private Button exitBtn;
    public StudentPage() {



        createNewElement();
        TableColumn<Student,String> firstNameCol=new TableColumn<>("First Name");
        TableColumn<Student,String> lastNameCol=new TableColumn<>("Last Name");
        TableColumn<Student,String> studentIdCol=new TableColumn<>("Student Id");

        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        studentIdCol.setCellValueFactory(new PropertyValueFactory<>("studentId"));



        tableView.getColumns().addAll(firstNameCol,lastNameCol,studentIdCol);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox vBox=new VBox(addBtn,removeBtn,exitBtn);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.BOTTOM_CENTER);


        this.setCenter(tableView);
        this.setRight(vBox);




    }

    private void createNewElement(){
        tableView=new TableView<>();
        addBtn=new Button("Add Student");
        removeBtn=new Button("Remove Student");
        exitBtn=new Button("Exit");


        addBtn.setMaxWidth(Double.MAX_VALUE);
        removeBtn.setMaxWidth(Double.MAX_VALUE);
        exitBtn.setMaxWidth(Double.MAX_VALUE);

        //get information from files

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("Students.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String student = null;
        while (true) {
            try {
                if (!((student = bufferedReader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] student_info = student.split(" ");
            Student newStudent=new Student(student_info[1],student_info[2],student_info[0]);
            tableView.getItems().add(newStudent);
        }

        //style

        addBtn.setStyle("-fx-background-color: #094945; -fx-text-fill: #ffffff;");
        removeBtn.setStyle("-fx-background-color: #094945; -fx-text-fill: #ffffff;");
        exitBtn.setStyle("-fx-background-color: #ee2c2c; -fx-text-fill: #ffffff;-fx-end-margin: 10");

        addBtn.setPrefSize(120,60);
        removeBtn.setPrefSize(120,60);
        exitBtn.setPrefSize(120,60);



        ///

    }





    public TableView<Student> getTableView() {
        return tableView;
    }

    public Button getAddBtn() {
        return addBtn;
    }

    public Button getRemoveBtn() {
        return removeBtn;
    }

    public Button getExitBtn() {
        return exitBtn;
    }

    
}
