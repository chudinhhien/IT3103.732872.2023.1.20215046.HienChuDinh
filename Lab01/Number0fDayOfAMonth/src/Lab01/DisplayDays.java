package Lab01;

import java.util.Scanner;

public class DisplayDays {
	public static boolean checkMonth(String s) {
		switch(s) {
			case "1","2","3","4","5","6","7","8","9","10","11","12":
				return true;
			case "Jan.","Feb.","Mar.","Apr.","May","June","July","Aug.","Sept.","Oct.","Nov.","Dec.":
				return true;
			case "Jan","Feb","Mar","Apr","Jun","Jul","Aug","Sep","Oct","Nov","Dec":
				return true;
			case "January","February","March","April","August","September","October","November","December":
				return true;
			default:
				System.out.println("Enter error. Please enter again month!");
				return false;
		}
	}
	
	public static boolean checkYear(String s) {
		for(int i=0;i<s.length();i++) {
			if(!Character.isDigit(s.charAt(i))) {
				return false;
			}
		}
		return s.length()==4;
	}
	
	public static boolean checkLeapYear(String s) {
		int y = Integer.parseInt(s);
		if(y%4==0&&y%100!=0) {
			return true;
		}
		
		return false;
	}
	
	public static int numberDays(String month,String year) {
		switch(month) {
			case "1","Jan.","Jan","January":
				return 31;
			case "February","Feb.","Feb","2":
				if(checkLeapYear(year)) return 29;
				else return 28;
			case "March","Mar.","Mar","3":
				return 31;
			case "4","Apr.","Apr","April":
				return 30;
			case "5","May":
		        return 31;
		    case "6","June":
		        return 30;
		    case "7","July":
		        return 31;
		    case "8","Aug.","Aug","August":
		        return 31;
		    case "9","Sep.","Sep","September":
		        return 30;
		    case "10","Oct.","Oct","October":
		        return 31;
		    case "11","Nov.","Nov","November":
		        return 30;
		    case "12","Dec.","Dec","December":
		        return 31;
		    default:
		    	return -1;
		}
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String month,year;
		//input month
		do {
			System.out.print("Chu Dinh Hien-20215046-Please enter month:");
			month = keyboard.nextLine();
		}while(!checkMonth(month));
		//input year
		do {
			System.out.print("Chu Dinh Hien-20215046-Please enter year:");
			year = keyboard.nextLine();
		}while(!checkYear(year));
		
		System.out.println("Number Days of Month "+month+" in Year "+year+": "+numberDays(month, year));
		System.exit(0);
	}
}
