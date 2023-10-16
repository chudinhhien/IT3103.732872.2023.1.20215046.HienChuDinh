//The first-degree equation (linear equation) with one variable
//ax+b=0
import javax.swing.JOptionPane;

public class LineEquation {
    public static void main(String[] args){
        String strA;
        String strB;
        //Nhập a từ dialog
        strA = JOptionPane.showInputDialog(null, "Chu Dinh Hien - 20215046-Please input a:","Chu Dinh Hien - 20215046-Input a",
        JOptionPane.INFORMATION_MESSAGE);
        //Nhập b từ dialog
        strB = JOptionPane.showInputDialog(null, "Chu Dinh Hien - 20215046-Please input b:","Chu Dinh Hien - 20215046-Input b",
        JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(strA); // chuyển xâu sang số thực
        double b = Double.parseDouble(strB); // chuyển xâu sang số thực
        if(a==0){   //Xử lý trường hợp a = 0
            if(b==0){ //Xử lý trường hợp a=0,b=0 => Phương trình có vô số nghiệm
                JOptionPane.showMessageDialog(null,"Phuong trinh vo so nghiem","Chu Dinh Hien - 20215046 Show:",
                JOptionPane.INFORMATION_MESSAGE);
            }else{ //Với b khác 0 thì phương trình vô nghiệm
                JOptionPane.showMessageDialog(null,"Phuong trinh vo nghiem","Chu Dinh Hien - 20215046 Show:",
                JOptionPane.INFORMATION_MESSAGE);
            }
        }else{  //  Với a khác 0 thì luôn có nghiệm
            String strNotification = "x=" + b/a;
            JOptionPane.showMessageDialog(null, strNotification,"Chu Dinh Hien - 20215046 Show:",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
