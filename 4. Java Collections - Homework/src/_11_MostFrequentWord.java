import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class _11_MostFrequentWord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] words = sc.nextLine().toLowerCase().split("\\W+");
		
		Map<String, Integer> wordCounter = new TreeMap<>();
		
		for (String word : words) {
			if(wordCounter.containsKey(word)) {
				wordCounter.put(word, wordCounter.get(word) + 1);
			}
			else
				wordCounter.put(word, 1);
		}
		
		int mostFrequent = 0;
		for (Map.Entry<String, Integer> word : wordCounter.entrySet()) {
			if (mostFrequent < word.getValue())
				mostFrequent = word.getValue();
		}
		
		for (Map.Entry<String, Integer> word : wordCounter.entrySet()) {
			if (mostFrequent == word.getValue())
				System.out.println(word.getKey() + " -> " + word.getValue());
		}
	}

}
