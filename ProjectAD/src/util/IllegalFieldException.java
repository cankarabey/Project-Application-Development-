package util;

import javafx.scene.control.Alert;

public class IllegalFieldException extends Exception{

    public IllegalFieldException(Throwable cause){
        Alert emptyField = new Alert(Alert.AlertType.ERROR);
        emptyField.setTitle("Error");
        emptyField.setHeaderText("Invalid Fields");
        emptyField.setContentText("One or more parameter fields are empty or have illegal input. \nPlease fill in " +
                "the field(s) with valid values or use 'Get Parameters' to use imported data");
        emptyField.showAndWait();
        cause.printStackTrace();
    }

}
