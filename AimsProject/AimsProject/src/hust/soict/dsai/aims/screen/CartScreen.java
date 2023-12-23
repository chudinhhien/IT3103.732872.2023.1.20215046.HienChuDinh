package hust.soict.dsai.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {
	private Cart cart;
	
	public CartScreen(Cart cart) {
		super();
		
		this.cart = cart;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("./cart.fxml"));
					CartScreenController controller = new CartScreenController(cart);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(String[] argv) {
		Cart cart = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("DVD1's Title","Category1",76.0F);
		Book book2 = new Book("Book2's Title","Category2",61.0F);
		CompactDisc cd3 = new CompactDisc("CD3's Title","Category3",59.0F);
		cart.addMedia(dvd1);
		cart.addMedia(book2);
		cart.addMedia(cd3);
		for(Media x : cart.getItemsOrdered()) {
			System.out.println(x.getTitle());
		}
		CartScreen cartScreen = new CartScreen(cart);
	    cartScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    cartScreen.setSize(1024, 768);
	    cartScreen.setLocationRelativeTo(null); // Đặt JFrame ở giữa màn hình
	    cartScreen.setVisible(true);
	}
}
