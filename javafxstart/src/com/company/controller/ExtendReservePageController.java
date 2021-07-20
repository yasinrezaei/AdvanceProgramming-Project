package com.company.controller;

import com.company.model.Reserve;
import com.company.view.ExtendReservePage;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExtendReservePageController {
    private ExtendReservePage extendReservePage;

    public ExtendReservePageController(Reserve selectedReserve, Scene scene){
        extendReservePage=new ExtendReservePage();

        extendReservePage.getButton().setOnAction(e->{
            String newDate=extendReservePage.getDatePicker().getValue()+"";

            if (selectedReserve != null) {

                //remove from file
                List<Reserve> reserveList = new ArrayList<>();
                BufferedReader bufferedReader = null;
                try {
                    bufferedReader = new BufferedReader(new FileReader("Reserves.txt"));
                } catch (FileNotFoundException er) {
                    er.printStackTrace();
                }
                String reserve = null;
                while (true) {
                    try {
                        if (!((reserve = bufferedReader.readLine()) != null)) break;
                    } catch (IOException er) {
                        er.printStackTrace();
                    }
                    String[] reserve_info = reserve.split(" ");
                    Reserve newReserve = new Reserve(reserve_info[0], reserve_info[1], reserve_info[2],reserve_info[3],reserve_info[4]);
                    reserveList.add(newReserve);
                }

                PrintWriter writer = null;
                try {
                    writer = new PrintWriter("Reserves.txt");
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                writer.print("");
                writer.close();

                FileWriter filewriter = null;
                try {
                    filewriter = new FileWriter("Reserves.txt", true);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                PrintWriter printline = new PrintWriter(filewriter);
                for(int i=0;i<reserveList.size();i++){
                    if(reserveList.get(i).getBookId().equals(selectedReserve.getBookId())){
                        printline.printf("%s "+"%s "+"%s "+"%s "+"%s "+"\n" , reserveList.get(i).getBookId(), reserveList.get(i).getBookName() ,reserveList.get(i).getStudentId(),reserveList.get(i).getStudentName(),newDate);
                        continue;
                    }
                    printline.printf("%s "+"%s "+"%s "+"%s "+"%s "+"\n" , reserveList.get(i).getBookId(), reserveList.get(i).getBookName() ,reserveList.get(i).getStudentId(),reserveList.get(i).getStudentName(),reserveList.get(i).getTime());

                }
                printline.close();


                extendReservePage.getScene().getWindow().hide();
                scene.getWindow().hide();
                Stage stage=new Stage();
                stage.setScene(new Scene(new ReserveBookPageController().getReserveBookPage()));
                stage.setHeight(600);
                stage.setWidth(1000);
                stage.show();
            }
        });

    }

    public ExtendReservePage getExtendReservePage() {
        return extendReservePage;
    }
}
