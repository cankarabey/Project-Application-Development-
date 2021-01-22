package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import util.*;

import java.io.IOException;

public class grassTabController {
    @FXML private TextField avgTemp;
    @FXML private TextField optTemp;
    @FXML private TextField timeValue;
    @FXML private TableView<GrassPredictions> tableView;
    @FXML private TableColumn<GrassPredictions , Integer> year;
    @FXML private TableColumn<GrassPredictions , Double> weight;
    @FXML private TableColumn<GrassPredictions , Integer> height;
    private ObservableList<GrassPredictions> predictions = FXCollections.observableArrayList();
    @FXML private CheckBox checkBoxBar;

    public void handleShowPredictions(){
        try{
            double GP = CSVReader.getGrowthPotential(importDataScreenController.getFiles().get("Grass"));
            int t = Integer.parseInt(timeValue.getText());
            int averageTemp = Integer.parseInt(avgTemp.getText());
            int optimalTemp = Integer.parseInt(optTemp.getText());
            int yearVal =1;
//            if (!importDataScreenController.getFiles().isEmpty()) {
//                yearVal = CSVReader.getYear(importDataScreenController.getFiles().get("Grass"));
//            }

            for (int i = 1; i<=t; i++) {
                Double GrowthPotential = Math.pow(Math.E, -0.5 * Math.pow(((optimalTemp-averageTemp)/GP), 2)) * 60 * 5600;
                predictions.add(new GrassPredictions(yearVal, Math.round(GrowthPotential*100.00)/100.00));
                GP = GP - 0.55;
                yearVal ++;
            }
            year.setCellValueFactory(cellData -> cellData.getValue().yearProperty().asObject());
            weight.setCellValueFactory(cellData -> cellData.getValue().weightProperty().asObject());
            tableView.setItems(predictions);

            if(checkBoxBar.isSelected()){
                barChartController.showBarChart(predictions);
            }

        } catch (IOException | NumberFormatException e){
            e.printStackTrace();
        }

    }
}
