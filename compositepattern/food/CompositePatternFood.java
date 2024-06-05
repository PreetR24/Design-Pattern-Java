import java.util.*;

class Food {
    private String name;
    private int cost;
    private List<Food> food;

    // constructor
    public Food(String name, int cost) {
        this.name = name;
        this.cost = cost;
        food = new ArrayList<Food>();
    }

    public Food(String name) {
        this.name = name;
        food = new ArrayList<Food>();
    }

    public void add(Food e) {
        food.add(e);
    }

    public void remove(Food e) {
        food.remove(e);
    }

    public List<Food> getfood() {
        return food;
    }

    public String toString() {
        return ("Food : [ Name : " + name + ", cost :" + cost + " ]");
    }
}

public class CompositePatternFood {
    public static void main(String[] args) {

        Food Eat = new Food("Eat");
        Food Drink = new Food("Drink");
        
        Food Burger = new Food("Burger",50);
        Food CheeseBurger = new Food("CheeseBurger",80);
        Food PeriPeriBurger = new Food("Peri Peri Burger",60);
        
        Food Pizza = new Food("Pizza",120);
        Food ItalianPizza = new Food("Italian Pizza",150);
        Food MargheritaPizza = new Food("Margherita Pizza",160);
        
        Food HotWater = new Food("Hot Water",5);
        Food Tea = new Food("Tea",20);
        Food Beverage = new Food("Beverage",50);

        Food ColdDrink = new Food("Cold Drink",20);
        Food HotCoffee = new Food("Hot Coffee",30);
        Food MilkShake = new Food("Milk Shake",80);

        Eat.add(Burger);
        Eat.add(Pizza);

        Burger.add(CheeseBurger);
        Burger.add(PeriPeriBurger);

        Pizza.add(ItalianPizza);
        Pizza.add(MargheritaPizza);

        Drink.add(HotWater);
        Drink.add(ColdDrink);

        HotWater.add(Tea);
        HotWater.add(HotCoffee);

        ColdDrink.add(Beverage);
        ColdDrink.add(MilkShake);

        // print all Foods of the Menu
        System.out.println(Eat);
        System.out.println();
        for (Food Item : Eat.getfood()) {
            System.out.println(Item);
            
            for (Food item2 : Item.getfood()) {
                System.out.println(item2);
            }
            System.out.println();
        }
        
        System.out.println(Drink);
        System.out.println();
        for (Food Item : Drink.getfood()) {
            System.out.println(Item);
            
            for (Food item2 : Item.getfood()) {
                System.out.println(item2);
            }
            System.out.println();
        }
    }
}