package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame {
	private Store store;
	private Cart cart;
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update store");
		smUpdateStore.add(new JMenuItem("Add Book"));
		smUpdateStore.add(new JMenuItem("Add CD"));
		smUpdateStore.add(new JMenuItem("Add DVD"));
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		menu.add(new JMenuItem("View cart"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS-HienCD-20215046");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton cart = new JButton("View cart");
		cart.addActionListener(new BtnViewCart(this.cart));
		cart.setPreferredSize(new Dimension(100, 50));
		cart.setMaximumSize(new Dimension(100, 50));
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemInStore();
		for(int i = 0 ; i < 9; i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i),this,this.cart);
			center.add(cell);
		}
		
		return center;
	}
	
	public StoreScreen(Store store,Cart cart) {
		this.store = store;
		this.cart = cart;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024 ,768);
	}
	
	public static void main(String[] args) {
		Store store = new Store();
		Cart cart = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("DVD1's Title","category1",76.0F);
		Book book2 = new Book("Book2's Title","category2",61.0F);
		CompactDisc cd3 = new CompactDisc("CD3's Title","category3",59.0F);
		CompactDisc cd4 = new CompactDisc("CD4's Title", "category4",38.0F);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("DVD5's Title","category5", 43.0F);
		CompactDisc cd6 = new CompactDisc("CD6's Title","category6",95.0F);
		Book book7 = new Book("Book7's Title","category7",24.0F);
		Book book8 = new Book("Book8's Title","category8",78.0F);
		CompactDisc cd9 = new CompactDisc("CD9's Title","category9",95.0F);
		store.addMedia(dvd1);
		store.addMedia(book2);
		store.addMedia(cd3);
		store.addMedia(cd4);
		store.addMedia(dvd5);
		store.addMedia(cd6);
		store.addMedia(book7);
		store.addMedia(book8);
		store.addMedia(cd9);
		new StoreScreen(store,cart);
	}
	
	private class BtnViewCart implements ActionListener {
		private Cart cart;
		public BtnViewCart(Cart cart) {
			this.cart = cart;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for(Media m : cart.getItemsOrdered()) {
				System.out.println(m.getTitle());
			}
		}
		
	}
}
