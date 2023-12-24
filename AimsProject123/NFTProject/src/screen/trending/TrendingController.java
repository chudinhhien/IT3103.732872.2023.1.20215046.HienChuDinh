package screen.trending;

import java.sql.SQLException;
import java.time.LocalDate;

import app.BoxProcess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import model.Box;

public class TrendingController {
	@FXML
    private Label output;

    @FXML
    private DatePicker datePicker;
    
    private BoxProcess data;
    
    @FXML
    void findHotTag(ActionEvent event) throws ClassNotFoundException, SQLException {
    	LocalDate selectedDate = datePicker.getValue();

        int day = selectedDate.getDayOfMonth();
        int month = selectedDate.getMonthValue();
        int year = selectedDate.getYear();
        
        String s = "Hashtag hot nhất " + month + "/" + year + " là: " + data.findHotHashTagInTweets(day, month, year);
        output.setText(s);
    }
    
}
//cậu bảo chức năng 