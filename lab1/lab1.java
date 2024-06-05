class Residency {
    String location;
    int number;
    double areaInYard;
    double pricePerYard;

    static int residencyCount = 0;

    // Default constructor
    public Residency() {
        residencyCount++;
    }

    // Perameterized constructor
    public Residency(String location, int number, double areaInYard, double pricePerYard) {
        this.location = location;
        this.number = number;
        this.areaInYard = areaInYard;
        this.pricePerYard = pricePerYard;
        residencyCount++;
    }

    // getter and setter
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getAreaInYard() {
        return areaInYard;
    }

    public void setAreaInYard(double areaInYard) {
        this.areaInYard = areaInYard;
    }

    public double getPricePerYard() {
        return pricePerYard;
    }

    public void setPricePerYard(double pricePerYard) {
        this.pricePerYard = pricePerYard;
    }

    // calculate the price of Residency
    public double calculatePriceOfResidency() {
        return areaInYard * pricePerYard;
    }

    // To print residency information
    public void printResidencyInfo() {
        System.out.println("Location: " + location);
        System.out.println("Number: " + number);
        System.out.println("Area in Yard: " + areaInYard);
        System.out.println("Price per Yard: " + pricePerYard);
        System.out.println("Total Price: " + calculatePriceOfResidency());

    }

    // static method for total count
    public static int getTotalCount() {
        return residencyCount;
    }
}

class FurnishedResidency extends Residency {
    double furnitureCharge;

    // default constructor
    public FurnishedResidency() {
        super();
        int furnitureCharge = 0;
    }

    // perameterized constructor
    public FurnishedResidency(String location, int number, double areaInYard, double pricePerYard,
            double furnitureCharge) {
        super(location, number, areaInYard, pricePerYard);
        this.furnitureCharge = furnitureCharge;
    }

    // calculate the price of residency
    public double calculatePriceOfResidency() {
        return super.calculatePriceOfResidency() + furnitureCharge;
    }

    public void printResidencyInfo() {
        super.printResidencyInfo();
        System.out.println("Furniture Charge: $" + furnitureCharge);
    }
}

class NonFurnishedResidency extends Residency {
    // default constructor
    public NonFurnishedResidency() {
        super();
    }

    // parameterized constructor
    public NonFurnishedResidency(String location, int number, double areaInYard, double pricePerYard) {
        super(location, number, areaInYard, pricePerYard);
    }

    public double calculatePriceOfResidency() {

        // Calculate the total price and add 2% stamp duty
        double totalPrice = super.calculatePriceOfResidency();
        double stampDuty = 0.02 * totalPrice;
        return totalPrice + stampDuty;
    }

    public void printResidencyInfo() {
        super.printResidencyInfo();
        System.out.println("Stamp Duty (2%): $" + (0.02 * super.calculatePriceOfResidency()));
    }

}

public class lab1 {
    public static void main(String[] args) {
        Residency residency1 = new FurnishedResidency("Surendranagar", 10, 6900, 200, 800);
        Residency residency2 = new NonFurnishedResidency("Rajkot", 20, 7000, 1200);

        System.out.println("Residency 1 Information:");
        residency1.printResidencyInfo();

        System.out.println("\nResidency 2 Information:");
        residency2.printResidencyInfo();

        System.out.println("\nTotal Residency Count: " + Residency.getTotalCount());
    }
}