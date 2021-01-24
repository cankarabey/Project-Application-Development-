package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.PieChart;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import util.Predictions;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class pieChartController {

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
        saveAsPng(pieChart);
    }

    public static void saveAsPng(PieChart pieChart) {
        WritableImage image = pieChart.snapshot(new SnapshotParameters(), null);
        File file = new File("pieChart.png");

        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
