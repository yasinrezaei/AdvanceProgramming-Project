package com.company.controller;

import com.company.model.Reserve;
import com.company.model.Student;
import com.company.view.AddReserveBookPage;
import com.company.view.ReserveBookPage;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReserveBookPageController {
    private ReserveBookPage reserveBookPage;

    public ReserveBookPageController(){
        reserveBookPage=new ReserveBookPage();

        reserveBookPage.getReserveBtn().setOnAction(e->{
            Stage addReserveBookStage=new Stage();
            addReserveBookStage.setScene(new Scene(new AddReserveBookPageController(this).getAddReserveBookPage()));
            addReserveBookStage.setWidth(400);
            addReserveBookStage.setHeight(400);
            addReserveBookStage.show();
        });

        reserveBookPage.getExtendBtn().setOnAction(e->{
            Reserve selectedReserve = reserveBookPage.getTableView().getSelectionModel().getSelectedItem();
            Stage stage=new Stage();
            stage.setScene(new Scene(new ExtendReservePageController(selectedReserve,reserveBookPage.getScene()).getExtendReservePage()));
            stage.setWidth(200);
            stage.setHeight(200);
            stage.show();
        });


        reserveBookPage.getExitBtn().setOnAction(e->{
            reserveBookPage.getScene().getWindow().hide();
            Stage mainPageStage=new Stage();
            mainPageStage.setScene(new Scene(new MainPageController().getMainPage()));
            mainPageStage.setWidth(1000);
            mainPageStage.setHeight(600);
            mainPageStage.show();
        });

        reserveBookPage.getRemoveBtn().setOnAction(e->{
            Reserve selectedReserve = reserveBookPage.getTableView().getSelectionModel().getSelectedItem();
            if (selectedReserve != null) {
                reserveBookPage.getTableView().getItems().remove(selectedReserve);

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
                    if(!reserveList.get(i).getBookId().equals(selectedReserve.getBookId())){
                        printline.printf("%s "+"%s "+"%s "+"%s "+"%s "+"\n" , reserveList.get(i).getBookId(), reserveList.get(i).getBookName() ,reserveList.get(i).getStudentId(),reserveList.get(i).getStudentName(),reserveList.get(i).getTime());
                    }
                }
                printline.close();

            }
        });


    }

    public ReserveBookPage getReserveBookPage() {
        return reserveBookPage;
    }
}
