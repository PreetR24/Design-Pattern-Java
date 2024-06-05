class user {
    private static user u1 = new user();

    public user getInstance() {
        return u1;
    }

    public void details() {
        System.out.println("username : #preet19\nid : 10241\npassword : 1234\n");
    }
}

public class so1 {
    public static void main(String[] args) {
        user u = new user().getInstance();
        u.details();
    }
}