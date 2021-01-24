package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class helpScreenController {
    private boolean okClicked = false;
    private Stage dialogStage;
    @FXML private Hyperlink userManual;

    @FXML
    private void initialize(){}

    public void openManual() {
        try{
            File file = new File("src"+File.separator+"Data/UserManualApplicationDevelopment.pdf");
            Desktop.getDesktop().open(file);
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isOkClicked() {
        return okClicked;
    }
}
