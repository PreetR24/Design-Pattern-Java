interface Food {
    void prepare();
}

class Burger implements Food {
    public void prepare() {
        System.out.println("Food: Regular Burger");
    }
}

class Pizza implements Food {
    public void prepare() {
        System.out.println("Food: Regular Pizza");
    }
}

abstract class FoodDecorator implements Food {
    protected Food decoratedFood;

    public FoodDecorator(Food decoratedFood) {
        this.decoratedFood = decoratedFood;
    }

    public void prepare() {
        decoratedFood.prepare();
    }
}

class PeriPeriFood extends FoodDecorator {
    public PeriPeriFood(Food decoratedFood) {
        super(decoratedFood);
    }

    public void prepare() {
        decoratedFood.prepare();
        getPeriPeri();
    }

    private void getPeriPeri() {
        System.out.println("Flavor: Peri Peri");
    }
}

class CheesyFood extends FoodDecorator {
    public CheesyFood(Food decoratedFood) {
        super(decoratedFood);
    }

    public void prepare() {
        decoratedFood.prepare();
        getDoubleCheese(decoratedFood);
    }

    private void getDoubleCheese(Food decoratedFood) {
        System.out.println("Flavor: Double Cheese");
    }
}

public class DecoratorFood {
    public static void main(String[] args) {

        Food Pizza = new Pizza();
        System.out.println("Pizza with normal flavor");
        Pizza.prepare();
        
        Food PeriPeriPizza = new PeriPeriFood(new Pizza());
        System.out.println("\nPizza with peri peri toping");
        PeriPeriPizza.prepare();
        
        Food CheeseBurger = new CheesyFood(new Burger());
        System.out.println("\nBurger with cheese toping");
        CheeseBurger.prepare();
    }
}