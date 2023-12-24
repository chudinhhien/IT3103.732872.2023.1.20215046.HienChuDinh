package screen.correlation;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import app.BoxProcess;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import model.ResultData;

public class CorrelationController<Y, X> implements Initializable {
	 @FXML
	 private LineChart<?, ?> chartLine;
	 
	 private BoxProcess data;

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			ResultData resultData = data.searchNFTsAndReturnData("dogecoin", Date.valueOf("2023-07-30"));
			List<Date> dateChart = resultData.getX();
			List<Float> costChart = resultData.getY();
			XYChart.Series series1 = new XYChart.Series();
			for(int i = 0 ; i < dateChart.size(); i++) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		        String dateString = dateFormat.format(dateChart.get(i));
				series1.getData().add(new XYChart.Data(dateString, costChart.get(i)));

			}
			chartLine.getXAxis().setLabel("Date");
			chartLine.getYAxis().setLabel("Cost");
			chartLine.getData().addAll(series1);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	 
}
