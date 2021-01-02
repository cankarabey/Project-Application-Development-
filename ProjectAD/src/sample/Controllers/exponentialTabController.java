package sample.Controllers;

import Model.ExpModel;
import com.sun.source.tree.Tree;
import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import util.CSVReader;

import javax.print.attribute.IntegerSyntax;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

public class exponentialTabController {

    @FXML private Tab exponential;
    @FXML private TextField rValCattle;
    @FXML private TextField rValHorse;
    @FXML private TextField rValDeer;
    @FXML private TextField nValCattle;
    @FXML private TextField nValHorse;
    @FXML private TextField nValDeer;
    @FXML private TextField timeValue;
    @FXML private TableView<Integer> tableView;
    @FXML private TableColumn<Integer , Integer> year;
    @FXML private TableColumn<Integer , Integer> cattleNumber;
    @FXML private TableColumn<Integer , Integer> deerNumber;
    @FXML private TableColumn<Integer , Integer> horseNumber;
    private ObservableList<Integer> cattle = FXCollections.observableArrayList();
    private ObservableList<Integer> deer = FXCollections.observableArrayList();
    private ObservableList<Integer> horse = FXCollections.observableArrayList();


    public void setText(){
        try {
            rValCattle.setText(String.valueOf(CSVReader.calcR(importDataScreenController.getFiles().get("CattleData"))));
            rValHorse.setText(String.valueOf(CSVReader.calcR(importDataScreenController.getFiles().get("HorseData"))));
            rValDeer.setText(String.valueOf(CSVReader.calcR(importDataScreenController.getFiles().get("DeerData"))));
            nValCattle.setText(String.valueOf(CSVReader.getN(importDataScreenController.getFiles().get("CattleData"))));
            nValHorse.setText(String.valueOf(CSVReader.getN(importDataScreenController.getFiles().get("HorseData"))));
            nValDeer.setText(String.valueOf(CSVReader.getN(importDataScreenController.getFiles().get("DeerData"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleShowPredictions(){
        ExpModel expModel = new ExpModel();
        int t = Integer.parseInt(timeValue.getText());

        int nCattle = Integer.parseInt(nValCattle.getText());
        int nDeer = Integer.parseInt(nValDeer.getText());
        int nHorse = Integer.parseInt(nValHorse.getText());
        for (int i = 1; i<=t; i++) {
            cattle.add( (int) (nCattle * Math.pow(Math.E, (Double.parseDouble(rValCattle.getText()) * 1))));
            nCattle = cattle.get(cattle.size()-1);
            deer.add((int) (nDeer * Math.pow(Math.E, (Double.parseDouble(rValDeer.getText()) * 1))));
            nDeer = deer.get(deer.size() -1 );
            horse.add( (int) (nHorse * Math.pow(Math.E, (Double.parseDouble(rValHorse.getText()) * 1))));
            nHorse = horse.get(horse.size() -1 );
        }

        year.set

        System.out.print(cattle);
        System.out.println(deer);
        System.out.println(horse);
    }
}
