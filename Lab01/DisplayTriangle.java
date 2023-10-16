package Lab01;

import java.util.Scanner;

public class DisplayTriangle {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please CHU DINH HIEN-20215046 ENTER N:");
		int n = keyboard.nextInt();
		for(int i=1;i<=n;i++) {//Vòng lặp để in số dòng
			for(int j=1;j<=n+1-i;j++) {//Vòng lặp để in dấu cách
				System.out.print(" ");
			}
			for(int j=n+2-i;j<=n+i;j++) {//Vòng lặp in dấu *
				System.out.print("*");
			}
			for(int j=1;j<=n+1-i;j++) {//Vòng lặp in dấu cách
				System.out.print(" ");
			}
			System.out.println();//Mỗi lần hết dòng thì xuống dòng
		}
	}
}
