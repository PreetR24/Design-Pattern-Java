import java.util.*;

// Packing
interface Packing {
    public String pack();
}

class PlasticBag implements Packing {
    public String pack() {
        return "Plastic Bag";
    }
}

class Fold implements Packing {
    public String pack() {
        return "Fold";
    }
}

// Item type
interface Item {
    public String name();
    public Packing packing();
    public float price();
}

abstract class Shirt implements Item {
    public Packing packing() {
        return new PlasticBag();
    }

    public abstract float price();
}

abstract class Jeans implements Item {
    public Packing packing() {
        return new Fold();
    }

    public abstract float price();
}

// Item name
class CottonShirt extends Shirt {
    public String name() {
        return "Cotton Shirt";
    }

    public float price() {
        return 1000.0f;
    }
}

class LinenShirt extends Shirt {
    public String name() {
        return "Linen Shirt";
    }

    public float price() {
        return 800.0f;
    }
}

class CottonJeans extends Jeans {
    public String name() {
        return "Cotton Jeans";
    }

    public float price() {
        return 1500.0f;
    }
}

class LinenJeans extends Jeans {
    public String name() {
        return "Linen Jeans";
    }

    public float price() {
        return 1400.0f;
    }
}

// Cloth cart
class Cloth {
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
            System.out.print("Packing : " + item.packing().pack() + " , ");
            System.out.println("Price : " + item.price());
        }
    }
}

// producer
class ClothBuilder extends Cloth {
    Cloth cloth = new Cloth();

    public Cloth prepareCottonPair() {
        cloth.addItem(new CottonShirt());
        cloth.addItem(new CottonJeans());
        cloth.showItems();
        System.out.println("\nTotal cost: " + cloth.getCost());
        return cloth;
    }

    public Cloth prepareLinenPair() {
        cloth.addItem(new LinenJeans());
        cloth.addItem(new LinenShirt());
        cloth.showItems();
        System.out.println("\nTotal cost: " + cloth.getCost());
        return cloth;
    }

}

public class BuilderPatternCloth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ClothBuilder cb = new ClothBuilder();

        System.out.print("Enter the type of Cloth Pair (Cotton or Linen): ");
        String clothType = sc.nextLine();

        if (clothType.equalsIgnoreCase("Cotton")) {
            cb.prepareCottonPair();
        } else if (clothType.equalsIgnoreCase("Linen")) {
            cb.prepareLinenPair();
        } else {
            System.out.println("Invalid Input");
        }

        sc.close();
    }
}