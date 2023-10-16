package Lab01;
import javax.swing.JOptionPane;

public class ChoosingOption {
	public static void main(String[] args) {
		//Dialog xác nhận: Để bỏ lựa chọn Cancel ta thêm tham số JOptionPane.YES_NO_OPTION
		int option = JOptionPane.showConfirmDialog(null, "Do you(Chu Dinh Hien-20215046) want to change to the first class ticket",
		null, JOptionPane.YES_NO_OPTION);
		//Toán tử 3 ngôi để xác định xem ấn vào nút nào
		JOptionPane.showMessageDialog(null,"Chu Dinh Hien-20215046 have chosen: "+(option==JOptionPane.YES_OPTION?"Yes":"No"));
		System.exit(0);
	}
}
