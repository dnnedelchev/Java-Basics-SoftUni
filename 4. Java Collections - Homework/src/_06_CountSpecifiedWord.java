import java.util.Scanner;


public class _06_CountSpecifiedWord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		String target = sc.nextLine();
		int countOfRepeats = 0;
		
		String[] words = text.split("\\W+");
		
		for (String word : words) {
			if (word.toLowerCase().equals(target.toLowerCase()))
				countOfRepeats++;				
		}
		
		System.out.println(countOfRepeats);

	}

}
