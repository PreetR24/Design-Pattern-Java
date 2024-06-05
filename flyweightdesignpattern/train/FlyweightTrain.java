import java.util.HashMap;

interface Train {
    void drawTicket();
}

class Seat implements Train {
    private String carriage;
    private int seatno;

    public Seat(String carriage) {
        this.carriage = carriage;
    }

    public void seatno(int seatno) {
        this.seatno = seatno;
    }

    public void drawTicket() {
        System.out.println("Carriage :" + carriage + " [Seat No. : " + seatno + "]");
    }
}

class SeatFactory {
    private static final HashMap SeatMap = new HashMap();

    public static Train getSeat(String carriage) {
        Seat Seat = (Seat) SeatMap.get(carriage);

        if (Seat == null) {
            Seat = new Seat(carriage);
            SeatMap.put(carriage, Seat);
            System.out.println("Creating Seat of carriage : " + carriage);
        }
        return Seat;
    }
}

public class FlyweightTrain {
    private static final String carriages[] = { "1 AC", "2 AC", "3 AC", "Non Ac Sleeper", "Seater" };

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            Seat Seat = (Seat) SeatFactory.getSeat(getRandomCarriage());
            Seat.seatno(getRandomSeatno());
            Seat.drawTicket();
        }
    }

    private static String getRandomCarriage() {
        return carriages[(int) (Math.random() * carriages.length)];
    }

    private static int getRandomSeatno() {
        return (int) (Math.random() * 100);
    }
}