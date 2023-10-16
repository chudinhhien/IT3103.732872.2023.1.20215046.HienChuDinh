package Lab01;
import java.util.Scanner;

public class InputFromKeyboard {
	public static void main(String args[]) {
		//Khai báo biến đọc dữ liệu từ bàn phím
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("What's your name?");
		//Đọc xâu từ bàn phím
		String strName = keyboard.nextLine();
		System.out.println("How old are you?");
		//Đọc số nguyên từ bàn phím
		int iAge = keyboard.nextInt();
		System.out.println("How tall are you (m)?");
		//Đọc số thực từ bàn phím
		double dHeight = keyboard.nextDouble();
		//In ra kết quả
		System.out.print("Mrs.Ms " + strName + ", " + iAge + " years old. "
						+ "Your height is " + dHeight + ".");
	}
}
