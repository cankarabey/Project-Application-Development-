package sample;

import javafx.stage.Stage;

public class mainScreenController {

    private Main mainApp;
    private Stage dialogStage;
    private boolean saveClicked = false;

    public void setMainApp(Main mainApp){
        this.mainApp = mainApp;
    }

    public void handleImportData(){
        mainApp.showImportDataScreen();
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean saveClicked(){
        return saveClicked;
    }





}
