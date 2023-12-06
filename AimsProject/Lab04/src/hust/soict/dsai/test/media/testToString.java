package hust.soict.dsai.test.media;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Book;

public class testToString {
	public static void main(String[] args) {
		List<Media> mediae = new ArrayList<Media>();
		CompactDisc cd = new CompactDisc("Test CD", "CD", 4.56F, "Chu Đình Hiên", "Chu Đình Hiển");
		DigitalVideoDisc dvd = new DigitalVideoDisc("Test DVD", "DVD", "CDH-20215046", 10, 10.0F);
		Book book = new Book("Test Book", "Book", 13.4F, "Hiển");
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);
		for(Media m:mediae) {
			System.out.println(m.toString());
		}
	}
}
