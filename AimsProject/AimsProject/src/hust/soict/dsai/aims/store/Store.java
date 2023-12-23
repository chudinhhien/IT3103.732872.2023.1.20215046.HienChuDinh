package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

//Chu Dinh Hien - 20215046
public class Store {
  public static final int MAX_NUMBERS_IN_STORE = 999;
  private ArrayList<Media> itemInStore = new ArrayList<Media>(); 

  public void addMedia(Media media) {
      if (itemInStore.size() <= MAX_NUMBERS_IN_STORE) { // Kiểm tra số lượng đủ hay không
    	  //Thêm media vào Store
    	  itemInStore.add(media);
    	  //In ra thông báo
          System.out.println("Chu Dinh Hien - 20215046: Thêm thành công!");
      } else { //Nếu đã đầy
    	  //In ra thông báo
          System.out.println("Chu Dinh Hien - 20215046: Store đã đầy!");
      }
  }

  public void removeMedia(Media media) {
	  //Kiểm tra media có trong Store hay không
	  if(itemInStore.contains(media)) {//Nếu có
		  //Xóa media
		  itemInStore.remove(media);
		  //Thông báo
		  System.out.println("Chu Đình Hiển - 20215046: Đã xóa thành công!");
	  }else {//Nếu không
		  //Thông báo
		  System.out.println("Chu Đình Hiển - 20215046:" + media.getTitle() + " không tồn tại trong Store");
	  }
  }
  
  public Media findMediaByTitle(String title) {
      for (Media media : itemInStore) {
          if (media.getTitle().equalsIgnoreCase(title)) {
              return media;
          }
      }
      return null; // Media not found with the specified title
  }

  public ArrayList<Media> getItemInStore() {
		return itemInStore;
  }
}