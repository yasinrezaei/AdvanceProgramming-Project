package com.company.controller;

import com.company.model.Student;
import com.company.model.adaptors.*;
import com.company.view.AddStudentPage;

import java.io.IOException;

public class AddStudentController {
    private AddStudentPage addStudentPage;
    private StudentsPageController studentsPageController;
    public AddStudentController(StudentsPageController studentsPageController){
        addStudentPage=new AddStudentPage();
        this.studentsPageController = studentsPageController;
        addStudentPage.getAddBtn().setOnAction(e->{

            String firstName=addStudentPage.getFirstNameField().getText();
            String lastName=addStudentPage.getLastNameField().getText();
            String studentId=addStudentPage.getStudentIdField().getText();




            ///add by adaptor
            //fix rec fix str
            if(Adaptor.isFixStr && Adaptor.isFixRec){
                Student student=new Student(firstName,lastName,studentId);
                FixRecFixStrAdap adaptor=new FixRecFixStrAdap(FixRecFixStrAdap.fixrec,FixRecFixStrAdap.fixstr1,FixRecFixStrAdap.fixstr2);
                Student writeStudent= null;
                try {
                    writeStudent = adaptor.writeRecord(student);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                studentsPageController.addStudentToTable(writeStudent);
            }
            ////////////////
            //dyn rec fix str
            else if(!Adaptor.isFixRec && Adaptor.isFixStr){
                Student student=new Student(firstName,lastName,studentId);
                DynRecFixStrAdap adaptor=new DynRecFixStrAdap(DynRecFixStrAdap.fixstr1,DynRecFixStrAdap.fixstr2);
                Student writeStudent=null;
                try {
                    writeStudent =adaptor.writeRecord(student);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                studentsPageController.addStudentToTable(writeStudent);
            }
            /////////////
            //dyn rec dyn str
            else if(!Adaptor.isFixStr && !Adaptor.isFixRec){
                DynRecDynStrAdap adaptor=new DynRecDynStrAdap();
                Student student=new Student(firstName,lastName,studentId);
                try {
                    adaptor.writeRecord(student);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                studentsPageController.addStudentToTable(student);
            }

            ///////////
            //fix rec dyn str
            else if(!Adaptor.isFixStr && Adaptor.isFixRec){
                Student student=new Student(firstName,lastName,studentId);
                FixRecDynStrAdap adaptor=new FixRecDynStrAdap(FixRecDynStrAdap.fixrec);
                Student writeStudent=null;
                try {
                    writeStudent=adaptor.writeRecord(student);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                studentsPageController.addStudentToTable(writeStudent);
            }


            addStudentPage.getScene().getWindow().hide();

        });


    }


    public AddStudentPage getAddStudentPage() {
        return addStudentPage;
    }
}
