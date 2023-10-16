import java.util.Arrays;
import java.util.Scanner;

public class SortArrayAndSum {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Chu Dinh Hien-20215046 Please enter n = ");
		int n = keyboard.nextInt();//Nhập số phần tử của mảng
		int sum = 0;//Biến sum để lưu tổng của các phần tử trong mảng
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = keyboard.nextInt();//Nhập phần tử cho mảng
			sum+=a[i];
		}
		Arrays.sort(a);//Hàm sort trong class Arrays để sắp xếp các phần tử trong mảng a;
		for(int i=0;i<n;i++) {
			System.out.print(a[i]+" ");//In mảng sau khi được sắp xếp
		}
		System.out.println();
		System.out.println("Sum of array: "+sum);//In tổng của mảng
		System.out.println("Average of array: "+(double)sum/n);//In trung bình cộng của mảng
	}
}
