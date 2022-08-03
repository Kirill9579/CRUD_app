package web.model;

import java.util.Objects;

public class Car {

    private String model;
    private int modelYear;
    private int vinCode;

    public Car(String model, int modelYear, int vinCode) {
        this.model = model;
        this.modelYear = modelYear;
        this.vinCode = vinCode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public int getVinCode() {
        return vinCode;
    }

    public void setVinCode(int vinCode) {
        this.vinCode = vinCode;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", modelYear=" + modelYear +
                ", vinCode=" + vinCode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return modelYear == car.modelYear && vinCode == car.vinCode && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, modelYear, vinCode);
    }
}
