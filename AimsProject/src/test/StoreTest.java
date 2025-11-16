
package test;

import models.DigitalVideoDisc;
import models.Store;
import models.Cart;

public class StoreTest {

    public static void main(String[] args) {
        // Tạo kho hàng
        Store store = new Store();

        // Tạo một vài DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        
        // --- Kịch bản 1: Thêm DVD vào kho ---
        System.out.println("--- Direction 1: Add DVD ---");
        store.addDVD(dvd1);
        store.addDVD(dvd2);

        // --- Kịch bản 2: Xóa DVD khỏi kho ---
        System.out.println("--- Direction 2: Remove DVD ---");
        store.removeDVD(dvd1);
        
        // --- Kịch bản 3: Xóa DVD không có trong kho ---
        System.out.println("--- Direction 3: Remove non-existent DVD ---");
        store.removeDVD(dvd1); // Thử xóa lại dvd1
    }
}