package sample.Controllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class helpScreenController {
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
}
