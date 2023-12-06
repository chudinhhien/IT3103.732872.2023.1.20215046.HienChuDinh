package hust.soict.dsai.test.book;

import hust.soict.dsai.aims.media.Book;

public class BookTest {
	public static void main(String[] args) {
		Book book1 = new Book("Sach Test 1","Test",15.3f,"Chu Dinh Hien");
		Book book2 = new Book("Sach Test 2","Test",15.3f,"Chu Dinh Hien - 2021");
		book1.addAuthor("Nguyen Duc Phu");
		book1.addAuthor("Nguyen Duc Phu");
		book1.addAuthor("Nguyen Trong Khanh Duy");
		System.out.println(book1);
		book1.removeAuthor("Nguyen Duc Phu");
		System.out.println(book1);
		book1.removeAuthor("Nguyen Duc Phu");
		System.out.println(book1);
		System.out.println(book2);
	}
}
