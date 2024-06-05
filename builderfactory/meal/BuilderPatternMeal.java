import java.util.*;

// Packing
interface Packing {
    public String pack();
}

class Wrapper implements Packing {
    public String pack() {
        return "Wrapper";
    }
}

class Bottle implements Packing {
    public String pack() {
        return "Bottle";
    }
}

// Item type
interface Item {
    public String name();

    public Packing packing();

    public float price();
}

abstract class Burger implements Item {
    public Packing packing() {
        return new Wrapper();
    }

    public abstract float price();
}

abstract class ColdDrink implements Item {
    public Packing packing() {
        return new Bottle();
    }

    public abstract float price();
}

// Item name
class VegBurger extends Burger {
    public String name() {
        return "Veg Burger";
    }

    public float price() {
        return 30.0f;
    }
}

class ChickenBurger extends Burger {
    public String name() {
        return "Chicken Burger";
    }

    public float price() {
        return 40.0f;
    }
}

class Pepsi extends ColdDrink {
    public String name() {
        return "Pepsi";
    }

    public float price() {
        return 15.0f;
    }
}

class Coke extends ColdDrink {
    public String name() {
        return "Coke";
    }

    public float price() {
        return 10.0f;
    }
}

// Meal cart
class Meal {
    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0.0f;

        for (Item item : items) {
            cost += item.price();
        }

        return cost;
    }

    public void showItems() {
        System.out.println("\nTotal items are ");
        for (Item item : items) {
            System.out.print("Item : " + item.name() + " , ");
            System.out.print("  Packing : " + item.packing().pack() + " , ");
            System.out.println("  Price : " + item.price());
        }
    }
}

// producer
class MealBuilder extends Meal {
    Meal meal = new Meal();

    public Meal prepareVegMeal() {
        meal.addItem(new VegBurger());
        meal.addItem(new Pepsi());
        meal.showItems();
        System.out.println("\nTotal cost: " + meal.getCost());
        return meal;
    }

    public Meal prepareNonVegMeal() {
        meal.addItem(new ChickenBurger());
        meal.addItem(new Coke());
        meal.showItems();
        System.out.println("\nTotal cost: " + meal.getCost());
        return meal;
    }
}

public class BuilderPatternMeal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MealBuilder mb = new MealBuilder();

        System.out.print("Enter the type of Meal (Veg or Non-veg): ");
        String mealType = sc.nextLine();

        if (mealType.equalsIgnoreCase("veg")) {
            mb.prepareVegMeal();
        } else if (mealType.equalsIgnoreCase("non-veg")) {
            mb.prepareNonVegMeal();
        } else {
            System.out.println("Invalid Input");
        }

        sc.close();
    }
}