import java.util.Scanner;


public class _09_PointsInsideTheHouse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter to coords: ");
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		
		double apexAx = 12.5;
		double apexAy = 8.5;
		double apexBx = 22.5;
		double apexBy = 8.5;
		double apexCx = 17.5;
		double apexCy = 3.5;
		
		boolean isInside = false;
		
		double surfaceABC = Math.abs (apexAx * (apexBy - apexCy) + apexBx * (apexCy - apexAy) + apexCx * (apexAy - apexBy));
		double surfaceABP = Math.abs (apexAx * (apexBy - y) + apexBx * (y - apexAy) + x * (apexAy - apexBy));
		double surfaceAPC = Math.abs (apexAx * (y - apexCy) + x * (apexCy - apexAy) + apexCx * (apexAy - y));
		double surfacePBC = Math.abs (x * (apexBy - apexCy) + apexBx * (apexCy - y) + apexCx * (y - apexBy));
		
		if(surfaceABC == (surfaceABP + surfaceAPC + surfacePBC)) isInside = true;
		
		if(!isInside) {
			if((x >= 12.5 && x <= 17.5) || (x >= 20 && x <= 22.5) && y >= 8.5 && y <= 13.5)
					isInside = true;
		}
		
		String str = isInside == true ? "Inside" : "Outside";
		
		System.out.println(str);
		
	}
	


}

