//A system of first-degree equations with two variables x1 and x2 can be written as follows.
//a11.x1+a12.x2=b1  
//a21.x1+a22.x2=b2  

import javax.swing.JOptionPane;

public class LinearSystem {
    public static void main(String[] args){
        String strA11;
        String strA12;
        String strA21;
        String strA22;
        String strB1;
        String strB2;
        strA11 = JOptionPane.showInputDialog(null, "Chu Dinh Hien - 20215046-Please input a11:","Chu Dinh Hien - 20215046-Linear System",JOptionPane.INFORMATION_MESSAGE);
        strA12 = JOptionPane.showInputDialog(null, "Chu Dinh Hien - 20215046-Please input a12:","Chu Dinh Hien - 20215046-Linear System",JOptionPane.INFORMATION_MESSAGE);
        strB1 = JOptionPane.showInputDialog(null, "Chu Dinh Hien - 20215046-Please input b1:","Chu Dinh Hien - 20215046-Linear System",JOptionPane.INFORMATION_MESSAGE);
        strA21 = JOptionPane.showInputDialog(null, "Chu Dinh Hien - 20215046-Please input a21:","Chu Dinh Hien - 20215046-Linear System",JOptionPane.INFORMATION_MESSAGE);
        strA22 = JOptionPane.showInputDialog(null, "Chu Dinh Hien - 20215046-Please input a22:","Chu Dinh Hien - 20215046-Linear System",JOptionPane.INFORMATION_MESSAGE);
        strB2 = JOptionPane.showInputDialog(null, "Chu Dinh Hien - 20215046-Please input b2:","Chu Dinh Hien - 20215046-Linear System",JOptionPane.INFORMATION_MESSAGE);
        int a11 = Integer.parseInt(strA11);
        int a12 = Integer.parseInt(strA12);
        int a21 = Integer.parseInt(strA21);
        int a22 = Integer.parseInt(strA22);
        int b1 = Integer.parseInt(strB1);
        int b2 = Integer.parseInt(strB2);
        int D = a11*a22 - a21*a12;
        int D1 = b1*a22 - b2*a12;
        int D2 = a11*b2 - a21*b1;
        if(D==0&&D1==0&&D2==0){
            JOptionPane.showMessageDialog(null,"Phuong trinh vo so nghiem","Chu Dinh Hien-20215046-Show:",JOptionPane.INFORMATION_MESSAGE);
        }else if(D==0){
            JOptionPane.showMessageDialog(null,"Phuong trinh vo nghiem","Chu Dinh Hien-20215046-Show:",JOptionPane.INFORMATION_MESSAGE);
        }else{
            String strNotification1 = "x1="+(double) D1/D;
            String strNotification2 = "x2="+(double) D2/D;
            JOptionPane.showMessageDialog(null, strNotification1,"Chu Dinh Hien - 20215046 Show:",JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, strNotification2,"Chu Dinh Hien - 20215046 Show:",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
