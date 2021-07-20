package com.company.controller;

import com.company.model.Reserve;
import com.company.model.Student;
import com.company.view.StudentPage;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsPageController {
    private StudentPage studentPage;

    public StudentsPageController() {
        studentPage =new StudentPage();

        studentPage.getAddBtn().setOnAction(e->{
            AddStudentController addStudentController=new AddStudentController(this);
            Stage addStudentStage=new Stage();
            addStudentStage.setScene(new Scene(addStudentController.getAddStudentPage()));
            addStudentStage.setWidth(400);
            addStudentStage.setHeight(400);
            addStudentStage.show();
        });

        studentPage.getRemoveBtn().setOnAction(this::handle);

        studentPage.getExitBtn().setOnAction(e->{
            studentPage.getScene().getWindow().hide();
            Stage mainPageStage=new Stage();
            mainPageStage.setScene(new Scene(new MainPageController().getMainPage()));
            mainPageStage.setWidth(1000);
            mainPageStage.setHeight(600);
            mainPageStage.show();
        });

    }

    public StudentPage getStudentPage() {
        return studentPage;
    }

    public void addStudentToTable(Student student){
        studentPage.getTableView().getItems().add(student);
    }


    private void handle(ActionEvent e) {
        Student selectedStudent = studentPage.getTableView().getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            studentPage.getTableView().getItems().remove(selectedStudent);

            //remove from file
            List<Student> studentList = new ArrayList<>();
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader("Students.txt"));
            } catch (FileNotFoundException er) {
                er.printStackTrace();
            }
            String student = null;
            while (true) {
                try {
                    if (!((student = bufferedReader.readLine()) != null)) break;
                } catch (IOException er) {
                    er.printStackTrace();
                }
                String[] student_info = student.split(" ");
                Student newStudent = new Student(student_info[1], student_info[2], student_info[0]);
                studentList.add(newStudent);
            }

            PrintWriter writer = null;
            try {
                writer = new PrintWriter("Students.txt");
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            writer.print("");
            writer.close();

            FileWriter filewriter = null;
            try {
               filewriter = new FileWriter("Students.txt", true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            PrintWriter printline = new PrintWriter(filewriter);
            for(int i=0;i<studentList.size();i++){
                if(!studentList.get(i).getStudentId().equals(selectedStudent.getStudentId())){
                    printline.printf("%s "+"%s "+"%s "+"\n" , studentList.get(i).getStudentId(), studentList.get(i).getFirstName() ,studentList.get(i).getLastName());
                }
            }
            printline.close();

        }

    }
}
