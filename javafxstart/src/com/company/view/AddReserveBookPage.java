package com.company.view;

import com.company.model.Book;
import com.company.model.Student;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AddReserveBookPage extends VBox {
    private ComboBox<String> bookComboBox;
    private ComboBox<String> studentComboBox;
    private DatePicker datePicker;
    private Button addBtn;
    private Label studentComboLBL,bookComboLBL,dateLBL,statusLBL;

    public AddReserveBookPage(){
        bookComboBox=new ComboBox<>();
        studentComboBox=new ComboBox<>();
        addBtn=new Button("Add Reserve");
        studentComboLBL=new Label("Student");
        bookComboLBL=new Label("Book");

        dateLBL=new Label("Date");
        datePicker=new DatePicker();

        statusLBL=new Label();

        //add books and students from file to combo box
        //students
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
            studentComboBox.getItems().add(newStudent.getStudentId()+" "+newStudent.getFirstName()+" "+newStudent.getLastName());
        }
        //books
        BufferedReader bufferedReader1 = null;
        try {
            bufferedReader1 = new BufferedReader(new FileReader("Books.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String book = null;
        while (true) {
            try {
                if (!((book = bufferedReader1.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] book_info = book.split(" ");
            Book newBook=new Book(book_info[1],book_info[0]);
            bookComboBox.getItems().add(newBook.getId()+" "+newBook.getName());
        }

        HBox hBox1=new HBox(studentComboLBL,studentComboBox);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setSpacing(10);
        HBox hBox2=new HBox(bookComboLBL,bookComboBox);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setSpacing(10);
        HBox dateHbox=new HBox(dateLBL,datePicker);
        dateHbox.setSpacing(10);
        dateHbox.setAlignment(Pos.CENTER);


        this.getChildren().addAll(hBox1,hBox2,dateHbox,statusLBL,addBtn);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);

        //style
        addBtn.setStyle("-fx-background-color: #094945; -fx-background-radius: 15px; -fx-text-fill: #ffffff;");





    }

    public ComboBox<String> getBookComboBox() {
        return bookComboBox;
    }

    public ComboBox<String> getStudentComboBox() {
        return studentComboBox;
    }

    public Button getAddBtn() {
        return addBtn;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public Label getStatusLBL() {
        return statusLBL;
    }
}
