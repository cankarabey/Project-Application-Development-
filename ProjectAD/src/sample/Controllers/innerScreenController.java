package sample.Controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;

public class innerScreenController {

    @FXML private exponentialTabController exponentialTabController;
    @FXML private logisticTabController logisticTabController;
    @FXML private ageTabController ageTabController;
    @FXML private competitiveTabController competitiveTabController;
    @FXML private predationTabController predationTabController;
    @FXML private static Tab logistic;
    private static boolean logSelected = false;
    private static boolean expSelected = false;
    private static boolean ageSelected = false;
    private static boolean compSelected = false;
    private static boolean predSelected = false;
    private static boolean grassSelected = false;

    public void grassSelected(Event event){
        if(!grassSelected){
            grassSelected = true;
        }else{
            grassSelected = false;
        }
    }

    public static boolean isGrassSelected(){
        return grassSelected;
    }

    public void logSelected(Event event) {
        if(!logSelected){
            logSelected = true;
        }
        else{
            logSelected = false;
        }
    }

    public static boolean isLogSelected() {
        return logSelected;
    }

    public void expSelected(Event event) {
        if(!expSelected){
            expSelected = true;
        }
        else{
            expSelected = false;
        }
    }

    public void ageSelected(Event event) {
        if(!ageSelected){
            ageSelected = true;
        }
        else{
            ageSelected = false;
        }
    }

    public void compSelected(Event event) {
        if(!compSelected){
            compSelected = true;
        }
        else{
            compSelected = false;
        }
    }

    public void predSelected(Event event) {
        if(!predSelected){
            predSelected = true;
        }
        else{
            predSelected = false;
        }
    }

    public static boolean isExpSelected() {
        return expSelected;
    }

    public static boolean isAgeSelected() {
        return ageSelected;
    }

    public static boolean isCompSelected() {
        return compSelected;
    }

    public static boolean isPredSelected() {
        return predSelected;
    }
}
