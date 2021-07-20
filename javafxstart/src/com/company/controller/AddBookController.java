package com.company.controller;

import com.company.model.Book;
import com.company.model.Student;
import com.company.model.adaptors.*;
import com.company.view.AddBookPage;
import com.company.view.AddStudentPage;

import java.io.IOException;

public class AddBookController {
    private AddBookPage addBookPage;
    private BookPageController bookPageController;
    public AddBookController(BookPageController bookPageController){
        addBookPage=new AddBookPage();
        this.bookPageController = bookPageController;
        addBookPage.getAddBtn().setOnAction(e->{

            String name=addBookPage.getNameField().getText();
            String bookId=addBookPage.getBookIdField().getText();
            Book book=new Book(name,bookId);
            ///add by adaptor
            //fix rec fix str
            if(Adaptor.isFixStr && Adaptor.isFixRec){
                FixRecFixStrAdap adaptor=new FixRecFixStrAdap(FixRecFixStrAdap.fixrec,FixRecFixStrAdap.fixstr1,FixRecFixStrAdap.fixstr2);
                Book writeBook= null;
                try {
                    writeBook = adaptor.writeRecordBook(book);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                bookPageController.addBookToTable(writeBook);
            }

            ////////////////
            //dyn rec fix str
            else if(!Adaptor.isFixRec && Adaptor.isFixStr){
                DynRecFixStrAdap adaptor=new DynRecFixStrAdap(DynRecFixStrAdap.fixstr1,DynRecFixStrAdap.fixstr2);
                Book writeBook= null;
                try {
                    writeBook = adaptor.writeRecordBook(book);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                bookPageController.addBookToTable(writeBook);
            }

            /////////////
            //dyn rec dyn str
            else if(!Adaptor.isFixStr && !Adaptor.isFixRec){
                DynRecDynStrAdap adaptor=new DynRecDynStrAdap();
                Book writeBook= null;
                try {
                    writeBook = adaptor.writeRecordBook(book);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                bookPageController.addBookToTable(writeBook);
            }

            ///////////
            //fix rec dyn str
            else if(!Adaptor.isFixStr && Adaptor.isFixRec){
                FixRecDynStrAdap adaptor=new FixRecDynStrAdap(FixRecDynStrAdap.fixrec);
                Book writeBook= null;
                try {
                    writeBook = adaptor.writeRecordBook(book);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                bookPageController.addBookToTable(writeBook);
            }


            addBookPage.getScene().getWindow().hide();

        });
    }

    public AddBookPage getAddBookPage() {
        return addBookPage;
    }
}
