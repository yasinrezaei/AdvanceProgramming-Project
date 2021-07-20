package com.company.controller;

import com.company.model.Book;
import com.company.model.Student;
import com.company.view.BookPage;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookPageController {
    private BookPage bookPage;

    public BookPageController(){
        bookPage=new BookPage();

        bookPage.getAddBtn().setOnAction(e->{
            AddBookController addBookController=new AddBookController(this);
            Stage addBookStage=new Stage();
            addBookStage.setScene(new Scene(addBookController.getAddBookPage()));
            addBookStage.setWidth(400);
            addBookStage.setHeight(400);
            addBookStage.show();
        });

        bookPage.getRemoveBtn().setOnAction(e->{
            Book selectedBook = bookPage.getTableView().getSelectionModel().getSelectedItem();
            if (selectedBook != null) {
                bookPage.getTableView().getItems().remove(selectedBook);

                //remove from file
                List<Book> bookList = new ArrayList<>();
                BufferedReader bufferedReader = null;
                try {
                    bufferedReader = new BufferedReader(new FileReader("Books.txt"));
                } catch (FileNotFoundException er) {
                    er.printStackTrace();
                }
                String book = null;
                while (true) {
                    try {
                        if (!((book = bufferedReader.readLine()) != null)) break;
                    } catch (IOException er) {
                        er.printStackTrace();
                    }
                    String[] book_info = book.split(" ");
                    Book newBook = new Book(book_info[1], book_info[0]);
                    bookList.add(newBook);
                }

                PrintWriter writer = null;
                try {
                    writer = new PrintWriter("Books.txt");
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                writer.print("");
                writer.close();

                FileWriter filewriter = null;
                try {
                    filewriter = new FileWriter("Books.txt", true);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                PrintWriter printline = new PrintWriter(filewriter);
                for(int i=0;i<bookList.size();i++){
                    if(!bookList.get(i).getId().equals(selectedBook.getId())){
                        printline.printf("%s "+"%s "+"\n" , bookList.get(i).getId(), bookList.get(i).getName());
                    }
                }
                printline.close();

            }
        });

        bookPage.getExitBtn().setOnAction(e->{
            bookPage.getScene().getWindow().hide();
            Stage mainPageStage=new Stage();
            mainPageStage.setScene(new Scene(new MainPageController().getMainPage()));
            mainPageStage.setWidth(1000);
            mainPageStage.setHeight(600);
            mainPageStage.show();
        });
    }

    public BookPage getBookPage() {
        return bookPage;
    }
    public void addBookToTable(Book book){
        bookPage.getTableView().getItems().add(book);
    }
}
