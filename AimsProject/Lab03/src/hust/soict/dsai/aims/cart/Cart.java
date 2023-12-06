package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	//Các thuộc tính của Cart
	public static final int MAX_NUMBERS_ORDERED = 20; // Số lượng tối đa DVD của giỏ hàng
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	//Phương thức thêm Media
	public void addMedia(Media media) {
		if(itemsOrdered.size()<=MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
			System.out.println("Chu Đình Hiển - 20215046: Đã thêm thành công!");
		}else {
			System.out.println("Chu Đình Hiển - 20215046: Giỏ hàng đã đầy!");
		}
	}
	
	//Phương thức xóa Media
	public void removeMedia(Media media) {
		if(itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println("Chu Đình Hiển - 20215046: Đã xóa thành công!");
		}
	}
	
	//Phương thức tính tổng giá giỏ hàng hiện tại
	public float totalCost() {
		float totalCurrent = 0.0f;//Khởi tạo một biến để lưu tổng giá giỏ hàng
		for(Media x : itemsOrdered) {
			totalCurrent+=x.getCost();
		}
		//Trả về tổng giá
		return totalCurrent;
	}
	
	
	//Phương thức tìm kiếm DVD trong mảng đã lưu
//	public int findDigitalVideoDisc(DigitalVideoDisc disc) {
//		for(int i=0;i<qtyOrdered;i++) {//Duyệt mảng DVD
//			if(disc==itemsOrdered[i]) return i;//Nếu tìm thấy trả về vị trí lưu mảng đó
//		}
//		return -1;//Nếu không tìm thấy trả về -1
//	}
	

	//CHU DINH HIEN - 20215046
	//Phương thức print cho Cart theo đúng định dạng của đề bài
//	public void print() {
//		//In tiêu đề
//		System.out.println("***********************CART***********************");
//		System.out.println("Ordered Items:");
//		//Vòng for lấy các item trong giỏ hàng
//		for(int i = 0 ; i< qtyOrdered ;i++) {
//			//In ra item bằng toString()
//			System.out.println(itemsOrdered[i]);
//		}
//		//In ra tổng giá tiền của giỏ hàng
//		System.out.println("Total cost: [" + totalCost() + "]" );
//	}
	
	public void sortMedia(Comparator<Media> comparator) {
        itemsOrdered.sort(comparator);
    }
    
    public void filterById(int id) {
        List<Media> filteredMedias = itemsOrdered.stream()
                .filter(media -> media.getId() == id)
                .collect(Collectors.toList());

        displayFilteredMedias(filteredMedias);
    }

    public void filterByTitle(String title) {
        List<Media> filteredMedias = itemsOrdered.stream()
                .filter(media -> media.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());

        displayFilteredMedias(filteredMedias);
    }

    private void displayFilteredMedias(List<Media> filteredMedias) {
        if (filteredMedias.isEmpty()) {
            System.out.println("No matching media found in the cart.");
        } else {
            System.out.println("Matching media(s) in the cart:");
            for (Media media : filteredMedias) {
                System.out.println(media);
            }
        }
    }
    
    public Media findMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null; // Media not found with the specified title
    }
    
    public void placeOrder() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty. Cannot place an order.");
        } else {
            System.out.println("Order placed successfully!");
            itemsOrdered.clear(); // Clear the cart after placing the order
        }
    }
}
