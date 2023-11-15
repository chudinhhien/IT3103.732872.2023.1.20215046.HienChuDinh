package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

//Chu Dinh Hien - 20215046
public class Store {
  public static final int MAX_NUMBERS_IN_STORE = 999;
  private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_IN_STORE];
  private int qtyInStore = 0; //Số lượng DVD trong kho  

  public void addDVD(DigitalVideoDisc disc) {
      if (qtyInStore < MAX_NUMBERS_IN_STORE) { // Kiểm tra số lượng đủ hay không
          itemsInStore[qtyInStore] = disc;
          qtyInStore++;
          System.out.println("Chu Dinh Hien - 20215046: Them thanh cong!");
      } else { //Nếu đã đầy
          System.out.println("Chu Dinh Hien - 20215046: Store da day khong them duoc!");
      }
  }

  public void removeDVD(DigitalVideoDisc disc) {
      for (int i = 0; i < qtyInStore; i++) {
          if (itemsInStore[i].equals(disc)) {
              //Gắn lại item từ vị trí bị xóa
              for (int j = i; j < qtyInStore - 1; j++) {
                  itemsInStore[j] = itemsInStore[j + 1];
              }
              qtyInStore--;
              System.out.println("Chu Dinh Hien - 20215046: Da xoa thanh cong!");
              return;
          }
      }
      System.out.println("Chu Dinh Hien - 20215046: DVD khong ton tai!");
  }

}
