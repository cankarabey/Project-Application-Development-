package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import util.CSVReader;
import util.IllegalFieldException;
import util.Predictions;
import util.perAgeGroupPredictions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ageTabController {
    @FXML private Tab age;
    @FXML private TextField f1Cattle;
    @FXML private TextField f2Cattle;
    @FXML private TextField f3Cattle;
    @FXML private TextField g1Cattle;
    @FXML private TextField g2Cattle;
    @FXML private TextField g3Cattle;
    @FXML private TextField f1Deer;
    @FXML private TextField f2Deer;
    @FXML private TextField f3Deer;
    @FXML private TextField g1Deer;
    @FXML private TextField g2Deer;
    @FXML private TextField g3Deer;
    @FXML private TextField f1Horse;
    @FXML private TextField f2Horse;
    @FXML private TextField f3Horse;
    @FXML private TextField g1Horse;
    @FXML private TextField g2Horse;
    @FXML private TextField g3Horse;
    @FXML private TextField t;
    @FXML private CheckBox perAgeGroup;
    @FXML private CheckBox checkBoxPie;
    @FXML private CheckBox checkBoxLine;
    @FXML private TableView<Predictions> tableView;
    @FXML private TableColumn<Predictions , Integer> year;
    @FXML private TableColumn<Predictions , Integer> cattleNumber;
    @FXML private TableColumn<Predictions , Integer> deerNumber;
    @FXML private TableColumn<Predictions , Integer> horseNumber;
    private ObservableList<Predictions> predictions = FXCollections.observableArrayList();

    private ObservableList<perAgeGroupPredictions> predictionsCattle = FXCollections.observableArrayList();
    private ObservableList<perAgeGroupPredictions> predictionsDeer = FXCollections.observableArrayList();
    private ObservableList<perAgeGroupPredictions> predictionsHorse = FXCollections.observableArrayList();
    private ObservableList<ObservableList<perAgeGroupPredictions>> ageGroups = FXCollections.observableArrayList();

    @FXML
    public void setText() throws IOException {
        HashMap<String, File> map = importDataScreenController.getFiles();
        ArrayList<Double> pValuesCattle = (ArrayList<Double>) CSVReader.PandFlist(map.get("CattleLifeTable")).get(0);
        ArrayList<Double> fValuesCattle = (ArrayList<Double>) CSVReader.PandFlist(map.get("CattleLifeTable")).get(1);
        ArrayList<Double> pValuesDeer = (ArrayList<Double>) CSVReader.PandFlist(map.get("DeerLifeTable")).get(0);
        ArrayList<Double> fValuesDeer = (ArrayList<Double>) CSVReader.PandFlist(map.get("DeerLifeTable")).get(1);
        ArrayList<Double> pValuesHorse = (ArrayList<Double>) CSVReader.PandFlist(map.get("DeerLifeTable")).get(0);
        ArrayList<Double> fValuesHorse = (ArrayList<Double>) CSVReader.PandFlist(map.get("DeerLifeTable")).get(1);

        f1Cattle.setText(String.valueOf(fValuesCattle.get(0)));
        f1Deer.setText(String.valueOf(fValuesDeer.get(0)));
        f1Horse.setText(String.valueOf(fValuesHorse.get(0)));
        f2Cattle.setText(String.valueOf(fValuesCattle.get(1)));
        f2Deer.setText(String.valueOf(fValuesDeer.get(1)));
        f2Horse.setText(String.valueOf(fValuesHorse.get(1)));
        f3Cattle.setText(String.valueOf(fValuesCattle.get(2)));
        f3Deer.setText(String.valueOf(fValuesDeer.get(2)));
        f3Horse.setText(String.valueOf(fValuesHorse.get(2)));
        g1Cattle.setText(String.valueOf(pValuesCattle.get(0)));
        g1Deer.setText(String.valueOf(pValuesDeer.get(0)));
        g1Horse.setText(String.valueOf(pValuesHorse.get(0)));
        g2Cattle.setText(String.valueOf(pValuesCattle.get(1)));
        g2Deer.setText(String.valueOf(pValuesDeer.get(1)));
        g2Horse.setText(String.valueOf(pValuesHorse.get(1)));
        g3Cattle.setText(String.valueOf(pValuesCattle.get(2)));
        g3Deer.setText(String.valueOf(pValuesDeer.get(2)));
        g3Horse.setText(String.valueOf(pValuesHorse.get(2)));

    }

    @FXML public void handleShowPredictions() throws IllegalFieldException {
        try{
            int yearVal =1;
            if (!importDataScreenController.getFiles().isEmpty()) {
                yearVal = CSVReader.getYear(importDataScreenController.getFiles().get("CattleData"));
            }
            int birthsLastYearCattle = CSVReader.getBirths(importDataScreenController.getFiles().get("CattleData"));
            int ageGroupOneCattle = birthsLastYearCattle;
            int ageGroupTwoCattle = (int) (birthsLastYearCattle * Double.parseDouble(g1Cattle.getText()));
            int ageGroupThreeCattle = (int) (ageGroupTwoCattle * Double.parseDouble(g2Cattle.getText()));
            int ageGroupFourCattle = (int) (ageGroupThreeCattle * Double.parseDouble(g3Cattle.getText()));

            int birthsLastYearDeer = CSVReader.getBirths(importDataScreenController.getFiles().get("DeerData"));
            int ageGroupOneDeer = birthsLastYearDeer;
            int ageGroupTwoDeer = (int) (birthsLastYearCattle * Double.parseDouble(g1Deer.getText()));
            int ageGroupThreeDeer = (int) (ageGroupTwoCattle * Double.parseDouble(g2Deer.getText()));
            int ageGroupFourDeer = (int) (ageGroupThreeCattle * Double.parseDouble(g3Deer.getText()));

            int birthsLastYearHorse = CSVReader.getBirths(importDataScreenController.getFiles().get("HorseData"));
            int ageGroupOneHorse = birthsLastYearHorse;
            int ageGroupTwoHorse = (int) (birthsLastYearCattle * Double.parseDouble(g1Horse.getText()));
            int ageGroupThreeHorse = (int) (ageGroupTwoCattle * Double.parseDouble(g2Horse.getText()));
            int ageGroupFourHorse = (int) (ageGroupThreeCattle * Double.parseDouble(g3Horse.getText()));

            for (int i = 0 ; i < Integer.parseInt(t.getText()) ; i++) {
                ageGroupFourCattle = (int) (ageGroupThreeCattle * Double.parseDouble(g3Cattle.getText()));
                ageGroupThreeCattle = (int) (ageGroupTwoCattle * Double.parseDouble(g2Cattle.getText()));
                ageGroupTwoCattle = (int) (ageGroupOneCattle * Double.parseDouble(g1Cattle.getText()));
                ageGroupOneCattle = (int) ((Double.parseDouble(f1Cattle.getText()) * ageGroupOneCattle) + (Double.parseDouble(f2Cattle.getText()) * ageGroupTwoCattle) + (Double.parseDouble(f3Cattle.getText()) * ageGroupThreeCattle) + (0 * ageGroupFourCattle));
                int totalCattle = ageGroupOneCattle+ ageGroupTwoCattle + ageGroupThreeCattle + ageGroupFourCattle;
                predictionsCattle.add(new perAgeGroupPredictions(ageGroupOneCattle, ageGroupTwoCattle, ageGroupThreeCattle, ageGroupFourCattle));

                ageGroupFourDeer = (int) (ageGroupThreeDeer * Double.parseDouble(g3Deer.getText()));
                ageGroupThreeDeer = (int) (ageGroupTwoDeer * Double.parseDouble(g2Deer.getText()));
                ageGroupTwoDeer = (int) (ageGroupOneDeer * Double.parseDouble(g1Deer.getText()));
                ageGroupOneDeer = (int) ((Double.parseDouble(f1Deer.getText()) * ageGroupOneDeer) + (Double.parseDouble(f2Deer.getText()) * ageGroupTwoDeer) + (Double.parseDouble(f3Deer.getText()) * ageGroupThreeDeer) + (0 * ageGroupFourDeer));
                int totalDeer = ageGroupOneDeer+ ageGroupTwoDeer + ageGroupThreeDeer + ageGroupFourDeer;
                predictionsDeer.add(new perAgeGroupPredictions(ageGroupOneDeer, ageGroupTwoDeer, ageGroupThreeDeer, ageGroupFourDeer));

                ageGroupFourHorse = (int) (ageGroupThreeHorse * Double.parseDouble(g3Horse.getText()));
                ageGroupThreeHorse = (int) (ageGroupTwoHorse * Double.parseDouble(g2Horse.getText()));
                ageGroupTwoHorse = (int) (ageGroupOneHorse * Double.parseDouble(g1Horse.getText()));
                ageGroupOneHorse = (int) ((Double.parseDouble(f1Horse.getText()) * ageGroupOneHorse) + (Double.parseDouble(f2Horse.getText()) * ageGroupTwoHorse) + (Double.parseDouble(f3Horse.getText()) * ageGroupThreeHorse) + (0 * ageGroupFourHorse));
                int totalHorse = ageGroupOneHorse+ ageGroupTwoHorse + ageGroupThreeHorse + ageGroupFourHorse;
                predictionsHorse.add(new perAgeGroupPredictions(ageGroupOneHorse, ageGroupTwoHorse, ageGroupThreeHorse, ageGroupFourHorse));
                predictions.add(new Predictions(yearVal , totalCattle , totalDeer , totalHorse));
                yearVal++;
            }

            ageGroups.add(predictionsCattle);
            ageGroups.add(predictionsDeer);
            ageGroups.add(predictionsHorse);
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
            if (perAgeGroup.isSelected()){
                perAgeGroupScreenController.showPerAgeGroup(ageGroups);
            }
        } catch (IOException | NumberFormatException e){
            throw new IllegalFieldException(e);
        }
    }

}
