import java.util.Scanner;


public class _02_Problem2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long value = 0l;
		String input = sc.nextLine() + " e";
		String[] cards = input.replaceAll("[SHDC]+", "").split(" ");
		
		int counter = 1;
		for(int i = 0; i < cards.length - 1; i++) {
			if (! cards[i].equals(cards[i + 1])) {
				if (counter != 1) {
					value += counter * getValue(cards[i]) * 2;
				}
				else {
					value += getValue(cards[i]);
				}
				counter = 1;
			}
			else {
				counter++;
			}
			
		}
		
		System.out.println(value);
		
		
		

	}

	public static int getValue(String card) {
		int value = 0;
		switch (card) {
		case "J":
			value = 12;
			break;
		case "Q":
			value = 13;
			break;
		case "K":
			value = 14;
			break;
		case "A":
			value =  15;
			break;

		default:
			value = Integer.parseInt(card);
			break;
		}
		
		return value;
	}
	
	
}
