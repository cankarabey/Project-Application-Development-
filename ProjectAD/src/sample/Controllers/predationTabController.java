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
<<<<<<< Updated upstream
    @FXML private Button randomButton;
    private ObservableList<Predictions> predictions = FXCollections.observableArrayList();
=======
    private static ObservableList<Predictions> predictions = FXCollections.observableArrayList();
>>>>>>> Stashed changes


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
                    nCattle = nCattle - (((int) (Double.parseDouble(rValCattle.getText()) * nCattle * i - (((Double.parseDouble(kValCattle.getText()) * (nCattle ^ 2))) / ((nCattle ^ 2) + (Double.parseDouble(dValCattle.getText()) * Double.parseDouble(dValCattle.getText())))) * Integer.parseInt(predatorPopulation.getText()) * i))/3);
                    nDeer = nDeer - (((int) (Double.parseDouble(rValDeer.getText()) * nDeer * i - (((Double.parseDouble(kValDeer.getText()) * (nDeer ^ 2))) / ((nDeer ^ 2) + (Double.parseDouble(dValDeer.getText()) * Double.parseDouble(dValDeer.getText())))) * Integer.parseInt(predatorPopulation.getText()) * i))/3);
                    nHorse = nHorse - (((int) (Double.parseDouble(rValHorse.getText()) * nHorse * i - (((Double.parseDouble(kValHorse.getText()) * (nHorse ^ 2))) / ((nHorse ^ 2) + (Double.parseDouble(dValHorse.getText()) * Double.parseDouble(dValHorse.getText())))) * Integer.parseInt(predatorPopulation.getText()) * i))/3);
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

    public static ObservableList<Predictions> getPredictions() {
        return predictions;
    }
}
