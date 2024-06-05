import java.util.Scanner;

interface train {
    public void select();
}

class AcRajdhani implements train {
    public void select() {
        System.out.println("Selecting AC Rajdhani");
    }
}

class NonAcRajdhani implements train {
    public void select() {
        System.out.println("Selecting Non AC Rajdhani");
    }
}

class AcExpress implements train {
    public void select() {
        System.out.println("Selecting AC Express");
    }
}

class NonAcExpress implements train {
    public void select() {
        System.out.println("Selecting Non AC Rajdhani");
    }
}

abstract class traintype {
    public abstract train type(String type);
}

class Rajdhani extends traintype{
    public train type(String type){
        if(type.equalsIgnoreCase("Ac")){
            return new AcRajdhani();
        }
        else if (type.equalsIgnoreCase("non-ac")){
            return new NonAcRajdhani();
        }
        else{
            return null;
        }
    }
} 

class Express extends traintype{
    public train type(String type){
        if(type.equalsIgnoreCase("Ac")){
            return new AcExpress();
        }
        else if (type.equalsIgnoreCase("non-ac")){
            return new NonAcExpress();
        }
        else{
            return null;
        }
    }
} 

class ticket{
    public traintype trainName(String name){
        if(name.equalsIgnoreCase("Rajdhani")){
            return new Rajdhani();
        }
        else if (name.equalsIgnoreCase("express")){
            return new Express();
        }
        else{
            return null;
        }
    }
}

public class Aft {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ticket t = new ticket();

        System.out.println("Enter Train:");
        String trainName = sc.nextLine();
        t.trainName(trainName);

        System.out.println("Enter type:");
        String traintype = sc.nextLine();
        t.trainName(trainName).type(traintype).select();

        sc.close();
    }
}