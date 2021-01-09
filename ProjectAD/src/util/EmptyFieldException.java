package util;

import javafx.scene.control.Alert;

public class EmptyFieldException extends Exception{

    public EmptyFieldException(Throwable cause){
        Alert emptyField = new Alert(Alert.AlertType.ERROR);
        emptyField.setTitle("Error");
        emptyField.setHeaderText("Empty Fields");
        emptyField.setContentText("One or more parameter fields are empty. Please fill in the field(s) or use 'Get " +
                "Parameters' to use imported data");
        emptyField.showAndWait();
        cause.printStackTrace();
    }

}
