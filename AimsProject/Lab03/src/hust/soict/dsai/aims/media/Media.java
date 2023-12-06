//Chu Đình Hiển - 20215046
package hust.soict.dsai.aims.media;

import java.util.Comparator;

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
	
	//Chu Đình Hiển - 20215046
	@Override
	public boolean equals(Object o) {
		//Kiểm tra o có phải là instance của Media hay không
		if(!(o instanceof Media)) {
			return false;
		}
		//ép kiểu: DownCasting
		Media media = (Media) o;
		//So sánh theo tiêu chí title
		return this.title.equals(o);
	}
	
	public static class MediaComparatorByCostTitle implements Comparator<Media>{
		@Override
        public int compare(Media media1, Media media2) {
            // Compare by cost in descending order
            int costComparison = Float.compare(media2.getCost(), media1.getCost());
            if (costComparison == 0) {
                // If costs are the same, compare by title
                return media1.getTitle().compareToIgnoreCase(media2.getTitle());
            }
            return costComparison;
        }
	}
	
	public static class MediaComparatorByTitleCost implements Comparator<Media> {
        @Override
        public int compare(Media media1, Media media2) {
            int titleComparison = media1.getTitle().compareToIgnoreCase(media2.getTitle());
            if (titleComparison == 0) {
                // If titles are the same, compare by cost in descending order
                return Float.compare(media2.getCost(), media1.getCost());
            }
            return titleComparison;
        }
    }
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
}
