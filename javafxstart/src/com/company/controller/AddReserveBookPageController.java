package com.company.controller;

import com.company.model.Reserve;
import com.company.view.AddReserveBookPage;
import javafx.scene.paint.Color;

import java.io.*;

public class AddReserveBookPageController {
    private AddReserveBookPage addReserveBookPage;
    private ReserveBookPageController reserveBookPageController;

    public AddReserveBookPageController(ReserveBookPageController reserveBookPageController){
        addReserveBookPage=new AddReserveBookPage();

        this.reserveBookPageController=reserveBookPageController;


        addReserveBookPage.getAddBtn().setOnAction(e->{
            String selectedStudent=addReserveBookPage.getStudentComboBox().getSelectionModel().getSelectedItem();
            String selectedBook=addReserveBookPage.getBookComboBox().getSelectionModel().getSelectedItem();


            String[] s = selectedStudent.split(" ", 3);
            String[] b = selectedBook.split(" ", 2);
            Reserve reserve=new Reserve(b[0],b[1],s[0],s[1]+s[2],addReserveBookPage.getDatePicker().getValue()+"");

            if(checkReserve(reserve.getBookId())){
                reserveBookPageController.getReserveBookPage().getTableView().getItems().add(reserve);
                FileWriter filewriter = null;
                try {
                    filewriter = new FileWriter("Reserves.txt", true);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                PrintWriter printline = new PrintWriter(filewriter);
                printline.printf("%s "+"%s "+"%s "+"%s "+"%s "+"\n" , reserve.getBookId() , reserve.getBookName() ,reserve.getStudentId(),reserve.getStudentName(),reserve.getTime());
                printline.close();



                addReserveBookPage.getScene().getWindow().hide();
            }
            else {
                addReserveBookPage.getStatusLBL().setTextFill(Color.RED);
                addReserveBookPage.getStatusLBL().setText("This book has already been reserved");
            }





        });





    }

    private boolean checkReserve(String bookId) {
        //get information from files

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("Reserves.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String reserve = null;
        while (true) {
            try {
                if (!((reserve = bufferedReader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] reserve_info = reserve.split(" ");
            Reserve newReserve=new Reserve(reserve_info[0],reserve_info[1],reserve_info[2],reserve_info[3],reserve_info[4]);
            if(newReserve.getBookId().equals(bookId)) return false;
        }
        return true;
    }

    public AddReserveBookPage getAddReserveBookPage() {
        return addReserveBookPage;
    }
}
