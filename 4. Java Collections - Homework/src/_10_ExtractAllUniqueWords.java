import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class _10_ExtractAllUniqueWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] words = sc.nextLine().toLowerCase().split("\\W+");
		Set<String> uniqueWords = new TreeSet<>();
		for (String word : words) {
			if (!uniqueWords.contains(word)) {
				uniqueWords.add(word);
			}
		}
		for (String word : uniqueWords) {
			System.out.print(word + " ");
		}
	}
}
