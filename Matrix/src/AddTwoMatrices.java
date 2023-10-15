import java.util.Scanner;

public class AddTwoMatrices {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.printf("Chu Dinh Hien-20215046-Please enter size of matrix: ");
		int n = keyboard.nextInt();
		System.out.println("Chu Dinh Hien-20215046-Please enter matrix 1:");
		int [][] a = new int[n][n];
		int [][] b = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				a[i][j] = keyboard.nextInt();
			}
		}
		System.out.println("Chu Dinh Hien-20215046-Please enter matrix 2:");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				b[i][j] = keyboard.nextInt();
			}
		}
		System.out.println("Sum of 2 Matrices:");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(a[i][j]+b[i][j]+" ");
			}
			System.out.println();
		}
	}
}
