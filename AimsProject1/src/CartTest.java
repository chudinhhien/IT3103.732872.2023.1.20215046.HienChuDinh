//CHU DINH HIEN - 20215046
public class CartTest {
	public static void main(String[] args) {
		//Create a new cart
		Cart cart = new Cart();
		//Create new dvd objects and add them to the cart 
		DigitalVideoDisc dvd1 = new DigitalVideoDisc ("The Lion King", "Animation", "Roger Allers", 87, 19.95f); 
		cart.addDigitalVideoDisc (dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc ("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc ("Aladin", "Animation", 18.99f);
		cart.addDigitalVideoDisc(dvd3);
		//Test the print method cart.print();
		cart.print();
		//To-do: Test the search methods here
		//Test Search by ID
		cart.searchByID(1);//Trường hợp tìm thấy ID
		cart.searchByID(4);//Trường hợp không tìm thấy ID
		//Test Search by Title
		cart.searchByTitle("Aladin");//Trường hợp tìm thấy title
		cart.searchByTitle("chudinhien");//Trường hợp không tìm thấy title
	}
}
