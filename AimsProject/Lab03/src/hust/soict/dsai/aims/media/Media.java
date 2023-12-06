//Chu Đình Hiển - 20215046
package hust.soict.dsai.aims.media;

//Tạo class trừu tượng Media
public abstract class Media {
	//Các thuộc tính của Media
	private int id;
	private String title;
	private String category;
	private float cost;
	
	//Constructor của Media
	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
		
	public Media(String title) {
		super();
		this.title = title;
	}
	
	//Chu Đình Hiển - 20215046
	//Getter và Setter của Media
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	
}
