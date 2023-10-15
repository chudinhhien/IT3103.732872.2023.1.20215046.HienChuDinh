//The first-degree equation (linear equation) with one variable
//ax+b=0
import javax.swing.JOptionPane;

public class LineEquation {
    public static void main(String[] args){
        String strA;
        String strB;
        strA = JOptionPane.showInputDialog(null, "Chu Dinh Hien - 20215046-Please input a:","Chu Dinh Hien - 20215046-Input a",JOptionPane.INFORMATION_MESSAGE);
        strB = JOptionPane.showInputDialog(null, "Chu Dinh Hien - 20215046-Please input b:","Chu Dinh Hien - 20215046-Input b",JOptionPane.INFORMATION_MESSAGE);
        int a = Integer.parseInt(strA); // chuyển xâu sang số nguyên
        int b = Integer.parseInt(strB); // chuyển xâu sang số nguyên
        if(a==0){
            JOptionPane.showMessageDialog(null,"Phuong trinh vo nghiem","Chu Dinh Hien - 20215046 Show:",JOptionPane.INFORMATION_MESSAGE);
        }else{
            String strNotification = "x="+(double)b/a;
            JOptionPane.showMessageDialog(null, strNotification,"Chu Dinh Hien - 20215046 Show:",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
