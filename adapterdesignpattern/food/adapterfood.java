interface Kitchen {
    public void prepare(String food, String foodflavor);
}

interface Food {
    public void prepareBurger(String foodflavor);
    public void preparePizza(String foodflavor);
}

class Burger implements Food {
    public void prepareBurger(String foodflavor) {
        System.out.println("Preparing Burger type: " + foodflavor);
    }

    public void preparePizza(String foodflavor) {
        // do nothing
    }
}

class Pizza implements Food {
    public void prepareBurger(String foodflavor) {
        // do nothing
    }

    public void preparePizza(String foodflavor) {
        System.out.println("Preparing Pizza type: " + foodflavor);
    }
}

class FoodManufacturer implements Kitchen {
    Food food;

    public FoodManufacturer(String type) {
        if (type.equalsIgnoreCase("burger")) {
            food = new Burger();
        } else if (type.equalsIgnoreCase("pizza")) {
            food = new Pizza();
        }
    }

    public void prepare(String type, String foodflavor) {
        if (type.equalsIgnoreCase("burger")) {
            food.prepareBurger(foodflavor);
        } else if (type.equalsIgnoreCase("pizza")) {
            food.preparePizza(foodflavor);
        }
    }
}

class DrinkManufacturer implements Kitchen {
    FoodManufacturer foodManufacturer;

    public void prepare(String food, String foodflavor) {
        if (food.equalsIgnoreCase("pepsi")) {
            System.out.println("Preparing pepsi: " + foodflavor);
        } else if (food.equalsIgnoreCase("burger") || food.equalsIgnoreCase("pizza")) {
            FoodManufacturer fmf = new FoodManufacturer(food);
            fmf.prepare(food, foodflavor);
        } else {
            System.out.println("Invalid food type. " + food );
        }
    }
}

public class adapterfood {
    public static void main(String[] args) {
        DrinkManufacturer dmf = new DrinkManufacturer();

        dmf.prepare("pepsi", "Cold");
        dmf.prepare("burger", "peri peri");
        dmf.prepare("pizza", "margherite");
        dmf.prepare("pasta", "macroni");
    }
}