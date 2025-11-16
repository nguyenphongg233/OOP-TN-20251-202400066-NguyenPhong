
import test.CartTest;
import test.StoreTest;
import test.BookTest;
import test.CompactDiscTest;

public class Aims {
    public static void main(String[] args) {

        CompactDiscTest compactDiscTest = new CompactDiscTest();
        compactDiscTest.main(args);
        CartTest cartTest = new CartTest();
        cartTest.main(args);
        
        StoreTest storeTest = new StoreTest();
        storeTest.main(args);

        // Cart cart = new Cart();

        // DigitalVideoDisc dvd1 = new DigitalVideoDisc("Animation", "The Lion King", 19.95);
        // DigitalVideoDisc dvd2 = new DigitalVideoDisc("Science Fiction", "Star Wars", 24.95);

        // cart.addDVD(dvd1);
        // cart.addDVD(dvd2);

        // cart.print();
    }
}

// To compile and run the program, use the following commands:
// javac -d bin src\Aims.java src\models\*.java
// java -cp bin Aims