class user {
    static user u1;

    public static user getInstance() {
        if (u1 == null) {
            synchronized (user.class) {
                if (u1 == null) {
                    u1 = new user();
                    System.out.println("\nCreating an Object.....");
                }
            }
        } else {
            System.out.println("\nCopying an Object.....");
        }
        return u1;
    }

    public void details() {
        System.out.println("username : #vanshika05\nid : 10241\npassword : 1234\n");
    }
}

public class so4 {
    public static void main(String[] args) {
        Thread t1 = new Thread(
                new Runnable() {
                    public void run() {
                        user u1 = user.getInstance();
                        u1.details();
                    }
                });

        Thread t2 = new Thread(
                new Runnable() {
                    public void run() {
                        user u1 = user.getInstance();
                        u1.details();
                    }
                });

        t1.start();
        t2.start();
    }
}
