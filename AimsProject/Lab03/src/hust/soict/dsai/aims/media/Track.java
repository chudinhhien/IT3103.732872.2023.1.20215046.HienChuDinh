//CHU ĐÌNH HIỂN - 20215046
package hust.soict.dsai.aims.media;

//Tạo class Track
public class Track implements Playable {
	//Thuộc tính
	private String title;
	private int length;
	
	//Contructor
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

	//Getter
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	//Chu Đình Hiển - 20215046
	@Override
	public void play() {
		// TODO Auto-generated method stub
		//In thông tin Track
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}
	
}
