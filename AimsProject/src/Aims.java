import models.Cart;
import models.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {

        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 
                                                    "Roger Allers", 87, 19.95);
        
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 
                                                    "George Lucas", 87, 24.95);

        cart.addDVD(dvd1);
        cart.addDVD(dvd2);

        cart.print();
        
        cart.calculateTotalCost();

        cart.removeDVD(dvd2);

        cart.print();
        cart.calculateTotalCost();
    }
}

// To compile and run the program, use the following commands:
// javac -d bin src\Aims.java src\models\*.java
// java -cp bin Aims