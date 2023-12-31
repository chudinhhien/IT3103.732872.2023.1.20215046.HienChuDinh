//CHU ĐÌNH HIỂN - 20215046
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
	
}
