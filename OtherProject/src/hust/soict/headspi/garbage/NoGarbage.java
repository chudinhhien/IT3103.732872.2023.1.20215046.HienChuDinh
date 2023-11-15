package hust.soict.headspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
	public static void main(String[] args) throws IOException {
        //Chu Dinh Hien - 20215046: Code session 9
		String filename = "C:\\Users\\Hien\\OneDrive - Hanoi University of Science and Technology\\TH-OOP\\IT3103.732872.2023.1.20215046.HienChuDinh"+
		        "\\OtherProject\\src\\hust\\soict\\headspi\\garbage\\text.txt";
		byte[] inputString = { 0 };
		long startTime, endTime;

		inputString = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		StringBuilder garbage = new StringBuilder();
		for (byte b : inputString) {
			garbage.append((char) b);
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
        // Chu Dinh Hien - 20215046: print around 4
	}
}
