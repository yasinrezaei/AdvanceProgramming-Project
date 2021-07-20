package com.company.model.adaptors;

import com.company.model.Book;
import com.company.model.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DynRecDynStrAdap implements DynRecordAdap,DynStringAdap{
    public DynRecDynStrAdap() {
        super();
    }

    @Override
    public void readRecord() {

    }

    @Override
    public Student writeRecord(Student s) throws IOException {
        FileWriter filewriter = new FileWriter("Students.txt", true);
        PrintWriter printline = new PrintWriter(filewriter);
        printline.printf("%s "+"%s "+"%s "+"\n" , s.getStudentId() , s.getFirstName() ,s.getLastName());
        printline.close();
        return s;
    }
    @Override
    public Book writeRecordBook(Book b) throws IOException {
        FileWriter filewriter = new FileWriter("Books.txt", true);
        PrintWriter printline = new PrintWriter(filewriter);
        printline.printf("%s "+"%s "+"\n" , b.getId() , b.getName());
        printline.close();
        return b;
    }



    @Override
    public void readRecordBook() {

    }



    @Override
    public void readString() {

    }

    @Override
    public void writeString(Student s) {

    }

    @Override
    public void readStringBook() {

    }

    @Override
    public void writeStringBook(Book b) {

    }
}
