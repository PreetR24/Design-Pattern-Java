class CityControllers {
    private CityModel model;
    private CityView view;

    public CityControllers(CityModel cityModel, CityView cityView) {
        this.model = cityModel;
        this.view = cityView;
    }

    public void setCityName(String name) {
        model.setName(name);
    }

    public String getCityName() {
        return model.getName();
    }

    public void setCityCountry(String country) {
        model.setName(country);
    }

    public String getCityCountry() {
        return model.getName();
    }

    public void updateView() {
        view.printStudentDetails(model.getName(), model.getCountry());
    }

}

class CityView {
    public void printStudentDetails(String name, String country) {
        System.out.println("City");
        System.out.println("Name : " + name + "\nCountry : " + country);
    }
}

class CityModel {
    private String name, country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

public class cityMVC {
    public static void main(String[] args) {
        CityModel model = retriveCityFromDatabase();
        CityView view = new CityView();
        CityControllers controller = new CityControllers(model, view);

        controller.updateView();
        controller.setCityName("Washington DC");
        controller.updateView();
    }

    private static CityModel retriveCityFromDatabase() {
        CityModel city = new CityModel();
        city.setName("New York");
        city.setCountry("United States");
        return city;
    }
}