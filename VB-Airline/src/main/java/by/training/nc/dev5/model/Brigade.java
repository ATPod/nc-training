package by.training.nc.dev5.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Created by Valery on 20.03.2017.
 */
public class Brigade implements Serializable {

    private List<String> pilots;
    private String navigator;
    private String radioman;
    private List<String> stewardesses;

    public List<String> getPilots() {
        return pilots;
    }

    public void setPilots(List<String> pilots) {
        this.pilots = pilots;
    }

    public String getNavigator() {
        return navigator;
    }

    public void setNavigator(String navigator) {
        this.navigator = navigator;
    }

    public String getRadioman() {
        return radioman;
    }

    public void setRadioman(String radioman) {
        this.radioman = radioman;
    }

    public List<String> getStewardesses() {
        return stewardesses;
    }

    public void setStewardesses(List<String> stewardesses) {
        this.stewardesses = stewardesses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brigade brigade = (Brigade) o;
        return Objects.equals(pilots, brigade.pilots) &&
                Objects.equals(navigator, brigade.navigator) &&
                Objects.equals(radioman, brigade.radioman) &&
                Objects.equals(stewardesses, brigade.stewardesses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pilots, navigator, radioman, stewardesses);
    }

    @Override
    public String toString() {
        return "Лётная бригада{" +
                "Пилоты=" + pilots.toString() +
                ", Штурман='" + navigator + '\'' +
                ", Радист='" + radioman + '\'' +
                ", Стюардессы=" + stewardesses.toString() +
                '}';
    }
}
