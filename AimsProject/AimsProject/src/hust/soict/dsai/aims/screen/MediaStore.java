package hust.soict.dsai.aims.screen;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel {
	private Media media;
	private JFrame home;
	private Cart cart; 
	public MediaStore(Media media,JFrame home, Cart cart) {
		
		this.media = media;
		this.home = home;
		this.cart = cart;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getCost()+" $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton btnAddCart = new JButton("Add to cart");
		
		container.add(btnAddCart);
		btnAddCart.addActionListener(new BtnAddCart(this.cart,this.media));
		if(media instanceof Playable) {
			JButton playButton = new JButton("Play ");
			container.add(playButton);
			playButton.addActionListener(new PlayMedia(this.home,media.getTitle()));
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	private class PlayMedia implements ActionListener {
	    private JFrame p;
	    private String title;

	    PlayMedia(JFrame p, String title) {
	        this.p = p;
	        this.title = title;
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        JDialog d = new JDialog(p, "Play");

	        // Tạo một JPanel cho nội dung của JDialog
	        JPanel dialogPanel = new JPanel();
	        dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.Y_AXIS));

	        JLabel titleLabel = new JLabel(this.title);
	        JLabel playingLabel = new JLabel("Playing...");

	        // Căn giữa theo chiều ngang
	        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	        playingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	        
	        // Thêm khoảng trắng giữa các nhãn
	        dialogPanel.add(Box.createVerticalStrut(50)); // Có thể điều chỉnh chiều cao của khoảng trắng

	        // Thêm các nhãn vào JPanel
	        dialogPanel.add(titleLabel);
	        dialogPanel.add(playingLabel);

	        // Thêm khoảng trắng giữa các nhãn
	        dialogPanel.add(Box.createVerticalStrut(10)); // Có thể điều chỉnh chiều cao của khoảng trắng

	        // Đặt JPanel vào JDialog
	        d.add(dialogPanel);

	        // Đặt vị trí của JDialog ở giữa box cha (home JFrame)
	        d.setLocationRelativeTo(p);

	        d.setSize(200, 200);
	        d.setVisible(true);
	    }
	}
	
	private class BtnAddCart implements ActionListener {
		private Cart cart;
		private Media media;
		public BtnAddCart(Cart cart,Media media) {
			this.cart = cart;
			this.media = media;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cart.addMedia(media);
			System.out.println("Thêm thành công " + media.getTitle());
		}
	}
}
