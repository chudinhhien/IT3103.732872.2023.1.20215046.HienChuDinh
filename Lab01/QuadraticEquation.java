import javax.swing.JOptionPane;

public class QuadraticEquation {
    public static void main(String[] args){
        String strA,strB,strC;
        strA = JOptionPane.showInputDialog(null, "Chu Dinh Hien - 20215046-Please input a:","Chu Dinh Hien - 20215046-Quadratic Equation",JOptionPane.INFORMATION_MESSAGE);
        strB = JOptionPane.showInputDialog(null, "Chu Dinh Hien - 20215046-Please input b:","Chu Dinh Hien - 20215046-Quadratic Equation",JOptionPane.INFORMATION_MESSAGE);
        strC = JOptionPane.showInputDialog(null, "Chu Dinh Hien - 20215046-Please input c:","Chu Dinh Hien - 20215046-Quadratic Equation",JOptionPane.INFORMATION_MESSAGE);
        int a = Integer.parseInt(strA);
        int b = Integer.parseInt(strB);
        int c = Integer.parseInt(strC);
        if(a==0){
            if(b==0){
                if(c==0){
                    JOptionPane.showMessageDialog(null,"Phuong trinh co vo so nghiem","Chu Dinh Hien-20215046-Quadratic Equation",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"Phuong trinh co vo nghiem","Chu Dinh Hien-20215046-Quadratic Equation",JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                String strNotification = "Phuong trinh co nghiem duy nhat:\nx="+(double) -c/b;
                JOptionPane.showMessageDialog(null,strNotification,"Chu Dinh Hien-20215046-Quadratic Equation",JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            int delta = b*b - 4*a*c;
            if(delta==0){
                String strNotification = "Phuong trinh co nghiem kep:\nx1=x2="+(double) -b/(2*a);
                JOptionPane.showMessageDialog(null,strNotification,"Chu Dinh Hien-20215046-Quadratic Equation",JOptionPane.INFORMATION_MESSAGE);
            }else if(delta<0){
                JOptionPane.showMessageDialog(null,"Phuong trinh co vo nghiem","Chu Dinh Hien-20215046-Quadratic Equation",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"x1="+(double)(-b+Math.sqrt((double)delta))/(2*a)+"\nx2="+(double)(-b-Math.sqrt((double)delta))/(2*a),"Chu Dinh Hien-20215046-Quadratic Equation",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        System.exit(0);
    }
}
