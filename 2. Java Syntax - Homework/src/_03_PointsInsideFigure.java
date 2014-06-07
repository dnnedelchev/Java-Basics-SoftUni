import java.util.Scanner;


public class _03_PointsInsideFigure {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the coords of point: ");
		double xCoord = Double.parseDouble(sc.next());
		double yCoord = Double.parseDouble(sc.next());
		
		if(xCoord >= 12.5 && xCoord <= 22.5 && yCoord >= 6 && yCoord <= 13.5) {
			if(xCoord > 17.5 && xCoord < 20 && yCoord > 8.5 && yCoord < 13.5)
				System.out.println("Outside");
			System.out.println("Inside");
		}
		else
			System.out.println("Outside");
	}

}
