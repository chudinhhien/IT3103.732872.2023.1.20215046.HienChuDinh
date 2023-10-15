//Example 5: ShowTwoNumbers.java
import javax.swing.JOptionPane;
//Nhap vao 2 so va Hien ra hai so vua nhap
public class ShowTwoNumbers {
    public static void main(String[] args){
        String strNum1, strNum2;
        String strNotification = "Chu Dinh Hien - 20215046-You've just entered: ";

        strNum1 = JOptionPane.showInputDialog(null,"Chu Dinh Hien - 20215046-Please input the first number: ",
        "Chu Dinh Hien - 20215046-Input the first number",JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum1 + " and ";

        strNum2 = JOptionPane.showInputDialog(null,"Chu Dinh Hien - 20215046-Please input the second number: ",
        "Chu Dinh Hien - 20215046 - Input the second number",JOptionPane.INFORMATION_MESSAGE);

        strNotification+=strNum2;
        JOptionPane.showMessageDialog(null,strNotification,"Chu Dinh Hien - 20215046 Show two numbers",
        JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
