import java.util.Scanner;


public class _07_CountOfBitsOne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an integer number: ");
		String value = Integer.toBinaryString(sc.nextInt());
		
		int count = 0;
		for (int i = 0; i < value.length() ; i++) {
			if(value.charAt(i) == '1')
				count++;
		}
		System.out.println(count);
		
	}

}
