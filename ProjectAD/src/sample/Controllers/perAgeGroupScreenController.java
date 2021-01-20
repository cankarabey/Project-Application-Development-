package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import util.CSVReader;
import util.perAgeGroupPredictions;

import java.io.IOException;
import java.util.ArrayList;;
import java.util.Collections;

public class perAgeGroupScreenController {

    private Stage dialogStage;
    @FXML private static LineChart<Integer,Integer> cattleChart;
    @FXML private static LineChart<Integer,Integer> deerChart;
    @FXML private static LineChart<Integer,Integer> horseChart;


    public static void showPerAgeGroup(ObservableList<ObservableList<perAgeGroupPredictions>> ageGroups) throws IOException {

        showChart(ageGroups.get(0) , "CattleData" , cattleChart);
        showChart(ageGroups.get(1) , "DeerData" , deerChart);
        showChart(ageGroups.get(2) , "HorseData" , horseChart);

    }

    public static void showChart(ObservableList<perAgeGroupPredictions> data , String name , LineChart lineChart) throws IOException {
        Stage s = new Stage();
        Pane p = new Pane();

        ObservableList<XYChart.Series> chart = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> newBorn = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> young = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> adult = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> old = FXCollections.observableArrayList();
        int year = CSVReader.getYear(importDataScreenController.getFiles().get(name));
        for (int i = 0 ; i < data.size() - 1 ; i++){
            newBorn.add(new XYChart.Data(year , data.get(i).getNewBorn()));
            young.add(new XYChart.Data(year , data.get(i).getYoung()));
            adult.add(new XYChart.Data(year , data.get(i).getAdult()));
            old.add(new XYChart.Data(year , data.get(i).getOld()));
            year++;
        }

        ArrayList<Integer> allNumbers = new ArrayList<>();
        for( perAgeGroupPredictions predictions : data){
            allNumbers.add(predictions.getNewBorn());
        }


        chart.add(new XYChart.Series("New Born", newBorn));
        chart.add(new XYChart.Series("Young", young));
        chart.add(new XYChart.Series("Adult", adult));
        chart.add(new XYChart.Series("Old", old));
        Axis x = new NumberAxis("Year", CSVReader.getYear(importDataScreenController.getFiles().get(name)), year, 1);
        Axis y = new NumberAxis("Population per Age Group", 0, Collections.max(allNumbers), 50);
        lineChart = new LineChart(x , y , chart);

        lineChart.setTitle(name);
        p.getChildren().add(lineChart);
        Scene sc = new Scene(p);
        s.setScene(sc);
        s.show();
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

}
