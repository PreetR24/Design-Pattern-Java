import java.util.Scanner;

interface Train {
    void getTicket();
}

class Rajdhani implements Train {
    public void getTicket() {
        System.out.println("Rajdhani Ticket");
    }
}

class Express implements Train {
    public void getTicket() {
        System.out.println("Express Ticket");
    }

}

class Local implements Train {
    public void getTicket() {
        System.out.println("Local Ticket");
    }

}

class TicketMaker {
    private Train Rajdhani;
    private Train Express;
    private Train Local;

    public TicketMaker() {
        Rajdhani = new Rajdhani();
        Express = new Express();
        Local = new Local();
    }

    public void getRajdhaniTicket() {
        Rajdhani.getTicket();
    }

    public void getExpressTicket() {
        Express.getTicket();
    }

    public void getLocalTicket() {
        Local.getTicket();
    }
}

public class facadeTrain {
    public static void main(String[] args) {
        TicketMaker ticketMaker = new TicketMaker();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ticket you want:");
        String ticket = sc.nextLine();

        if (ticket.equalsIgnoreCase("Rajdhani")) {
            ticketMaker.getRajdhaniTicket();
        } else if (ticket.equalsIgnoreCase("Express")) {
            ticketMaker.getExpressTicket();
        } else if (ticket.equalsIgnoreCase("Local")) {
            ticketMaker.getLocalTicket();
        }
        sc.close();
    }
}

