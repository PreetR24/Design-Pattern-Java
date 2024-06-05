class user {
    static user u1;

    public user getInstance() {
        if (u1 == null) {
            u1 = new user();
            System.out.println("\nCreating an Object.....");
        } else {
            System.out.println("\nCopying an Object.....");
        }
        return u1;
    }

    public void details() {
        System.out.println("username : #preet19\nid : 10241\npassword : 1234\n");
    }
}

public class so2 {
    public static void main(String[] args) {
        user u = new user().getInstance();
        u.details();

        user u1 = new user().getInstance();
        u1.details();
    }
}