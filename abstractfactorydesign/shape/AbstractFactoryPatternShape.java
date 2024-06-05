import java.util.Scanner;

interface Shape {
    public void draw();
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing a simple rectangle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing a simple Square");
    }
}

class RoundedRectangle implements Shape {
    public void draw() {
        System.out.println("Drawing a rounded rectangle");
    }
}

class RoundedSquare implements Shape {
    public void draw() {
        System.out.println("Drawing a rounded square");
    }
}

abstract class AbstractFactory {
    public abstract Shape getShape(String shape);
}

class ShapeFactory extends AbstractFactory {
    public Shape getShape(String shape) {
        if (shape.equalsIgnoreCase("Rectangle")) {
            return new Rectangle();
        } else if (shape.equalsIgnoreCase("Square")) {
            return new Square();
        } else {
            return null;
        }
    }
}

class RoundedShapeFactory extends AbstractFactory {
    public Shape getShape(String shape) {
        if (shape.equalsIgnoreCase("Rectangle")) {
            return new RoundedRectangle();
        } else if (shape.equalsIgnoreCase("Square")) {
            return new RoundedSquare();
        } else {
            return null;
        }
    }
}

class FactoryProducer {
    public AbstractFactory getFactory(String shapetype) {
        if (shapetype.equalsIgnoreCase("Rounded")) {
            return new RoundedShapeFactory();
        } else if (shapetype.equalsIgnoreCase("Simple")) {
            return new ShapeFactory();
        } else {
            System.out.println("Enter a proper shape type");
            return null;
        }
    }
}

public class AbstractFactoryPatternShape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the type of shape (Rounded or Simple): ");
        String shapeType = sc.nextLine();

        FactoryProducer fp = new FactoryProducer();
        fp.getFactory(shapeType);

        System.out.print("Enter the shape (Square or Rectangle): ");
        String shape = sc.nextLine();

        fp.getFactory(shapeType).getShape(shape).draw();

        sc.close();
    }
}