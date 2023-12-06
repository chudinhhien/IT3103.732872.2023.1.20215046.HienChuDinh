package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

//Chu Dinh Hien - 20215046
public class Store {
  public static final int MAX_NUMBERS_IN_STORE = 999;
  private ArrayList<Media> itemsInStore = new ArrayList<Media>(); 

  public void addMedia(Media media) {
      if (itemsInStore.size() <= MAX_NUMBERS_IN_STORE) { // Kiểm tra số lượng đủ hay không
    	  //Thêm media vào Store
    	  itemsInStore.add(media);
    	  //In ra thông báo
          System.out.println("Chu Dinh Hien - 20215046: Thêm thành công!");
      } else { //Nếu đã đầy
    	  //In ra thông báo
          System.out.println("Chu Dinh Hien - 20215046: Store đã đầy!");
      }
  }

  public void removeMedia(Media media) {
	  //Kiểm tra media có trong Store hay không
	  if(itemsInStore.contains(media)) {//Nếu có
		  //Xóa media
		  itemsInStore.remove(media);
		  //Thông báo
		  System.out.println("Chu Đình Hiển - 20215046: Đã xóa thành công!");
	  }else {//Nếu không
		  //Thông báo
		  System.out.println("Chu Đình Hiển - 20215046:" + media.getTitle() + " không tồn tại trong Store");
	  }
  }
  
  public Media findMediaByTitle(String title) {
      for (Media media : itemsInStore) {
          if (media.getTitle().equalsIgnoreCase(title)) {
              return media;
          }
      }
      return null; // Media not found with the specified title
  }
}
