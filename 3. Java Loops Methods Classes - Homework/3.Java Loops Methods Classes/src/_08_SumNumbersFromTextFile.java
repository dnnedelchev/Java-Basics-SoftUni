import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class _08_SumNumbersFromTextFile {

	public static void main(String[] args) {
		File file = new File("Input.txt");
		long sum = 0;
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNext()) {
				sum += Integer.parseInt(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error");
			return;
		}
		System.out.println(sum);
	}

}
