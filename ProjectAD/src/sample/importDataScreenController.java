package sample;

import javafx.fxml.FXML;
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
        System.out.println(files);
    }
    @FXML
    public void handleChooseFileDD() {
        files.put("DeerData" , getFile());
        System.out.println(files);
    }
    @FXML
    public void handleChooseFileHD() {
        files.put("HorseData" , getFile());
        System.out.println(files);
    }
    @FXML
    public void handleChooseFileCHA() {
        files.put("CattleHorseAvg" , getFile());
        System.out.println(files);
    }
    @FXML
    public void handleChooseFileCLT() {   //cattle life table
        files.put("CattleLifeTable" , getFile());
        System.out.println(files);
    }
    @FXML
    public void handleChooseFileDLT() {
        files.put("DeerLifeTable" , getFile());
        System.out.println(files);
    }
    @FXML
    public void handleChooseFileHLT() {
        files.put("HorseLifeTable" , getFile());
        System.out.println(files);
    }
    @FXML
    public void handleChooseFileWD() {
        files.put("Wolfs" , getFile());
        System.out.println(files);
    }


}
