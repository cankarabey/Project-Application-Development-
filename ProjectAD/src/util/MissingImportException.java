package util;

import javafx.scene.control.Alert;

public class MissingImportException extends Exception{

    public MissingImportException(Throwable cause){
        Alert emptyField = new Alert(Alert.AlertType.ERROR);
        emptyField.setTitle("Error");
        emptyField.setHeaderText("Missing Import");
        emptyField.setContentText("Data is not imported.\nTo import data go to File -> Import then select the correct" +
                " .csv files");
        emptyField.showAndWait();
        cause.printStackTrace();
    }
}
