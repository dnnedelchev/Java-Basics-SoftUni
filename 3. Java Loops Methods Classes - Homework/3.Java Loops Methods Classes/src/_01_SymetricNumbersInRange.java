import java.util.Scanner;


public class _01_SymetricNumbersInRange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter borders: ");
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		
		for (int j = start; j <= end; j++) {
			String number = j + ""; 
			boolean isSymetric = true;
			for (int i = 0; i < number.length() / 2; i++) {
				if (number.charAt(i) != number.charAt(number.length() - i - 1)) {
					isSymetric = false;
				}
			}
			if (isSymetric) 
				System.out.print(number + " ");
		}
	}

}