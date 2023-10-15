package Lab01;

import java.util.Scanner;

public class DisplayTriangle {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int n = keyboard.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n+1-i;j++) {
				System.out.print(" ");
			}
			for(int j=n+2-i;j<=n+i;j++) {
				System.out.print("*");
			}
			for(int j=1;j<=n+1-i;j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
