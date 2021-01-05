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
import util.Predictions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class lineChartController {

    @FXML
    static
    LineChart<Integer , Integer> lineChart;


    public static void showLineChart(ObservableList<Predictions> predictions) throws IOException {

        Stage s = new Stage();
        Pane p = new Pane();
        ObservableList<XYChart.Series> sl = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> cattle = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> deer = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> horse = FXCollections.observableArrayList();
        for (int i = 0 ; i < predictions.size() - 1 ; i++){
            cattle.add(new XYChart.Data(predictions.get(i).getYear() , predictions.get(i).getCattle()));
            deer.add(new XYChart.Data(predictions.get(i).getYear() , predictions.get(i).getDeer()));
            horse.add(new XYChart.Data(predictions.get(i).getYear() , predictions.get(i).getHorse()));
        }

        ArrayList<Integer> allNumbers = new ArrayList<>();
        for(Predictions pred : predictions){
            allNumbers.add(pred.getCattle());
            allNumbers.add(pred.getHorse());
            allNumbers.add(pred.getDeer());
        }

        sl.add(new XYChart.Series("Cattle", cattle));
        sl.add(new XYChart.Series("Deer", deer));
        sl.add(new XYChart.Series("Horse", horse));
        Axis x = new NumberAxis("Year", predictions.get(0).getYear(), predictions.get(predictions.size() -1).getYear(), 1);
        Axis y = new NumberAxis("Population Size", 0, Collections.max(allNumbers), 50);
        LineChart c = new LineChart(x, y, sl);
        c.setTitle("Population Size");
        p.getChildren().add(c);
        Scene sc = new Scene(p);
        s.setScene(sc);
        s.show();

    }
}
