import java.util.Scanner;


public class _01_RectangleArea {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the sides of a rectangle /integers/: ");
		int sideA = sc.nextInt();
		int sideB = sc.nextInt();
		long area = calcArea(sideA, sideB);
		System.out.println("The area is: " + area);

	}

	private static long calcArea(int sideA, int sideB) {
		long area = sideA * sideB;
		return area;
	}

}
