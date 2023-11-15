package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

//CHU DINH HIEN - 20215046
public class TestingPassingParameter {
	
	public static void main(String[] args) {
		//Khai báo jungleDVD tham chiếu đến object có title là Jungle
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		//Khai báo cinderellaDVD tham chiếu đến object có title là Cinderella
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

		//Gọi lại hàm swap
		swap(jungleDVD, cinderellaDVD);

		//Kiểm tra hàm swap bằng cách in lại title xem có đổi chỗ cho nhau chưa?
		System.out.println("CHU DINH HIEN -2021 test jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("CHU DINH HIEN -2021 test cinderella dvd title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}
	
	//Hàm swap ban đầu
	public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}
	
	//Hàm changeTitle của đề bài
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();//Lưu title của dvd
		dvd.setTitle(title);//set lại title của dvd bằng biến title truyền vào hàm
		//Gắn lại dvd vào tham chiếu mới với title là oldTitle
		dvd = new DigitalVideoDisc(oldTitle);
	}
}