package util;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class perAgeGroupPredictions {

    private IntegerProperty newBorn;
    private IntegerProperty young;
    private IntegerProperty adult;
    private IntegerProperty old;

    public perAgeGroupPredictions(int newBorn, int young, int adult, int old) {
        this.newBorn = new SimpleIntegerProperty(newBorn);
        this.young = new SimpleIntegerProperty(young);
        this.adult = new SimpleIntegerProperty(adult);
        this.old = new SimpleIntegerProperty(old);
    }

    public int getNewBorn() {
        return newBorn.get();
    }

    public IntegerProperty newBornProperty() {
        return newBorn;
    }

    public int getYoung() {
        return young.get();
    }

    public IntegerProperty youngProperty() {
        return young;
    }

    public int getAdult() {
        return adult.get();
    }

    public IntegerProperty adultProperty() {
        return adult;
    }

    public int getOld() {
        return old.get();
    }

    public IntegerProperty oldProperty() {
        return old;
    }
}
