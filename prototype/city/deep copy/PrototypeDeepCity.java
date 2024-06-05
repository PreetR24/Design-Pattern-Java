import java.util.*;

class City {
    int Citypin;
    String Cityname;

    public int getCitypin() {
        return Citypin;
    }

    public void setCitypin(int Citypin) {
        this.Citypin = Citypin;
    }

    public String getCityname() {
        return Cityname;
    }

    public void setCityname(String Cityname) {
        this.Cityname = Cityname;
    }

    public String toString() {
        return "\nCity [Citypin = " + Citypin + ", Cityname = " + Cityname + "]";
    }
}

class State implements Cloneable {
    String StateName;
    List<City> City = new ArrayList<>();

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String StateName) {
        this.StateName = StateName;
    }

    public List<City> getCity() {
        return City;
    }

    public void setCity(List<City> City) {
        this.City = City;
    }

    public void loadData() {
        for (int i = 1; i <= 5; i++) {
            City c = new City();
            c.setCitypin(i);
            c.setCityname("City:" + i);
            getCity().add(c);
        }
    }

    public String toString() {
        return "State [State Name = " + StateName + ",City = " + City + "]";
    }

    protected State clone() throws CloneNotSupportedException {
        State state = new State();
        for (City c : this.getCity()) {
            state.getCity().add(c);
        }
        return state;
    }
}

public class PrototypeDeepCity {
    public static void main(String[] args) throws CloneNotSupportedException {
        State s1 = new State();

        s1.loadData();
        s1.setStateName("State A");
        System.out.println(s1);
        System.out.println();
        
        State s2 = (State) s1.clone();
        s2.setStateName("State B");

        s1.getCity().remove(2);
        System.out.println(s1);
        System.out.println();
        System.out.println(s2);
    }
}