package util;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class GrassPredictions {
    private IntegerProperty year;
    private DoubleProperty weight;
    private IntegerProperty height;

    public GrassPredictions(int year, double weight) {
        this.year = new SimpleIntegerProperty(year);
        this.weight = new SimpleDoubleProperty(weight);
        //this.height = new SimpleIntegerProperty(height);
    }

    @Override
    public String toString() {
        return "GrassPredictions{" +
                "year=" + year +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }

    public int getYear() {
        return year.get();
    }

    public IntegerProperty yearProperty() {
        return year;
    }

    public double getWeight() {
        return weight.get();
    }

    public DoubleProperty weightProperty() {
        return weight;
    }

    public int getHeight() {
        return height.get();
    }

    public IntegerProperty heightProperty() {
        return height;
    }

}
