//Write a program to calculate sum, difference, product, and quotient of 2 double numbers which are entered by users.
import javax.swing.JOptionPane;

public class CalculateDouble {

    public static void main(String[] args){
        String strNum1, strNum2;  //Khai báo xâu để lưu
        String strNotification = "Chu Dinh Hien - 20215046"; //Thông báo ra màn hình tổng hiệu tích

        strNum1 = JOptionPane.showInputDialog(null,"Chu Dinh Hien - 20215046-Please input the first number: ",
        "Chu Dinh Hien - 20215046-Input the first number",JOptionPane.INFORMATION_MESSAGE);//Nhập xâu strNum1

        strNum2 = JOptionPane.showInputDialog(null,"Chu Dinh Hien - 20215046-Please input the second number: ",
        "Chu Dinh Hien - 20215046 - Input the second number",JOptionPane.INFORMATION_MESSAGE);//Nhập xâu strNum2

        double num1 = Double.parseDouble(strNum1); //chuyển xâu sang số thực
        double num2 = Double.parseDouble(strNum2);//chuyển xâu sang số thực

        //Thực hiện tính toán
        double sum = num1+num2;
        double difference = num1-num2;
        double product = num1*num2;
        double quotient = num1/num2;

        //Show Kết quả ra màn hình 
        JOptionPane.showMessageDialog(null,"Sum:"+sum+"\n"+
                                                            "Diffrence:"+difference+"\n"+
                                                            "Product:"+product+"\n"+
                                                            "Quotient:"+quotient+"\n",
        "Chu Dinh Hien - 20215046 Show:",JOptionPane.INFORMATION_MESSAGE);
    }
}