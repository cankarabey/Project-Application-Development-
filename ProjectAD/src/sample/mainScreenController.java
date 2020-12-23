package sample;


import javafx.fxml.FXML;

public class mainScreenController {

    private Main mainApp;

    public void setMainApp(Main mainApp){
        this.mainApp = mainApp;
    }

    @FXML
    public void handleImportData(){
        mainApp.showImportDataScreen();
    }







}
