import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class _09_CombineListsOfLetters {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		char[] firstLine = sc.nextLine().replaceAll("\\W", "").toCharArray();
		char[] secondLine = sc.nextLine().replaceAll("\\W", "").toCharArray();
		
		List<Character> l1 = new ArrayList<>();
		List<Character> l2 = new ArrayList<>();
		
		for (int i = 0; i < firstLine.length; i++) {
			l1.add(firstLine[i]);
		}
		for (int i = 0; i < secondLine.length; i++) {
			l2.add(secondLine[i]);
		}
		
		List<Character> clonel1 = new ArrayList<>(l1);
		
		for (Character character : l2) {
			if (! clonel1.contains(character)) {
				l1.add(character);
			}
		}
		
		
		for (Character character : l1) {
			System.out.print(character + " ");
		}

	}

}
