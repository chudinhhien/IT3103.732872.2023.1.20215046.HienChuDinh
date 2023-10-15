import java.util.Arrays;
import java.util.Scanner;

public class SortArrayAndSum {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int n = keyboard.nextInt();
		int sum = 0;
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = keyboard.nextInt();
			sum+=a[i];
		}
		Arrays.sort(a);
		for(int i=0;i<n;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		System.out.println("Sum of array: "+sum);
		System.out.println("Average of array: "+(double)sum/n);
	}
}
