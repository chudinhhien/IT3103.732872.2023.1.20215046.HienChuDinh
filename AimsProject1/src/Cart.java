//CHU ĐÌNH HIỂN - 20215046

import java.util.Arrays;

public class Cart {
	//Các thuộc tính của Cart
	public static final int MAX_NUMBERS_ORDERED = 20; // Số lượng tối đa DVD của giỏ hàng
	//Mảng để lưu DVD
	private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	//Số lượng DVD hiện tại của giỏ hàng 
	private int qtyOrdered;
	
	//Phương thức thêm DVD vào giỏ hàng
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered<MAX_NUMBERS_ORDERED) {//Kiểm tra xem giỏ hàng đã đầy chưa
			//Thêm thông tin DVD vào cuối mảng
			itemsOrdered[qtyOrdered] = disc;
			//Tăng số lượng DVD trong giỏ hàng
			qtyOrdered++;
			//In ra thông báo DVD được thêm thành công
			System.out.println("CHU DINH HIEN-20215046 da them thanh cong vao gio hang!");
		}else {//Nếu giỏ hàng đầy in ra thông báo
			System.out.println("CHU DINH HIEN-20215046 oi!\nGio hang cua ban da day!");
		}
	}
	
	//Thêm phương thức addDigitalVideoDisc với tham số là mảng DVD
		public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
			//Kiểm tra xem số lượng DVD trong dvdList thêm vào giỏ hàng hiện tại có vượt quá
			//số lượng giỏ hàng tối đa cho phép.
			if(qtyOrdered+dvdList.length<MAX_NUMBERS_ORDERED) {
				//Duyệt qua các phần tử cho mảng để thêm vào giỏ hàng
				for(DigitalVideoDisc disc: dvdList) {
					itemsOrdered[qtyOrdered] = disc;
					qtyOrdered++;
				}
				//In ra thông báo thêm vào giỏ hàng thành công
				System.out.println("CHU DINH HIEN-20215046 da them thanh cong danh sach DVD vao gio hang!");
			}else {
				//In ra thông báo quá số lượng tối đa cho phép của giỏ hàng
				System.out.println("CHU DINH HIEN-20215046 da them vuot qua so luong toi da gio hang cho phep!");
			}
		}
		
		//Thêm phương thức addDigitalVideoDisc với 2 tham số là dvd1, dvd2
		public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
			//Kiểm tra xem khi thêm 2 dvd có vượt quá số lượng cho phép không
			if(qtyOrdered+2<MAX_NUMBERS_ORDERED) {
				//Thêm 2 dvd vào giỏ hàng
				itemsOrdered[qtyOrdered] = dvd1;
				qtyOrdered++;
				itemsOrdered[qtyOrdered] = dvd2;
				qtyOrdered++;
				//In ra thông báo thêm thành công vào giỏ hàng
				System.out.println("CHU DINH HIEN-20215046 da them thanh cong 2 DVD !");
			}else {
				//In ra thông báo quá số lượng tối đa của giỏ hàng
				System.out.println("CHU DINH HIEN-20215046 da them 2 DVD vuot qua so luong cho phep cua gio hang!");
				
			}
		}
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}

	//Phương thức tìm kiếm DVD trong mảng đã lưu
	public int findDigitalVideoDisc(DigitalVideoDisc disc) {
		for(int i=0;i<qtyOrdered;i++) {//Duyệt mảng DVD
			if(disc==itemsOrdered[i]) return i;//Nếu tìm thấy trả về vị trí lưu mảng đó
		}
		return -1;//Nếu không tìm thấy trả về -1
	}
	//Phương thức xóa DVD
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered > 0) {//Kiểm tra xem trong giỏ hàng có DVD không
			int index = findDigitalVideoDisc(disc);//Tìm vị trí cần xóa trong giỏ hàng
			//Nêú không tìm thấy in ra thông báo không tìm thấy DVD
			if(index==-1) System.out.println("CHU DINH HIEN-20215046 oi!\nKhong tim thay DVD trong gio hang!");
			else {//Nếu tìm thấy
				itemsOrdered[index] = null;//Giải phóng bộ nhớ
				for(int i=index;i<qtyOrdered;i++) {//Dịch DVD lại vào phần trống
					itemsOrdered[i] = itemsOrdered[i+1]; 
				}
				//Cập nhật lại số lượng DVD
				qtyOrdered--;
				//In ra thông báo
				System.out.println("CHU DINH HIEN-20215046 da xoa thanh cong!");
			}
		}else System.out.println("Hien tai gio hang cua CHU DINH HIEN-20215046 chua co san pham nao!");
		//In ra thông báo nếu không có DVD trong giỏ
	}
	
	//Phương thức tính tổng giá giỏ hàng hiện tại
	public float totalCost() {
		float totalCurent = 0f;//Khởi tạo một biến để lưu tổng giá giỏ hàng
		for(int i=0;i<qtyOrdered;i++) {//Duyệt mảng để tính tổng
			totalCurent+=itemsOrdered[i].getCost();
		}
		//Trả về tổng giá
		return totalCurent;
	}

//	@Override
//	public String toString() {
//		return "Cart [itemsOrdered=" + Arrays.toString(itemsOrdered) + ", qtyOrdered=" + qtyOrdered + "]";
//	}
//	
	
	
}