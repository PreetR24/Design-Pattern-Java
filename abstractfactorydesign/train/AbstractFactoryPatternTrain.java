import java.util.Scanner;

interface Train {
    public void select();
}

class AcRajdhani implements Train {
    public void select() {
        System.out.println("Selecting a Ac Rajdhani seat");
    }
}

class NonAcRajdhani implements Train {
    public void select() {
        System.out.println("Selecting a non Ac Rajdhani seat");
    }
}

class AcExpress implements Train {
    public void select() {
        System.out.println("Selecting a Ac Express seat");
    }
}

class NonAcExpress implements Train {
    public void select() {
        System.out.println("Selecting a non Ac Express seat");
    }
}

abstract class AbstractSeatTypeSelector {
    public abstract Train getPlace(String seat);
}

class RajdhaniSelector extends AbstractSeatTypeSelector {
    public Train getPlace(String seat) {
        if (seat.equalsIgnoreCase("Ac")) {
            return new AcRajdhani();
        } else if (seat.equalsIgnoreCase("Non-ac")) {
            return new NonAcRajdhani();
        } else {
            return null;
        }
    }
}

class ExpressSelector extends AbstractSeatTypeSelector {
    public Train getPlace(String seat) {
        if (seat.equalsIgnoreCase("Ac")) {
            return new AcExpress();
        } else if (seat.equalsIgnoreCase("Non-ac")) {
            return new NonAcExpress();
        } else {
            return null;
        }
    }
}

class SeatProducer {
    public AbstractSeatTypeSelector getSeat(String seattype) {
        if (seattype.equalsIgnoreCase("Rajdhani")) {
            return new RajdhaniSelector();
        } else if (seattype.equalsIgnoreCase("Express")) {
            return new ExpressSelector();
        } else {
            System.out.println("Enter a proper seat type");
            return null;
        }
    }
}

public class AbstractFactoryPatternTrain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the type of train (Express or Rajdhani): ");
        String trainType = sc.nextLine();

        SeatProducer sp = new SeatProducer();
        sp.getSeat(trainType);

        System.out.print("Which type of seat (Ac or Non-Ac): ");
        String seat = sc.nextLine();

        sp.getSeat(trainType).getPlace(seat).select();

        sc.close();
    }
}