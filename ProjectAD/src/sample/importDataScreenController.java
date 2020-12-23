package sample;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class importDataScreenController {

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

}
