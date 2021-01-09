package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import util.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

public class importDataScreenController {

    private static HashMap<String,File> files = new HashMap<>();
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
        String text = "";
        if(!files.containsKey("CattleData")){
            text += "Missing Cattle Data...\n";
        }
        if(!files.containsKey("DeerData")){
            text += "Missing Deer Data...\n";
        }
        if(!files.containsKey("HorseData")){
            text += "Missing Horse Data...\n";
        }
        if(!files.containsKey("CattleHorseAvg")){
            text += "Missing Cattle Horse Average Data...\n";
        }
        if(!files.containsKey("CattleLifeTable")){
            text += "Missing Cattle Life Data...\n";
        }
        if(!files.containsKey("DeerLifeTable")){
            text += "Missing Deer Life Data...\n";
        }
        if(!files.containsKey("HorseLifeTable")){
            text += "Missing Horse Life Data...\n";
        }
        if(!files.containsKey("Wolfs")){
            text += "Missing Wolfs Data...\n";
        }
        if(!text.isEmpty()){
            Alert missingFiles = new Alert(Alert.AlertType.CONFIRMATION);
            missingFiles.setTitle("Warning!");
            missingFiles.setHeaderText("Missing Files");
            missingFiles.setContentText(text + "\nThe Application requires the files above and may not work as " +
                    "intended.\n\nDo you still wish to continue?");
            Optional<ButtonType> result = missingFiles.showAndWait();
            if (result.get() == ButtonType.OK){
                dialogStage.close();
            } else {
                missingFiles.close();
            }
        }

    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    @FXML
    public File getFile(){
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(dialogStage);
        return file;
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

    public static HashMap<String, File> getFiles() {
        return files;
    }
}
