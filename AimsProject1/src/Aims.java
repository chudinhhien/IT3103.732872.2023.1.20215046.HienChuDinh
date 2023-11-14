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
		//Tạo list DVD thêm vào giỏ hàng
		DigitalVideoDisc dvd4 = new DigitalVideoDisc ("Test1", "Test Title 01", 10.99f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc ("Test2", "Test Title 02", 9.99f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc ("Test3", "Test Title 03", 18.99f);
		DigitalVideoDisc[] listDVD = new DigitalVideoDisc[3];
		listDVD[0] = dvd4;
		listDVD[1] = dvd5;
		listDVD[2] = dvd6;
		//Phương thức thêm danh sách DVD
//		anOrder.addDigitalVideoDisc(listDVD);
		//Phương thức thêm 2 DVD
		anOrder.addDigitalVideoDisc(dvd4,dvd5);
	}
}