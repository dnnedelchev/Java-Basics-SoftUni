import java.sql.Date;
import java.util.Scanner;


public class _07_DaysBetweenTwoDates {
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("Enter first date: ");
		String input = sc.nextLine();
		int day = Integer.parseInt(input.substring(0, input.indexOf("-")));
		int month = Integer.parseInt(input.substring(input.indexOf("-") + 1, input.lastIndexOf("-")));
		int year = Integer.parseInt(input.substring(input.lastIndexOf("-") + 1));
		Date firstDate = new Date(year, month, day);

		System.out.print("Enter second date: ");
		input = sc.nextLine();
		day = Integer.parseInt(input.substring(0, input.indexOf("-")));
		month = Integer.parseInt(input.substring(input.indexOf("-") + 1, input.lastIndexOf("-")));
		year = Integer.parseInt(input.substring(input.lastIndexOf("-") + 1));
		Date secondDate = new Date(year, month, day);
		
		int days = (int) ((secondDate.getTime() - firstDate.getTime()) / (1000 * 60 * 60 * 24) );
		System.out.println(days);
		
	}
}
