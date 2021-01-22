package sample.Controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import util.GrassPredictions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class barChartController {

    public static void showBarChart(ObservableList<GrassPredictions> predictions) throws IOException{
        Stage stage = new Stage();
        Pane pane = new Pane();

//        CategoryAxis xAxis = new CategoryAxis();
//        NumberAxis yAxis = new NumberAxis();
//        BarChart<Integer, Double> barChart = new BarChart(xAxis, yAxis);
//
//        ObservableList<XYChart.Series<String, Double>> answer = FXCollections.observableArrayList();
//        XYChart.Series<String, Double> weight = new XYChart.Series<>();
//        weight.setName("Weight of Grass");
//
//        for (int i = 0; i < predictions.size() - 1; i++) {
//            weight.getData().add(new XYChart.Data(predictions.get(i).getYear() , predictions.get(i).getWeight()));
//        }



        ObservableList<XYChart.Series> series = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> weight = FXCollections.observableArrayList();

        for (int i = 0; i < predictions.size() - 1; i++) {
            weight.add(new XYChart.Data(predictions.get(i).getYear() , predictions.get(i).getWeight()));
        }

        ArrayList<Double> allData = new ArrayList<>();
        for(GrassPredictions grassPredictions: predictions){
            allData.add(grassPredictions.getWeight());
        }

        series.add(new XYChart.Series("Weight",weight));

        Axis x = new NumberAxis("Year", predictions.get(0).getYear(),
                predictions.get(predictions.size() - 1).getYear(),1);
        Axis y = new NumberAxis("Weight (kilograms)", 0, Collections.max(allData), 10000);

        LineChart lineChart = new LineChart(x, y, series);
        lineChart.setTitle("Weight of Grass");
        pane.getChildren().add(lineChart);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }
}
