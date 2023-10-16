import java.util.Scanner;

public class AddTwoMatrices {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.printf("Chu Dinh Hien-20215046-Please enter size of matrix: ");
		//Khai báo kích thước của ma trận NxN
		int n = keyboard.nextInt();
		System.out.println("Chu Dinh Hien-20215046-Please enter matrix 1:");
		int [][] a = new int[n][n];//Khai báo ma trận a 
		int [][] b = new int[n][n];//Khai báo ma trận b
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				a[i][j] = keyboard.nextInt();//Nhập thông tin cho ma trận a
			}
		}
		System.out.println("Chu Dinh Hien-20215046-Please enter matrix 2:");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				b[i][j] = keyboard.nextInt();//Nhập thông tin cho ma trận b
			}
		}
		System.out.println("Sum of 2 Matrices:");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(a[i][j]+b[i][j]+" ");//Tính tổng 2 ma trận bằng cách
													  //cộng 2 phần tử cùng hàng cùng cột
													  //IN ra
			}
			System.out.println();
		}
	}
}
