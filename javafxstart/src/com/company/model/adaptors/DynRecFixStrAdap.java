package com.company.model.adaptors;

import com.company.model.Book;
import com.company.model.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DynRecFixStrAdap implements DynRecordAdap,FixedStringAdap{
    public static int fixstr1;
    public static int fixstr2;

    public DynRecFixStrAdap(int fixstr1,int fixstr2){
        setFixstr1(fixstr1);
        setFixstr2(fixstr2);
    }

    public static int getFixstr1() {
        return fixstr1;
    }

    public static void setFixstr1(int fixstr1) {
        DynRecFixStrAdap.fixstr1 = fixstr1;
    }

    public static int getFixstr2() {
        return fixstr2;
    }

    public static void setFixstr2(int fixstr2) {
        DynRecFixStrAdap.fixstr2 = fixstr2;
    }

    @Override
    public void readRecord() {

    }

    @Override
    public Student writeRecord(Student s) throws IOException {
        Student FixedStudent=new Student(Fix(s.getFirstName(),DynRecFixStrAdap.fixstr1), Fix(s.getLastName(),DynRecFixStrAdap.fixstr2),s.getStudentId());

        FileWriter filewriter = new FileWriter("Students.txt", true);
        PrintWriter printline = new PrintWriter(filewriter);
        printline.printf("%s "+"%s "+"%s "+"\n" , FixedStudent.getStudentId() , FixedStudent.getFirstName() ,FixedStudent.getLastName());
        printline.close();

        return FixedStudent;
    }
    public String Fix(String s,int len){
        if(s.length()<len){
            return s;
        }
        String newS="";
        for(int i=0;i<len;i++){
            newS+=s.charAt(i);
        }
        return newS;

    }
    @Override
    public Book writeRecordBook(Book b) throws IOException {
        Book FixedBook=new Book(Fix(b.getName(),DynRecFixStrAdap.fixstr1),b.getId());
        FileWriter filewriter = new FileWriter("Books.txt", true);
        PrintWriter printline = new PrintWriter(filewriter);
        printline.printf("%s "+"%s "+"\n" , FixedBook.getId() , FixedBook.getName());
        printline.close();
        return FixedBook;

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
