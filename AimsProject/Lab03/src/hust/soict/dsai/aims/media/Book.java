//CHU DINH HIEN - 20215046
package hust.soict.dsai.aims.media;

//Import Package array list
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {//Kế thừa từ class Media
	private static int nbBook = 0;
	private List<String> authors = new ArrayList<String>();
	
	
	//Tạo constructor cho Book
	public Book(String title, String category, float cost,String author) {
		//Kế thừa lại constructor từ class Media
		super(title, category, cost);
		//Kế thừa setId để tự động tăng Id cho Book
		super.setId(++nbBook);
		addAuthor(author);
		// TODO Auto-generated constructor stub
	}
	
	//Phương thức thêm tác giả
	public void addAuthor(String authorName) {
		//Duyệt các phần tử trong array list
		for(String x : authors) {
			if(x.equals(authorName)) {//Nếu tồn tại tên tác giả muốn thêm trong danh sách
				//In ra thông báo tác giả đã tồn tại trong danh sách
				System.out.println("CHU DINH HIEN - 20215046: Tac gia da ton tai! Vui long nhap lai ten tac gia!");
				//Thoát khỏi hàm
				return;
			}
		}
		//Nếu tác giả thêm không tồn tại trong danh sách thì thêm vào
		authors.add(authorName);
		//In ra thông báo thêm thành công
		System.out.println("CHU DINH HIEN - 20215046: Da them thanh cong tac gia!");
	}
	
	

	//Phương thức xóa tác giả
	public void removeAuthor(String authorName) {
		//Duyệt các phần tử trong array list 
		for(String x : authors) {
			//Nếu tác giả tồn tại trong danh sách
			if(x.equals(authorName)) {
				//Xóa tác giả trong danh sách
				authors.remove(authorName);
				//In ra thông báo xóa thành công
				System.out.println("CHU DINH HIEN - 20215046: Da xoa thanh cong tac gia!");
				return;
			}
		}
		//Nếu không tìm thấy tác giả để xóa in ra thông báo không tìm thấy tác giả
		System.out.println("Khong tim thay ten tac gia!");
	}

	@Override
	public String toString() {
		String authorList = "";
		for(String x : authors) {
			authorList=authorList+x+"\n";
		}
		return "********Book********\n" +
			   "ID: " + super.getId() + "\n" +
			   "Title: " + super.getTitle() + "\n" +
			   "Category: " + super.getCategory() + "\n" +
			   "Cost: " + super.getCost() + "$\n" +
			   "Authors:\n" + authorList;
	}
}
