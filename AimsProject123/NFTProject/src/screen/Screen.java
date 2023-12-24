package screen;

import java.io.IOException;

import javax.swing.JFrame;

//import hust.soict.dsai.aims.screen.CartScreenController;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import screen.layoutDefault.DefaultController;

public class Screen extends JFrame {

	public Screen() {
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);

		this.setTitle("NFT");
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("./layoutDefault/LayoutDefault.fxml"));
					DefaultController controller = new DefaultController();
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
	}

	public static void main(String[] args) {
		Screen screen = new Screen();
		screen.setSize(1440, 1024);
	}
}
