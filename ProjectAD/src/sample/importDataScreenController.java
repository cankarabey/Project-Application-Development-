package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class importDataScreenController {

    private HashMap<String,FileReader> files = new HashMap<>();
    private boolean okClicked = false;
    private Stage dialogStage;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    public void handleSave(){
        //do stuff here
        dialogStage.close();
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    @FXML
    public FileReader getFile(){
        try {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showOpenDialog(dialogStage);
            return new FileReader(file);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    @FXML
    public void handleChooseFileCD() {   //CD = cattle data
        files.put("CattleData" , getFile());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Succesfully imported Cattle Data");
        alert.showAndWait();
    }
    @FXML
    public void handleChooseFileDD() {
        files.put("DeerData" , getFile());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Succesfully imported Deer Data");
        alert.showAndWait();
    }
    @FXML
    public void handleChooseFileHD() {
        files.put("HorseData" , getFile());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Succesfully imported Horse Data");
        alert.showAndWait();
    }
    @FXML
    public void handleChooseFileCHA() {
        files.put("CattleHorseAvg" , getFile());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Succesfully imported Cattle Horse Avg Data");
        alert.showAndWait();
    }
    @FXML
    public void handleChooseFileCLT() {   //cattle life table
        files.put("CattleLifeTable" , getFile());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Succesfully imported Cattle Life Table");
        alert.showAndWait();
    }
    @FXML
    public void handleChooseFileDLT() {
        files.put("DeerLifeTable" , getFile());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Succesfully imported Deer Life Table");
        alert.showAndWait();
    }
    @FXML
    public void handleChooseFileHLT() {
        files.put("HorseLifeTable" , getFile());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Succesfully imported Horse Life Table");
        alert.showAndWait();

    }
    @FXML
    public void handleChooseFileWD() {
        files.put("Wolfs" , getFile());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Succesfully imported Wolf Data");
        alert.showAndWait();
    }

    public HashMap<String, FileReader> getFiles() {
        return files;
    }
}
