//CHU ĐÌNH HIỂN - 20215046
public class DigitalVideoDisc {
	//khai báo thuộc tính của lớp Digital Video Disc
	//CHU ĐÌNH HIỂN - 20215046
	private int id;//Thêm trường id 
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	//Thêm trường cập nhật id
	private static int nbDigitalVideoDiscs = 0;
	//Khới tạo các phương thức getter của title, category, director, length, cost
	//CHU ĐÌNH HIỂN - 20215046
	public String getTitle() {
		return title;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getDirector() {
		return director;
	}
	
	public int getLength() {
		return length;
	}
	
	public float getCost() {
		return cost;
	}
	
	//constructor cho title
	//CHU ĐÌNH HIỂN - 20215046
	public DigitalVideoDisc(String title) {
		super();
		//Cập nhật id cho mỗi DVD được thêm vào
		this.id = ++nbDigitalVideoDiscs;
		this.title = title;
	}
	//constructor cho title, category, cost
	//CHU ĐÌNH HIỂN - 20215046
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		//Cập nhật id cho mỗi DVD được thêm vào
		this.id = ++nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	//constructor cho title, category, director, cost
	//CHU ĐÌNH HIỂN - 20215046
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		//Cập nhật id cho mỗi DVD được thêm vào
		this.id = ++nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	//constructor cho tất cả thuộc tính
	//CHU ĐÌNH HIỂN - 20215046
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		//Cập nhật id cho mỗi DVD được thêm vào
		this.id = ++nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	
	//Setter Title
	//CHU DINH HIEN - 20215046
	public void setTitle(String title) {
		this.title = title;
	}

//	@Override
//	public String toString() {
//		return "DigitalVideoDisc [id=" + id + ", title=" + title + ", category=" + category + ", director=" + director
//				+ ", length=" + length + ", cost=" + cost + "]";
//	}
	
	
}
