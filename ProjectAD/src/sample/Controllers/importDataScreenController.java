package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import util.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class importDataScreenController {

    private static HashMap<String,FileReader> files = new HashMap<>();
    private boolean okClicked = false;
    private Stage dialogStage;

    @FXML private Button cattleDataButton;
    @FXML private Button deerDataButton;
    @FXML private Button horseDataButton;
    @FXML private Button cattleLifeTableButton;
    @FXML private Button deerLifeTableButton;
    @FXML private Button horseLifeTableButton;
    @FXML private Button cattleHorseAvgButton;
    @FXML private Button wolfsDataButton;

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
        //exponentialTabController.setText();
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
    public void handleChooseFileCD() {  //CD = cattle data
        files.put("CattleData" , getFile());
        cattleDataButton.setText("Imported!");
    }
    @FXML
    public void handleChooseFileDD() {  //DD = Deer Data
        files.put("DeerData" , getFile());
        deerDataButton.setText("Imported!");
    }
    @FXML
    public void handleChooseFileHD() {  //HD = Horse Data
        files.put("HorseData" , getFile());
        horseDataButton.setText("Imported!");
    }
    @FXML
    public void handleChooseFileCHA() {
        files.put("CattleHorseAvg" , getFile());
        cattleHorseAvgButton.setText("Imported!");
    }
    @FXML
    public void handleChooseFileCLT() {   // CLT = Cattle Life Table
        files.put("CattleLifeTable" , getFile());
        cattleLifeTableButton.setText("Imported!");
    }
    @FXML
    public void handleChooseFileDLT() { // DLT = Deer Life Table
        files.put("DeerLifeTable" , getFile());
        deerLifeTableButton.setText("Imported!");
    }
    @FXML
    public void handleChooseFileHLT() { // HLT = Horse Life Table
        files.put("HorseLifeTable" , getFile());
        horseLifeTableButton.setText("Imported!");
    }
    @FXML
    public void handleChooseFileWD() {  // WD = Wolf Data
        files.put("Wolfs" , getFile());
        wolfsDataButton.setText("Imported!");
    }

    public static HashMap<String, FileReader> getFiles() {
        return files;
    }
}
