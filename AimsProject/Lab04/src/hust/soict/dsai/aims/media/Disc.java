//Chu Đình Hiển - 20215046
package hust.soict.dsai.aims.media;

public class Disc extends Media {
	//Thuộc tính length và director
	private int length;
	private String director;
	private static int nbDisc = 0;
	
	//Contructor 
	public Disc(String title, String category, float cost, int length, String director) {
		//Kế thừa từ Media
		super(title, category, cost);
		//Tự động tăng Id
		super.setId(++nbDisc);
		this.length = length;
		this.director = director;
	}

	//Getter của Disc
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
}
