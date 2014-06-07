import java.util.Scanner;


public class _02_Generate3LetterWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a set of chars");
        String input = sc.next();
        char[] chars = input.toCharArray();	
		for (int m = 0; m < input.length(); m++) {
			for (int n = 0; n < input.length(); n++) {
				for (int p = 0; p < input.length(); p++) {
					System.out.print(chars[m] + "" + chars[n] + "" +chars[p] + " ");	
				}
			}
		}

	}

}
