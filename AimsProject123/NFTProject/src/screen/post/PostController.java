package screen.post;

import java.awt.Desktop;
import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import app.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import model.Tweets;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;

public class PostController {

	@FXML
	private TextField inputSearch;

	@FXML
	private HBox contentSearch;

	private App app;

//    @FXML
//    void 718096(ActionEvent event) {
//
//    }
//
//    @FXML
//    void 718096(ActionEvent event) {
//
//    }

	@FXML
	void pressedSearch(ActionEvent event) throws ClassNotFoundException, SQLException {
		System.out.println(inputSearch.getText());
		List<Tweets> list = app.hashtagSearchingFunction(inputSearch.getText());
		HBox.setHgrow(contentSearch, Priority.ALWAYS);
		contentSearch.setSpacing(80);
		for (int i = 0; i < list.size(); i++) {
			final int index = i;
			VBox vbox = new VBox();
			vbox.getStyleClass().add("tweet");
			
			Label image = new Label();
			image.getStyleClass().add("image");
			
			FontAwesomeIcon icon = new FontAwesomeIcon();
			HBox innerAuthor = new HBox();
			HBox innerBtn = new HBox();
			HBox innerDate = new HBox();
			HBox innerSocial = new HBox();
			
			Label nd = new Label(list.get(i).getContent());
			nd.getStyleClass().add("nd");
			VBox content = new VBox();
			content.getStyleClass().add("content");
			
			Label date = new Label(list.get(i).getTimestamp().toString());
			innerDate.getChildren().add(date);
			innerDate.getStyleClass().add("innerDate");
			innerDate.setAlignment(Pos.CENTER_RIGHT);
			
			Label author = new Label(list.get(i).getAuthor());
			author.getStyleClass().add("author");
			innerAuthor.getChildren().add(author);
			innerAuthor.getStyleClass().add("innerAuthor");
			innerAuthor.setAlignment(Pos.CENTER_RIGHT);
			
			Button btnLink = new Button("Xem bài viết");
			icon.setGlyphName("ARROW_RIGHT");
			btnLink.setGraphic(icon);
			HBox hBtn = new HBox(btnLink);
			icon.getStyleClass().add("iconBtn");
			innerBtn.getChildren().add(hBtn);
			innerBtn.setAlignment(Pos.CENTER);
			hBtn.setAlignment(Pos.CENTER);
			innerBtn.getStyleClass().add("innerBtn");
			vbox.getChildren().addAll(image, content,innerDate,innerAuthor,innerBtn);
			btnLink.getStyleClass().add("btnLink");
			
			content.getChildren().addAll(nd);
			contentSearch.getChildren().add(vbox);
			if (i == 0) {
				HBox.setMargin(vbox, new Insets(0, 0, 0, 80));
			}
			if (i == list.size() - 1) {
				HBox.setMargin(vbox, new Insets(0, 80, 0, 0));
			}
			btnLink.setOnAction(ActionEvent -> {
	            try {
	                Desktop.getDesktop().browse(new URI(list.get(index).getLink()));
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        });
		}
	}

}
// Li vo dan