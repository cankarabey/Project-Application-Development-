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

public class predationTabController {

    @FXML private Tab predation;
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
    @FXML private TextField dValCattle;
    @FXML private TextField dValHorse;
    @FXML private TextField dValDeer;
    @FXML private TextField hValCattle;
    @FXML private TextField hValHorse;
    @FXML private TextField hValDeer;
    @FXML private TextField predatorPopulation;
    @FXML private TextField predatorAlpha;
    @FXML private CheckBox checkBoxPie;
    @FXML private CheckBox checkBoxLine;
    @FXML private TableView<Predictions> tableView;
    @FXML private TableColumn<Predictions , Integer> year;
    @FXML private TableColumn<Predictions , Integer> cattleNumber;
    @FXML private TableColumn<Predictions , Integer> deerNumber;
    @FXML private TableColumn<Predictions , Integer> horseNumber;
    @FXML private TableColumn<Predictions , Integer> wolfs;
    @FXML private Button randomButton;
    private static ObservableList<Predictions> predictions = FXCollections.observableArrayList();


    @FXML
    public void setText() throws IllegalImportException {
        try {
            rValCattle.setText(String.valueOf(CSVReader.calcR(importDataScreenController.getFiles().get("CattleData"))));
            rValHorse.setText(String.valueOf(CSVReader.calcR(importDataScreenController.getFiles().get("HorseData"))));
            rValDeer.setText(String.valueOf(CSVReader.calcR(importDataScreenController.getFiles().get("DeerData"))));
            nValCattle.setText(String.valueOf(CSVReader.getN(importDataScreenController.getFiles().get("CattleData"))));
            nValHorse.setText(String.valueOf(CSVReader.getN(importDataScreenController.getFiles().get("HorseData"))));
            nValDeer.setText(String.valueOf(CSVReader.getN(importDataScreenController.getFiles().get("DeerData"))));
            hValCattle.setText("0.366");
            hValDeer.setText("0.0243");
            hValHorse.setText("0.21");
            predatorAlpha.setText("0.2");
            dValCattle.setText(String.valueOf(1 / Double.parseDouble(hValCattle.getText()) * Double.parseDouble(predatorAlpha.getText())));
            dValDeer.setText(String.valueOf(1 / Double.parseDouble(hValDeer.getText()) * Double.parseDouble(predatorAlpha.getText())));
            dValHorse.setText(String.valueOf(1 / Double.parseDouble(hValHorse.getText()) * Double.parseDouble(predatorAlpha.getText())));
            kValCattle.setText(String.valueOf(1 / Double.parseDouble(hValCattle.getText())));
            kValDeer.setText(String.valueOf(1 / Double.parseDouble(hValDeer.getText())));
            kValHorse.setText(String.valueOf(1 / Double.parseDouble(hValHorse.getText())));
        }catch (IOException | ArrayIndexOutOfBoundsException e){
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
        kValCattle.setText(String.valueOf(375 + rand.nextInt(20)));
        kValDeer.setText(String.valueOf(1830 + rand.nextInt(60)));
        kValHorse.setText(String.valueOf(495 + rand.nextInt(20)));
        dValCattle.setText(String.valueOf(0.5 + 0.5 * rand.nextDouble()));
        dValDeer.setText(String.valueOf(0.9 + 0.5 * rand.nextDouble()));
        dValHorse.setText(String.valueOf(8 + 0.4 * rand.nextDouble()));
        hValCattle.setText(String.valueOf(0.35 + 0.3* rand.nextDouble()));
        hValDeer.setText(String.valueOf(0.02 + 0.04 * rand.nextDouble()));
        hValHorse.setText(String.valueOf(0.2 + 0.2 * rand.nextDouble()));
        predatorAlpha.setText(String.valueOf(0.17 + 0.1 * rand.nextDouble()));
    }

    @FXML
    public void handleShowPredictions() throws IllegalFieldException {
        tableView.getItems().clear();
        try{
            int t = Integer.parseInt(timeValue.getText());
            int nCattle = Integer.parseInt(nValCattle.getText());
            int nDeer = Integer.parseInt(nValDeer.getText());
            int nHorse = Integer.parseInt(nValHorse.getText());
            int yearVal =1;
            int nWolf = Integer.parseInt(predatorPopulation.getText());
            double percentileCattle = (double) CSVReader.getN(importDataScreenController.getFiles().get("CattleData")) / ((CSVReader.getN(importDataScreenController.getFiles().get("CattleData"))) + CSVReader.getN(importDataScreenController.getFiles().get("DeerData")) + CSVReader.getN(importDataScreenController.getFiles().get("HorseData")));
            double percentileDeer = (double) CSVReader.getN(importDataScreenController.getFiles().get("DeerData")) / ((CSVReader.getN(importDataScreenController.getFiles().get("CattleData"))) + CSVReader.getN(importDataScreenController.getFiles().get("DeerData")) + CSVReader.getN(importDataScreenController.getFiles().get("HorseData")));
            double percentileHorse = (double) CSVReader.getN(importDataScreenController.getFiles().get("HorseData")) / ((CSVReader.getN(importDataScreenController.getFiles().get("CattleData"))) + CSVReader.getN(importDataScreenController.getFiles().get("DeerData")) + CSVReader.getN(importDataScreenController.getFiles().get("HorseData")));
            if (!importDataScreenController.getFiles().isEmpty()) {
                yearVal = CSVReader.getYear(importDataScreenController.getFiles().get("CattleData"));
            }
            for (int i = 1; i<=t; i++) {
                nCattle += (int) (((Double.parseDouble(rValCattle.getText()) * Integer.parseInt(nValCattle.getText())) - ((Double.parseDouble(kValCattle.getText()) * nWolf * (Math.pow(Integer.parseInt(nValCattle.getText()) , 2))) / ((Math.pow(Integer.parseInt(nValCattle.getText()) , 2)) + (Double.parseDouble(dValCattle.getText()) * Double.parseDouble(dValCattle.getText()) )))) * percentileCattle);
                nDeer += (int) (((Double.parseDouble(rValDeer.getText()) * Integer.parseInt(nValDeer.getText())) - ((Double.parseDouble(kValDeer.getText()) * nWolf * (Math.pow(Integer.parseInt(nValDeer.getText()) , 2))) / ((Math.pow(Integer.parseInt(nValDeer.getText()) , 2)) + (Double.parseDouble(dValDeer.getText()) * Double.parseDouble(dValDeer.getText()) )))) * percentileDeer);
                nHorse += (int) (((Double.parseDouble(rValHorse.getText()) * Integer.parseInt(nValHorse.getText())) - ((Double.parseDouble(kValHorse.getText()) * nWolf * (Math.pow(Integer.parseInt(nValHorse.getText()) , 2))) / ((Math.pow(Integer.parseInt(nValHorse.getText()) , 2)) + (Double.parseDouble(dValHorse.getText()) * Double.parseDouble(dValHorse.getText()) )))) * percentileHorse);
                nWolf = calcWolfs(Double.parseDouble(predatorAlpha.getText()) , (nCattle + nDeer + nWolf)/3);
                if (nCattle < 0){
                    nCattle = 0;
                }
                if (nDeer < 0){
                    nDeer = 0;
                }
                if(nHorse < 0){
                    nHorse = 0;
                }
                if (nWolf < 0){
                    nWolf = 0;
                }

                predictions.add(new Predictions(yearVal , nCattle, nDeer , nHorse , nWolf));
                yearVal++;
            }
            year.setCellValueFactory(cellData -> cellData.getValue().yearProperty().asObject());
            cattleNumber.setCellValueFactory(cellData -> cellData.getValue().cattleProperty().asObject());
            deerNumber.setCellValueFactory(cellData -> cellData.getValue().deerProperty().asObject());
            horseNumber.setCellValueFactory(cellData -> cellData.getValue().horseProperty().asObject());
            wolfs.setCellValueFactory(cellData -> cellData.getValue().wolfsProperty().asObject());
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
    public int calcWolfs(double alfa, int pop){
        int amountOfWolfs = Integer.parseInt(predatorPopulation.getText());
        int dvdtW = (int)  (alfa * pop * amountOfWolfs - (0.2 * amountOfWolfs * amountOfWolfs));
        if(dvdtW <= -50) {
            dvdtW = -50;
            amountOfWolfs += dvdtW/3;
        }if (dvdtW >= 20){
            dvdtW =20;
            amountOfWolfs += dvdtW/3;
        }else{
            amountOfWolfs += dvdtW/3;
        }
        return amountOfWolfs;
    }

    public static ObservableList<Predictions> getPredictions() {
        return predictions;
    }
}
