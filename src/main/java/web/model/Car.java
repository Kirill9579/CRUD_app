package web.model;

import javax.persistence.*;
import java.util.Objects;
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "model", nullable = false)
    private String model;
    @Column(name = "model_year", nullable = false)
    private int modelYear;
    @Column(name = "vin_code", nullable = false)
    private int vinCode;

    public Car() {
    }

    public Car(String model, int modelYear, int vinCode) {
        this.model = model;
        this.modelYear = modelYear;
        this.vinCode = vinCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", model='" + model + '\'' +
                ", modelYear=" + modelYear +
                ", vinCode=" + vinCode +
                '}';
    }
}
