import java.util.ArrayList;
import java.util.List;

interface cityobserver {
    public void update(String cityname, float temperature);
}

class ObserverCity {
    private List<cityobserver> observer = new ArrayList<>();
    String cityName;
    float temp;

    public ObserverCity(String name) {
        this.cityName = name;
    }

    void registerStation(cityobserver o) {
        observer.add(o);
    }

    void removeStation(cityobserver o) {
        observer.remove(o);
    }

    void notifySations() {
        this.observer.forEach((cityobserver o) -> o.update(this.cityName, this.temp));
    }

    public void setTemp(float t) {
        this.temp = t;
        notifySations();
    }
}

class weatherstation implements cityobserver {
    String StationName;

    public weatherstation(String name) {
        this.StationName = name;
    }

    public void update(String cityname, float temp) {
        System.out.println(StationName + " reported: City " + cityname + "'s temperature is " + temp);
    }
}

public class CityObs {
    public static void main(String[] args) {
        ObserverCity City1 = new ObserverCity("Mumbai");
        ObserverCity City2 = new ObserverCity("Delhi");
        weatherstation ws1 = new weatherstation("Station 1");
        weatherstation ws2 = new weatherstation("Station 2");
        City1.registerStation(ws1);
        City1.registerStation(ws2);
        City2.registerStation(ws1);

        City1.setTemp(24);
        City2.setTemp(30);
    }
}