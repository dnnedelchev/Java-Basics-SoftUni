import java.util.Scanner;


public class _03_LargestSequenceOfEqualStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String[] words = sc.nextLine().split(" ");
		
		int countOfEqualStrings = 1;
		int maxcountOfEqualStrings = 1;
		String word = words[0] + "";
		for (int i = 0; i < words.length - 1; i++) {
			//Next word is equal
			if (words[i].equals(words[i+1])) {
				countOfEqualStrings++;
				if (i == words.length - 2) {
					if (maxcountOfEqualStrings < countOfEqualStrings) {
						word = words[i] + "";
						maxcountOfEqualStrings = countOfEqualStrings;
					}
				}
			}
			//Next word is not equal
			else {
				if (maxcountOfEqualStrings < countOfEqualStrings) {
					word = words[i] + "";
					maxcountOfEqualStrings = countOfEqualStrings;
				}
				countOfEqualStrings = 1;
			}
		}
		
		for (int i = 0; i < maxcountOfEqualStrings; i++) {
			System.out.print(word + " ");
		}

	}

}
