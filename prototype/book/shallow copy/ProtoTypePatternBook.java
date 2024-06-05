import java.util.*;

class Book {
    int bid;
    String bname;

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String toString() {
        return "\nBook [bid=" + bid + ", bname=" + bname + "]";
    }
}

class BookShop implements Cloneable {
    String shopName;
    List<Book> books = new ArrayList<>();

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void loadData() {
        for (int i = 1; i <= 5; i++) {
            Book b = new Book();
            b.setBid(i);
            b.setBname("books:" + i);
            getBooks().add(b);
        }
    }

    public String toString() {
        return "BookShop [shopname=" + shopName + ",books=" + books + "]";
    }

    protected Object clone() throws CloneNotSupportedException {
        // BookShop shop = new BookShop();
        // for (Book b : this.getBooks()) {
        //     shop.getBooks().add(b);
        // }
        // return shop;
        return super.clone();
    }
}

public class ProtoTypePatternBook {
    public static void main(String[] args) throws CloneNotSupportedException {
        BookShop bs1 = new BookShop();
        
        bs1.loadData();
        bs1.setShopName("Shop 1");
        System.out.println(bs1);
        System.out.println();
        
        bs1.getBooks().remove(2);
        System.out.println(bs1);
        System.out.println();

        BookShop bs2 = (BookShop) bs1.clone();
        bs2.setShopName("Shop 2");
        System.out.println(bs2);
    }
}