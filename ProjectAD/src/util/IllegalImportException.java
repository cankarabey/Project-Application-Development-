package util;

import javafx.scene.control.Alert;

public class IllegalImportException extends Exception{

    public IllegalImportException(Throwable cause){
        Alert emptyField = new Alert(Alert.AlertType.ERROR);
        emptyField.setTitle("Error");
        emptyField.setHeaderText("Illegal Import");
        emptyField.setContentText("The data imported is not in the correct format.\nPlease use a different .csv file.");
        emptyField.showAndWait();
        cause.printStackTrace();
    }
}
