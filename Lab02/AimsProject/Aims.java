//CHU ĐÌNH HIỂN - 20215046
public class Aims {
	public static void main(String[] args) {
		//Tạo một giỏ hàng mới
		Cart anOrder = new Cart();
		//Tạo đối tượng DVD mới và thêm chúng vào giỏ hàng
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation","Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc ("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc (dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc ("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc (dvd3);
		//Xóa DVD3
		anOrder.removeDigitalVideoDisc(dvd3);
		//Xóa DVD2
		anOrder.removeDigitalVideoDisc(dvd2);
		//Xóa DVD1
		anOrder.removeDigitalVideoDisc(dvd1);
		//Xóa DVD1
		anOrder.removeDigitalVideoDisc(dvd1);
		//In ra tổng số tiền của giỏ hàng
		System.out.println("Total Cost is: "); 
		System.out.println(anOrder.totalCost());
	}
}
