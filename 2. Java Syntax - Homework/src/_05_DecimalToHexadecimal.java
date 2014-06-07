import java.util.Scanner;


public class _05_DecimalToHexadecimal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a positive integer: ");
		String value = Integer.toHexString(sc.nextInt()).toUpperCase();
		System.out.println(value);

	}

}
