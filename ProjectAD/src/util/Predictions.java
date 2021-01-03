package util;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Predictions {

    private IntegerProperty year;
    private IntegerProperty cattle;
    private IntegerProperty deer;
    private IntegerProperty horse;

    public Predictions(int year, int cattle, int deer, int horse) {
        this.year = new SimpleIntegerProperty(year);
        this.cattle = new SimpleIntegerProperty(cattle);
        this.deer = new SimpleIntegerProperty(deer);
        this.horse = new SimpleIntegerProperty(horse);
    }

    @Override
    public String toString() {
        return "Predictions{" +
                "year=" + year +
                ", cattle=" + cattle +
                ", deer=" + deer +
                ", horse=" + horse +
                '}';
    }

    public int getYear() {
        return year.get();
    }

    public IntegerProperty yearProperty() {
        return year;
    }

    public int getCattle() {
        return cattle.get();
    }

    public IntegerProperty cattleProperty() {
        return cattle;
    }

    public int getDeer() {
        return deer.get();
    }

    public IntegerProperty deerProperty() {
        return deer;
    }

    public int getHorse() {
        return horse.get();
    }

    public IntegerProperty horseProperty() {
        return horse;
    }
}
