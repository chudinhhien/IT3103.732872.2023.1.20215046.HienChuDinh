//CHU ĐÌNH HIỂN - 20215046
package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	//Thêm trường cập nhật id
	private static int nbDigitalVideoDiscs = 0;
	
	//constructor cho tất cả thuộc tính kế thừa từ Disc
	//CHU ĐÌNH HIỂN - 20215046
	public DigitalVideoDisc(String title, String category,String director,int length,float cost) {
		super(title, category, cost, length, director);
		//Tự động tăng ID
		super.setId(++nbDigitalVideoDiscs);
		// TODO Auto-generated constructor stub
	}
	
	//Chu Dinh Hien - 20215046
	//toString() theo đúng cấu trúc đề bài
	@Override
	public String toString() {
		return	super.getId() + ". DVD - [" + super.getTitle() + "] - [" + super.getCategory() + 
				"] - ["+ super.getDirector() + "] - [" + super.getLength() + "]: [" + super.getCost() + "] $";
	}
	
	//Chu Dinh Hien - 20215046
	//Phương thức isMatch để kiểm tra xem có trùng với title đang tìm không
	public boolean isMatch(String title) {
		return super.getTitle() == title;
	}

	//Chu Đình Hiển - 20215046
	@Override
	public void play() {
		// TODO Auto-generated method stub
		//In thông tin DVD đang play
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

}
