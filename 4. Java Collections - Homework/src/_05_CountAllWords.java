import java.util.Scanner;


public class _05_CountAllWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine();
		System.out.println(sentence.split("\\W+").length);
	}

}
