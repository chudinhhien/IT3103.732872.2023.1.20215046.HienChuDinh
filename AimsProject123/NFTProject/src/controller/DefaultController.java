package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class DefaultController {

    @FXML
    private HBox btnTrend;

    @FXML
    private BorderPane featureScreen;

    @FXML
    private HBox btnPost;

    @FXML
    private HBox btnCorrelation;
    
    @FXML
    private BorderPane rootPane;

//    @FXML
//    void 718096(ActionEvent event) {
//
//    }
//
//    @FXML
//    void 718096(ActionEvent event) {
//
//    }
//
//    @FXML
//    void 718096(ActionEvent event) {

    //}

    void changeCSSBtnActive(HBox btn) {
    	btn.setStyle("-fx-background-color: #1DA1F2;-fx-background-radius: 100");
        btn.getChildren().forEach(node -> {
        	if(node instanceof HBox) {
        		node.setStyle("-fx-background-color: #ffffffff;-fx-border-radius: 50%;-fx-background-radius: 50%");
        	}else if(node instanceof Label){
        		node.setStyle("-fx-text-fill: #ffffffff;-fx-font-size: 18;-fx-font-weight: bolder");
        	}
        });
    }
    
    void changeCSSBtnNoActive(HBox btn) {
    	btn.setStyle("-fx-background-color: #EDF2F7;-fx-background-radius: 100");
        btn.getChildren().forEach(node -> {
        	if(node instanceof HBox) {
        		node.setStyle("-fx-background-color:  #1DA1F2;-fx-border-radius: 50%;-fx-background-radius: 50%");
        	}else if(node instanceof Label){
        		node.setStyle("-fx-text-fill: BLACK;-fx-font-size: 18;-fx-font-weight: bolder");
        	}
        });
    }
    
    @FXML
    void clickTrend(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource(".././view/NFTTrend.fxml"));
        Node newContent = loader.load();
        TrendingController controller = new TrendingController();
        loader.setController(controller);
        rootPane.setCenter(newContent);
        changeCSSBtnActive(btnTrend);
        changeCSSBtnNoActive(btnPost);
        changeCSSBtnNoActive(btnCorrelation);
    }	

    @FXML
    void clickPost(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource(".././view/LayoutPost.fxml"));
        Node newContent = loader.load();
        PostController controller = new PostController();
        loader.setController(controller);
        Scene scene = rootPane.getScene();
        scene.getStylesheets().add(getClass().getResource(".././css/post/style.css").toExternalForm());
        rootPane.setCenter(newContent);
        changeCSSBtnNoActive(btnTrend);
        changeCSSBtnActive(btnPost);
        changeCSSBtnNoActive(btnCorrelation);
    }	

    @FXML
    void clickCorrelation(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource(".././view/Correlation.fxml"));
        Node newContent = loader.load();
        CorrelationController controller = new CorrelationController();
        loader.setController(controller);
        rootPane.setCenter(newContent);
        changeCSSBtnNoActive(btnTrend);
        changeCSSBtnNoActive(btnPost);
        changeCSSBtnActive(btnCorrelation);
    }
}

