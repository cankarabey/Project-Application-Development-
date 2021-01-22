package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import util.CSVReader;
import util.IllegalFieldException;
import util.IllegalImportException;
import util.Predictions;

import java.io.IOException;
import java.util.Random;

public class exponentialTabController {

    @FXML private Tab exponential;
    @FXML private TextField rValCattle;
    @FXML private TextField rValHorse;
    @FXML private TextField rValDeer;
    @FXML private TextField nValCattle;
    @FXML private TextField nValHorse;
    @FXML private TextField nValDeer;
    @FXML private TextField timeValue;
    @FXML private TableView<Predictions> tableView;
    @FXML private TableColumn<Predictions , Integer> year;
    @FXML private TableColumn<Predictions , Integer> cattleNumber;
    @FXML private TableColumn<Predictions , Integer> deerNumber;
    @FXML private TableColumn<Predictions , Integer> horseNumber;
    private ObservableList<Predictions> predictions = FXCollections.observableArrayList();
    @FXML private CheckBox checkBoxPie;
    @FXML private CheckBox checkBoxLine;
    @FXML private Button randomButton;


    public void setText() throws IllegalImportException{
        try {
            rValCattle.setText(String.valueOf(CSVReader.calcR(importDataScreenController.getFiles().get("CattleData"))));
            rValHorse.setText(String.valueOf(CSVReader.calcR(importDataScreenController.getFiles().get("HorseData"))));
            rValDeer.setText(String.valueOf(CSVReader.calcR(importDataScreenController.getFiles().get("DeerData"))));
            nValCattle.setText(String.valueOf(CSVReader.getN(importDataScreenController.getFiles().get("CattleData"))));
            nValHorse.setText(String.valueOf(CSVReader.getN(importDataScreenController.getFiles().get("HorseData"))));
            nValDeer.setText(String.valueOf(CSVReader.getN(importDataScreenController.getFiles().get("DeerData"))));
        }
        catch (IOException | ArrayIndexOutOfBoundsException e){
                throw new IllegalImportException(e);
            }
    }

    @FXML
    public void handleRandomButton() {
        Random rand = new Random();
        rValCattle.setText(String.valueOf(0.01 + (0.1 - 0.01) * rand.nextDouble()));
        rValHorse.setText(String.valueOf(0.09 + (0.1) * rand.nextDouble()));
        rValDeer.setText(String.valueOf(0.09 + (0.1) * rand.nextDouble()));
        nValCattle.setText(String.valueOf(200 + rand.nextInt(100)));
        nValHorse.setText(String.valueOf(1000 + rand.nextInt(300)));
        nValDeer.setText(String.valueOf(2900 + rand.nextInt(400)));
    }

    public void handleShowPredictions() throws IllegalFieldException {
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
                nCattle = (int) (nCattle * Math.pow(Math.E, (Double.parseDouble(rValCattle.getText()) * 1)));
                nDeer = (int) (nDeer * Math.pow(Math.E, (Double.parseDouble(rValDeer.getText()) * 1)));
                nHorse = (int) (nHorse * Math.pow(Math.E, (Double.parseDouble(rValHorse.getText()) * 1)));
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
            throw new IllegalFieldException(e);
        }

    }
}
