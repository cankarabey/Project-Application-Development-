package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import util.Predictions;

public class pieChartController {

    @FXML
    static PieChart pieChart;

    public static void showPieChart(ObservableList<Predictions> predictions){

        Stage s = new Stage();
        Pane p = new Pane();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Cattle", predictions.get(predictions.size() - 1).getCattle()),
                new PieChart.Data("Deer", predictions.get(predictions.size() - 1).getDeer()),
                new PieChart.Data("Horse", predictions.get(predictions.size() - 1).getHorse()));

        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Population Ratio");
        pieChart.setData(pieChartData);
        p.getChildren().add(pieChart);
        Scene sc = new Scene(p);
        s.setScene(sc);
        s.show();
    }
}
