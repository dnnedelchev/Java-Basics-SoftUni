import java.util.Scanner;


public class _04_TheSmallestOne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 3 numbers: ");
		double a = Double.parseDouble(sc.next());
		double b = Double.parseDouble(sc.next());
		double c = Double.parseDouble(sc.next());
		double minValue = Double.MIN_VALUE;
		if(a <= b && a <= c)
			minValue = a;
		else if(b <= a && b <= c)
			minValue = b;
		else if(c <= b && c <= a)
			minValue = c;
		System.out.println(minValue);
	}

}
