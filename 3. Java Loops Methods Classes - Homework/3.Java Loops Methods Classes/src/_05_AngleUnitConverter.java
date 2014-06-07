import java.util.Scanner;


public class _05_AngleUnitConverter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfQueries = sc.nextInt();
		
		for (int i = 0; i < numberOfQueries; i++) {
			double value = sc.nextDouble();
			String measure = sc.next();
			switch (measure) {
			case "deg":
				System.out.printf("%6f rad\r\n", value * Math.PI / 180);
				break;
			case "rad":
				System.out.printf("%6f deg\r\n", value * 180 / Math.PI);
				break;
			default:
				break;
			}
		}

	}

}
