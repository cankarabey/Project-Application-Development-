package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import util.CSVReader;
import util.IllegalFieldException;
import util.IllegalImportException;
import util.Predictions;

import java.io.IOException;

public class grassTabController {
    @FXML private TextField avgTemp;
    @FXML private TextField optTemp;
    @FXML private TextField timeValue;
    @FXML private BarChart<Integer, Double> barChart;
    @FXML private CategoryAxis xAxis;
    @FXML private NumberAxis yAxis;

    public void handleShowPredictions(){
        try{
            XYChart.Series<Integer, Double> series = new XYChart.Series<>();
            series.setName("Grass weight");
            //XYChart.Data<Integer, Double> data = new XYChart.Data<>();
            double GP = CSVReader.getGrowthPotential(importDataScreenController.getFiles().get("Grass"));
            int t = Integer.parseInt(timeValue.getText());
            int averageTemp = Integer.parseInt(avgTemp.getText());
            int optimalTemp = Integer.parseInt(optTemp.getText());
//            int yearVal =1;
//            if (!importDataScreenController.getFiles().isEmpty()) {
//                yearVal = CSVReader.getYear(importDataScreenController.getFiles().get("Grass"));
//            }
            for (int i = 1; i<=t; i++) {
                Double GrowthPotential = Math.pow(Math.E, -0.5 * Math.pow(((optimalTemp-averageTemp)/GP), 2)) * 60 * 5600;
                System.out.println(GrowthPotential);
                series.getData().add(new XYChart.Data<Integer, Double>(i, GrowthPotential));
                //grass.put(i, GrowthPotential);
                GP = GP - 0.55;
            }
            barChart.getData().add(series);

        } catch (IOException | NumberFormatException e){
            e.printStackTrace();
        }

    }
}
