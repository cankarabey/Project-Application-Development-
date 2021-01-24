package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.*;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import util.Predictions;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class barChartController {

    public static void showBarChart(ObservableList<Predictions> predictions){
        Stage stage = new Stage();
        Pane pane = new Pane();
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Years");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Kilograms (kg)");
        BarChart<String, Double> barChart = new BarChart(xAxis, yAxis);
        ObservableList<XYChart.Series<String, Double>> answer = FXCollections.observableArrayList();
        XYChart.Series<String, Double> weight = new XYChart.Series<>();
        weight.setName("Weight of Grass");

        for (int i = 0; i < predictions.size() - 1; i++) {
            weight.getData().add(new XYChart.Data<>(Integer.toString(predictions.get(i).getYear()),
                    predictions.get(i).getWeight()));
        }
        answer.add(weight);
        barChart.setData(answer);
        barChart.setTitle("Weight of Grass");
        pane.getChildren().add(barChart);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
        saveAsPng(barChart);
    }

    public static void saveAsPng(BarChart<String, Double> barChart) {
        WritableImage image = barChart.snapshot(new SnapshotParameters(), null);
        File file = new File("barChart.png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
