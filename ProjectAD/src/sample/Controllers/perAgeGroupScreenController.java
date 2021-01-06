package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import util.Predictions;
import util.perAgeGroupPredictions;

public class perAgeGroupScreenController {

    @FXML private static TableView<perAgeGroupPredictions> tableViewCattle;
    @FXML private static TableColumn<perAgeGroupPredictions , Integer> newBornCattle;
    @FXML private static TableColumn<perAgeGroupPredictions , Integer> youngCattle;
    @FXML private static TableColumn<perAgeGroupPredictions , Integer> adultCattle;
    @FXML private static TableColumn<perAgeGroupPredictions , Integer> oldCattle;

    @FXML private static TableView<perAgeGroupPredictions> tableViewDeer;
    @FXML private static TableColumn<perAgeGroupPredictions , Integer> newBornDeer;
    @FXML private static TableColumn<perAgeGroupPredictions , Integer> youngDeer;
    @FXML private static TableColumn<perAgeGroupPredictions , Integer> adultDeer;
    @FXML private static TableColumn<perAgeGroupPredictions , Integer> oldDeer;

    @FXML private static TableView<perAgeGroupPredictions> tableViewHorse;
    @FXML private static TableColumn<perAgeGroupPredictions , Integer> newBornHorse;
    @FXML private static TableColumn<perAgeGroupPredictions , Integer> youngHorse;
    @FXML private static TableColumn<perAgeGroupPredictions , Integer> adultHorse;
    @FXML private static TableColumn<perAgeGroupPredictions , Integer> oldHorse;

    @FXML public static void showPerAgeGroup(ObservableList<ObservableList<perAgeGroupPredictions>> ageGroups){
        Stage s = new Stage();
        Pane p = new Pane();

        /*
        newBornCattle.setCellValueFactory(cellData -> cellData.getValue().newBornProperty().asObject());
        youngCattle.setCellValueFactory(cellData -> cellData.getValue().youngProperty().asObject());
        adultCattle.setCellValueFactory(cellData -> cellData.getValue().adultProperty().asObject());
        oldCattle.setCellValueFactory(cellData -> cellData.getValue().oldProperty().asObject());
        tableViewCattle.setItems(ageGroups.get(0));

        newBornDeer.setCellValueFactory(cellData -> cellData.getValue().newBornProperty().asObject());
        youngDeer.setCellValueFactory(cellData -> cellData.getValue().youngProperty().asObject());
        adultDeer.setCellValueFactory(cellData -> cellData.getValue().adultProperty().asObject());
        oldDeer.setCellValueFactory(cellData -> cellData.getValue().oldProperty().asObject());
        tableViewDeer.setItems(ageGroups.get(1));

        newBornHorse.setCellValueFactory(cellData -> cellData.getValue().newBornProperty().asObject());
        youngHorse.setCellValueFactory(cellData -> cellData.getValue().youngProperty().asObject());
        adultHorse.setCellValueFactory(cellData -> cellData.getValue().adultProperty().asObject());
        oldHorse.setCellValueFactory(cellData -> cellData.getValue().oldProperty().asObject());
        tableViewHorse.setItems(ageGroups.get(2));

         */

        
        Scene sc = new Scene(p);
        s.setScene(sc);
        s.show();

    }

}
