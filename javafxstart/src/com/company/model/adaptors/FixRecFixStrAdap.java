package com.company.model.adaptors;

import com.company.model.Book;
import com.company.model.Student;

import java.io.*;

public class FixRecFixStrAdap implements FixedRecordAdap ,FixedStringAdap{
    public static int fixrec=10;
    public static int fixstr1=5;
    public static int fixstr2=5;

    public FixRecFixStrAdap(int fixrec,int fixstr1,int fixstr2) {
        setFixrec(fixrec);
        setFixstr1(fixstr1);
        setFixstr2(fixstr2);
    }

    @Override
    public void readRecord() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Students.txt"));
        String student;
        while ((student = br.readLine()) != null) {
            String[] student_info = student.split(" ");

        }
    }

    @Override
    public Student writeRecord(Student s) throws IOException {
        Student FixedByRecStudent=FixByRec(s,FixRecFixStrAdap.fixrec);
        Student FixedStudent=new Student(Fix(FixedByRecStudent.getFirstName(),FixRecFixStrAdap.fixstr1), Fix(FixedByRecStudent.getLastName(),FixRecFixStrAdap.fixstr2),FixedByRecStudent.getStudentId());

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
    public Student FixByRec(Student s,int fixrec){
        int len=4+s.getFirstName().length()+s.getLastName().length();
        if(len<=fixrec){
            return s;
        }
        int t=len-fixrec;
        Student newStudent=new Student(Fix(s.getFirstName(),s.getFirstName().length()-t/2),Fix(s.getLastName(),s.getLastName().length()-t/2),s.getStudentId());
        return newStudent;
    }

    @Override
    public Book writeRecordBook(Book b) throws IOException {
        Book FixedByRecBook=FixByRecBook(b,FixRecFixStrAdap.fixrec);
        Book FixedBook=new Book(Fix(FixedByRecBook.getName(),FixRecFixStrAdap.fixstr1),FixedByRecBook.getId());

        FileWriter filewriter = new FileWriter("Books.txt", true);
        PrintWriter printline = new PrintWriter(filewriter);
        printline.printf("%s "+"%s "+"\n" , FixedBook.getId() , FixedBook.getName());
        printline.close();
        return FixedBook;
    }

    public Book FixByRecBook(Book b,int fixrec){
        int len=4+b.getName().length();
        if(len<=fixrec){
            return b;
        }
        int t=len-fixrec;
        Book newBook=new Book(Fix(b.getName(),b.getName().length()-t/2),b.getId());
        return newBook;
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

    public static int getFixrec() {
        return fixrec;
    }

    public static void setFixrec(int fixrec) {
        FixRecFixStrAdap.fixrec = fixrec;
    }

    public static int getFixstr1() {
        return fixstr1;
    }

    public static void setFixstr1(int fixstr1) {
        FixRecFixStrAdap.fixstr1 = fixstr1;
    }

    public static int getFixstr2() {
        return fixstr2;
    }

    public static void setFixstr2(int fixstr2) {
        FixRecFixStrAdap.fixstr2 = fixstr2;
    }
}
