package models;

public class Store {
    // Tạm thời gán kích thước mảng là 100
    public static final int MAX_ITEMS_IN_STORE = 100;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
    private int itemCount = 0; // Biến đếm số lượng DVD thực tế đang có

    public void addDVD(DigitalVideoDisc dvd) {
        if (itemCount >= MAX_ITEMS_IN_STORE) {
            System.out.println("Store is full. Cannot add more DVDs.");
        } else {
            itemsInStore[itemCount] = dvd;
            itemCount++;
            System.out.println("Added DVD '" + dvd.getTitle() + "' to the store.");
        }
    }

    /**
     * Phương thức xóa DVD khỏi kho (tìm theo đối tượng)
     */
    public void removeDVD(DigitalVideoDisc dvd) {
        int foundIndex = -1;
        // Tìm vị trí của DVD cần xóa
        for (int i = 0; i < itemCount; i++) {
            if (itemsInStore[i] == dvd) { // So sánh tham chiếu
                foundIndex = i;
                break;
            }
        }

        if (foundIndex == -1) {
            System.out.println("Error: DVD '" + dvd.getTitle() + "' not found in the store.");
        } else {
            // Ghi đè bằng cách dịch chuyển các phần tử phía sau lên
            for (int i = foundIndex; i < itemCount - 1; i++) {
                itemsInStore[i] = itemsInStore[i + 1];
            }
            // Gán phần tử cuối cùng là null và giảm biến đếm
            itemsInStore[itemCount - 1] = null;
            itemCount--;
            System.out.println("Removed DVD '" + dvd.getTitle() + "' from the store.");
        }
    }

    // (Bạn cũng có thể thêm một phương thức printStore() để in ra các DVD 
    // đang có trong kho, tương tự như Cart.print())
}
