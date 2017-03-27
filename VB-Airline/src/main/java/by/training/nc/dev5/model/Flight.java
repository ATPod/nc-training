package by.training.nc.dev5.model;

import by.training.nc.dev5.exception.InputDataException;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Valery on 20.03.2017.
 */
public class Flight implements Serializable {

    private int number;
    private Brigade brigade;
    private String timeDispatch = "10 00, 15 Марта 2017";
    private String status;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) throws InputDataException {
        if(number < 0){
            throw new InputDataException("Номер рейса не может быть отричательным!");
        }
        this.number = number;
    }

    public Brigade getBrigade() {
        return brigade;
    }

    public void setBrigade(Brigade brigade) {
        this.brigade = brigade;
    }

    public String getTimeDispatch() {
        return timeDispatch;
    }

    public void setTimeDispatch(String timeDispatch) {
        this.timeDispatch = timeDispatch;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return number == flight.number &&
                Objects.equals(brigade, flight.brigade) &&
                Objects.equals(timeDispatch, flight.timeDispatch) &&
                Objects.equals(status, flight.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, brigade, timeDispatch, status);
    }

    @Override
    public String toString() {
        return "Рейс{" +
                "Номер=" + number +
                ", Лётная бригада=" + brigade.toString() +
                ", Время отправления='" + timeDispatch + '\'' +
                ", Статус='" + status + '\'' +
                '}';
    }
}
