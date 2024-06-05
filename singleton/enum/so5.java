enum user {
    INSTANCE;

    user() {
        System.out.println("\nCreating an Object.....");
    }

    public void details() {
        System.out.println("username : #vanshika05\nid : 10241\npassword : 1234\n");
    }
}

public class so5 {
    public static void main(String[] args) {
        user u1 = user.INSTANCE;
        u1.details();

        user u2 = user.INSTANCE;
        u2.details();
    }
}
