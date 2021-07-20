package com.company.model.adaptors;

import com.company.model.Book;
import com.company.model.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FixRecDynStrAdap implements FixedRecordAdap ,DynStringAdap{
    public static int fixrec;

    public FixRecDynStrAdap(int fixrec){
        setFixrec(fixrec);
    }

    public static int getFixrec() {
        return fixrec;
    }

    public static void setFixrec(int fixrec) {
        FixRecDynStrAdap.fixrec = fixrec;
    }

    public FixRecDynStrAdap() {
        super();
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

    @Override
    public void readRecord() {

    }

    @Override
    public Student writeRecord(Student s) throws IOException {
        Student FixedByRecStudent=FixByRec(s,FixRecDynStrAdap.fixrec);
        FileWriter filewriter = new FileWriter("Students.txt", true);
        PrintWriter printline = new PrintWriter(filewriter);
        printline.printf("%s "+"%s "+"%s "+"\n" , FixedByRecStudent.getStudentId() , FixedByRecStudent.getFirstName() ,FixedByRecStudent.getLastName());
        printline.close();
        return FixedByRecStudent;
    }
    public Student FixByRec(Student s,int fixrec){
        int len=4+s.getFirstName().length()+s.getLastName().length();
        if(len<=fixrec){
            return s;
        }
        int t=len-fixrec;
        Student newStudent=new Student(Fix(s.getFirstName(),s.getFirstName().length()-t/2),Fix(s.getLastName(),s.getLastName().length()-t/2),s.getStudentId());
        return newStudent;
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
        Book fixByRecBook=FixByRecBook(b,FixRecDynStrAdap.fixrec);
        FileWriter filewriter = new FileWriter("Books.txt", true);
        PrintWriter printline = new PrintWriter(filewriter);
        printline.printf("%s "+"%s "+"\n" , fixByRecBook.getId() , fixByRecBook.getName());
        printline.close();
        return fixByRecBook;
    }
    public Book FixByRecBook(Book b,int fixrec){
        int len=4+b.getName().length();
        if(len<=fixrec){
            return b;
        }

        int t=len-fixrec;
        Book newBook=new Book(Fix(b.getName(),b.getName().length()-t),b.getId());
        return newBook;
    }

    @Override
    public void readRecordBook() {

    }


}
