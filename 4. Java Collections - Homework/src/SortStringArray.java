import java.util.Arrays;
import java.util.Scanner;

public class SortStringArray {
	
	public static void main(String[] args) {
		
		Scanner inputScannerStream = new Scanner(System.in);
		
		int stringsCount;
		stringsCount = inputScannerStream.nextInt();
		String[] inputStrings = new String[stringsCount];
		
		for (int i = 0; i < inputStrings.length; i++) {
			inputStrings[i] = inputScannerStream.next();
		}
		
		inputScannerStream.close();
		
		Arrays.sort(inputStrings);
		
		System.out.println("--------");
		
		for (int i = 0; i < inputStrings.length; i++) {
			System.out.println(inputStrings[i]);
		}
	}
}