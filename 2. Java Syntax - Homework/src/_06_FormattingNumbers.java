import java.util.Scanner;


public class _06_FormattingNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 3 numbers");
		int firstNumber = sc.nextInt();
		double secondNumber = sc.nextDouble();
		double thirdNumber = sc.nextDouble();
		
		System.out.printf("|%-10s|%010d|%10.2f|%-10.3f|",  Integer.toHexString(firstNumber).toUpperCase(), 
				Integer.parseInt(Integer.toBinaryString(firstNumber)), secondNumber, thirdNumber);
        
	}

}
