package com.company.view;

import com.company.model.Book;
import com.company.model.Student;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import javax.xml.soap.Name;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BookPage extends BorderPane {
    private TableView<Book> tableView;
    private Button addBtn;
    private Button removeBtn;
    private Button exitBtn;

    public BookPage(){
        createNewElement();
        TableColumn<Book,String> nameCol=new TableColumn<>("Name");
        TableColumn<Book,String> bookIdCol=new TableColumn<>("Book Id");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        bookIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));



        tableView.getColumns().addAll(nameCol,bookIdCol);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox vBox=new VBox(addBtn,removeBtn,exitBtn);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.BOTTOM_CENTER);


        this.setCenter(tableView);
        this.setRight(vBox);
    }
    private void createNewElement(){
        tableView=new TableView<>();
        addBtn=new Button("Add Book");
        removeBtn=new Button("Remove Book");
        exitBtn=new Button("Exit");

        addBtn.setMaxWidth(Double.MAX_VALUE);
        removeBtn.setMaxWidth(Double.MAX_VALUE);
        exitBtn.setMaxWidth(Double.MAX_VALUE);
        //get information from files

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("Books.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String book = null;
        while (true) {
            try {
                if (!((book = bufferedReader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] book_info = book.split(" ");
            Book newBook=new Book(book_info[1],book_info[0]);
            tableView.getItems().add(newBook);
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

    public TableView<Book> getTableView() {
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
