package hust.soict.dsai.aims.cart;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	//Các thuộc tính của Cart
	public static final int MAX_NUMBERS_ORDERED = 20; // Số lượng tối đa DVD của giỏ hàng
	private ArrayList<Media> itemOrdered = new ArrayList<Media>();
	
	//Phương thức thêm Media
	public void addMedia(Media media) {
		if(itemOrdered.size()<MAX_NUMBERS_ORDERED) {
			itemOrdered.add(media);
			System.out.println("Chu Đình Hiển - 20215046: Đã thêm thành công!");
		}else {
			System.out.println("Chu Đình Hiển - 20215046: Giỏ hàng đã đầy!");
		}
	}
	
	//Phương thức xóa Media
	public void removeMedia(Media media) {
		if(itemOrdered.contains(media)) {
			itemOrdered.remove(media);
			System.out.println("Chu Đình Hiển - 20215046: Đã xóa thành công!");
		}
	}
	
	//Phương thức tính tổng giá giỏ hàng hiện tại
	public float totalCost() {
		float totalCurrent = 0.0f;//Khởi tạo một biến để lưu tổng giá giỏ hàng
		for(Media x : itemOrdered) {
			totalCurrent+=x.getCost();
		}
		//Trả về tổng giá
		return totalCurrent;
	}
	
	
	//Phương thức tìm kiếm DVD trong mảng đã lưu
	public int findDigitalVideoDisc(DigitalVideoDisc disc) {
		for(int i=0;i<qtyOrdered;i++) {//Duyệt mảng DVD
			if(disc==itemsOrdered[i]) return i;//Nếu tìm thấy trả về vị trí lưu mảng đó
		}
		return -1;//Nếu không tìm thấy trả về -1
	}
	

	//CHU DINH HIEN - 20215046
	//Phương thức print cho Cart theo đúng định dạng của đề bài
	public void print() {
		//In tiêu đề
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		//Vòng for lấy các item trong giỏ hàng
		for(int i = 0 ; i< qtyOrdered ;i++) {
			//In ra item bằng toString()
			System.out.println(itemsOrdered[i]);
		}
		//In ra tổng giá tiền của giỏ hàng
		System.out.println("Total cost: [" + totalCost() + "]" );
	}
	
	//Tìm kiếm theo ID
	public void searchByID(int id) {
		for(int i = 0 ; i< qtyOrdered ;i++) {
			if(itemsOrdered[i].getId() == id) {//Nếu tìm thấy ID thì in ra và return vì chỉ có 1 ID duy nhất
				System.out.println(itemsOrdered[i]);
				return;
			}
		}
		//In ra thông báo không tìm thấy
		System.out.println("Khong tim thay ID trong gio hang cua CHU DINH HIEN - 20215046");
	}
	
	//Tìm kiếm theo title
	public void searchByTitle(String title) {
		int check = 0;
		for(int i = 0 ; i< qtyOrdered ;i++) {
			//Nếu tìm thấy title in ra
			if(itemsOrdered[i].isMatch(title)) {
				System.out.println(itemsOrdered[i]);
				//Đánh dấu tìm thấy
				check = 1;
			}
		}
		//Nếu chưa được đánh dấu tìm thấy in ra thông báo
		if(check == 0) System.out.println("Khong tim thay tieu de trong gio hang cua CHU DINH HIEN - 20215046");
	}
}
