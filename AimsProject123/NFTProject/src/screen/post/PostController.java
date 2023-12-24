package screen.post;

import java.awt.Desktop;
import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import app.BoxProcess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Articles;
import model.BlogPosts;
import model.Box;
import model.Tweets;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;

public class PostController {

	@FXML
	private TextField inputSearch;

	@FXML
	private HBox contentSearch;

	private	BoxProcess data;

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
		HBox.setHgrow(contentSearch, Priority.ALWAYS);
		contentSearch.setSpacing(80);
		if (inputSearch.getText().charAt(0) == '#') {
			System.out.println("OK");
			List<Tweets> list = data.hashtagSearchingFunction(inputSearch.getText());
			for(Tweets x : list) {
				System.out.println(x.getId());
			}
			contentSearch.getChildren().clear();
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

				Label like = new Label(list.get(i).getNoOfLike() + " Likes");
				Label comment = new Label(list.get(i).getNoOfLike() + " Comment");
				FontAwesomeIcon likeIcon = new FontAwesomeIcon();
				likeIcon.setGlyphName("THUMBS_UP");
				like.setGraphic(likeIcon);
				FontAwesomeIcon commentIcon = new FontAwesomeIcon();
				commentIcon.setGlyphName("COMMENT");
				comment.setGraphic(commentIcon);
				innerSocial.getChildren().addAll(like, comment);
				innerSocial.getStyleClass().add("innerSocial");
				comment.getStyleClass().add("commentLabel");

				Button btnLink = new Button("Xem bài viết");
				icon.setGlyphName("ARROW_RIGHT");
				btnLink.setGraphic(icon);
				HBox hBtn = new HBox(btnLink);
				icon.getStyleClass().add("iconBtn");
				innerBtn.getChildren().add(hBtn);
				innerBtn.setAlignment(Pos.CENTER);
				hBtn.setAlignment(Pos.CENTER);
				innerBtn.getStyleClass().add("innerBtn");
				vbox.getChildren().addAll(image, content, innerSocial, innerDate, innerAuthor, innerBtn);
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
		} else {
			contentSearch.getChildren().clear();
			List<BlogPosts> list = data.tagSearchingFunction(inputSearch.getText());
			//Lỗi ở đây vì tớ có cái in ra để kiểm tra dữ liệu 
			for (BlogPosts blog : list) {
				System.out.println(blog.getContent());
			}
			for (int i = 0; i < list.size(); i++) {
				VBox item = new VBox();
				Label image = new Label();
				HBox innerTitle = new HBox();
				HBox innerDate = new HBox();
				HBox innerContent = new HBox();
				HBox innerAuthor = new HBox();
				HBox innerBtn = new HBox();
				BlogPosts blog = list.get(i);
				item.getStyleClass().add("blogPost");
				image.getStyleClass().add("imagePost");
				innerTitle.getStyleClass().add("innerTitlePost");
				innerDate.getStyleClass().add("innerDatePost");
				innerContent.getStyleClass().add("innerContentPost");
				innerAuthor.getStyleClass().add("innerAuthorPost");
				innerAuthor.setAlignment(Pos.CENTER_RIGHT);
				innerBtn.getStyleClass().add("innerBtnPost");

				Label title = new Label(blog.getTitle());
				title.getStyleClass().add("title");
				Label date = new Label(blog.getTimestamp().toString());
				date.getStyleClass().add("date");
				Label content = new Label(blog.getContent());
				content.getStyleClass().add("contentPost");
				Label author = new Label(blog.getAuthor());
				author.getStyleClass().add("author");
				Button btnLink = new Button("Xem bài viết");
				btnLink.getStyleClass().add("btnLink");

				innerTitle.getChildren().add(title);
				innerDate.getChildren().add(date);
				innerContent.getChildren().add(content);
				innerAuthor.getChildren().add(author);
				innerBtn.getChildren().add(btnLink);
				item.getChildren().addAll(image, innerTitle, innerDate, innerContent, innerAuthor, innerBtn);
				contentSearch.getChildren().add(item);
				
				if (i == 0) {
					HBox.setMargin(item, new Insets(0, 0, 0, 80));
				}
				if (i == list.size() - 1) {
					HBox.setMargin(item, new Insets(0, 80, 0, 0));
				}
				btnLink.setOnAction(ActionEvent -> {
					try {
						Desktop.getDesktop().browse(new URI(blog.getLink()));
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
			}
		}
	}

}
// Li vo dan