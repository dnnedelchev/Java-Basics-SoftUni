import java.util.Scanner;


public class _07_CountSubstringOccurrences {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String text = sc.nextLine().toLowerCase();
		String target = sc.nextLine().toLowerCase();
		
		int countOfRepeats = 0;
		
		for (int i = 0; i <= text.length() - target.length(); i++) {
			if (text.substring(i, i + target.length()).equals(target))
				countOfRepeats++;
		}
		
		System.out.println(countOfRepeats);

	}

}
