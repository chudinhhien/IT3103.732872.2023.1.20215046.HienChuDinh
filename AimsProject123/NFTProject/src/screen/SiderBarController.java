package screen;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

public class SiderBarController {
	
	boolean status = true;

    @FXML
    private AnchorPane siderBar;

    @FXML
    private FontAwesomeIcon handleBar;
    
    @FXML
    private BorderPane main;
    
    @FXML
    void toggleSiderBar(MouseEvent event) {
    	status = !status;
    	TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.01), siderBar);
    	if(status) {
    		translateTransition.setToX(-100); // Đặt vị trí mới theo trục X
    		translateTransition.play();
    	} else {
    		translateTransition.setToX(0); // Đặt vị trí mới theo trục X
    		translateTransition.play();
    	}
    		

    }

}
