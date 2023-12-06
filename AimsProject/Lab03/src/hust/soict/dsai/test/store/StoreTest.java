package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {

    public static void main(String[] args) {

        // Chu Dinh Hien - 20215046: Tạo 1 store
        Store store = new Store();

        // Chu Dinh Hien - 20215046: Thêm DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addDVD(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geogre Lucas", 87, 24.95f);
        store.addDVD(dvd2);

        // Chu Dinh Hien - 20215046: Xóa DVD
        store.removeDVD(dvd1); // Phu 20215116: can remove

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", null, 0, 18.99f);
        store.removeDVD(dvd3); //Chu Dinh Hien - 20215046: Xóa DVD không có trong store
    }
}
