package sample.Controllers;


import javafx.fxml.FXML;
import sample.Main;
import util.handleSaving;


public class mainScreenController {

    private Main mainApp;

    public void setMainApp(Main mainApp){
        this.mainApp = mainApp;
    }

    @FXML
    public void handleImportData() {
        mainApp.showImportDataScreen();
    }

    @FXML public void handleSaveButton(){
        handleSaving.handleSave();
    }

    @FXML public void handleHelp() { mainApp.showHelpScreen(); }






}
