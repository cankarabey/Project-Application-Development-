package sample.Controllers;

import Model.ExpModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import util.CSVReader;
import util.EmptyFieldException;
import util.Predictions;

import java.io.IOException;

public class logisticTabController {

    @FXML private Tab logistic;
    @FXML private TextField rValCattle;
    @FXML private TextField rValHorse;
    @FXML private TextField rValDeer;
    @FXML private TextField nValCattle;
    @FXML private TextField nValHorse;
    @FXML private TextField nValDeer;
    @FXML private TextField timeValue;
    @FXML private TextField kValCattle;
    @FXML private TextField kValHorse;
    @FXML private TextField kValDeer;
    @FXML private CheckBox checkBoxPie;
    @FXML private CheckBox checkBoxLine;
    @FXML private TableView<Predictions> tableView;
    @FXML private TableColumn<Predictions , Integer> year;
    @FXML private TableColumn<Predictions , Integer> cattleNumber;
    @FXML private TableColumn<Predictions , Integer> deerNumber;
    @FXML private TableColumn<Predictions , Integer> horseNumber;
    private ObservableList<Predictions> predictions = FXCollections.observableArrayList();

    @FXML
    public void setText(){
        try {
            rValCattle.setText(String.valueOf(CSVReader.calcR(importDataScreenController.getFiles().get("CattleData"))));
            rValHorse.setText(String.valueOf(CSVReader.calcR(importDataScreenController.getFiles().get("HorseData"))));
            rValDeer.setText(String.valueOf(CSVReader.calcR(importDataScreenController.getFiles().get("DeerData"))));
            nValCattle.setText(String.valueOf(CSVReader.getN(importDataScreenController.getFiles().get("CattleData"))));
            nValHorse.setText(String.valueOf(CSVReader.getN(importDataScreenController.getFiles().get("HorseData"))));
            nValDeer.setText(String.valueOf(CSVReader.getN(importDataScreenController.getFiles().get("DeerData"))));
            kValCattle.setText(String.valueOf(CSVReader.calcK(importDataScreenController.getFiles().get("CattleData"))));
            kValDeer.setText(String.valueOf(CSVReader.calcK(importDataScreenController.getFiles().get("DeerData"))));
            kValHorse.setText(String.valueOf(CSVReader.calcK(importDataScreenController.getFiles().get("HorseData"))));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void handleShowPredictions() throws EmptyFieldException {
        try{
            int t = Integer.parseInt(timeValue.getText());
            int nCattle = Integer.parseInt(nValCattle.getText());
            int nDeer = Integer.parseInt(nValDeer.getText());
            int nHorse = Integer.parseInt(nValHorse.getText());
            int yearVal =1;
            if (!importDataScreenController.getFiles().isEmpty()) {
                yearVal = CSVReader.getYear(importDataScreenController.getFiles().get("CattleData"));
            }
            for (int i = 1; i<=t; i++) {
                nCattle = ((int) (Double.parseDouble(kValCattle.getText())/(1 + ((Double.parseDouble(kValCattle.getText())) - nCattle)/nCattle)*Math.pow(Math.E , (-Double.parseDouble(rValCattle.getText()) * 1))));
                nDeer = ((int) (Double.parseDouble(kValDeer.getText())/(1 + ((Double.parseDouble(kValDeer.getText())) - nDeer)/nDeer)*Math.pow(Math.E , (-Double.parseDouble(rValDeer.getText()) * 1))));
                nHorse = ((int) (Double.parseDouble(kValHorse.getText())/(1 + ((Double.parseDouble(kValHorse.getText())) - nHorse)/nHorse)*Math.pow(Math.E , (-Double.parseDouble(rValHorse.getText()) * 1))));
                predictions.add(new Predictions(yearVal , nCattle, nDeer , nHorse));
                yearVal++;
            }
            year.setCellValueFactory(cellData -> cellData.getValue().yearProperty().asObject());
            cattleNumber.setCellValueFactory(cellData -> cellData.getValue().cattleProperty().asObject());
            deerNumber.setCellValueFactory(cellData -> cellData.getValue().deerProperty().asObject());
            horseNumber.setCellValueFactory(cellData -> cellData.getValue().horseProperty().asObject());
            tableView.setItems(predictions);

            if (checkBoxLine.isSelected()) {
                lineChartController.showLineChart(predictions);
            }
            if (checkBoxPie.isSelected()) {
                pieChartController.showPieChart(predictions);
            }
        } catch (IOException | NumberFormatException e){
            throw new EmptyFieldException(e);
        }


    }
}
