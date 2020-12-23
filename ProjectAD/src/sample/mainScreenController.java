package sample;

import javafx.stage.Stage;

public class mainScreenController {

    private Main mainApp;

    public void setMainApp(Main mainApp){
        this.mainApp = mainApp;
    }

    public void handleImportData(){
        mainApp.showImportDataScreen();
    }







}
