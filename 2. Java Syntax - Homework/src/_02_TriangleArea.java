import java.util.Scanner;

public class _02_TriangleArea {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] points = new int[6];
		double[] lengths = new double[3];
		for(int i = 0; i < 3; i++) {
			System.out.print("Enter coords of point " + (char)('A' + i) + ": ");
			points[i * 2] = sc.nextInt();
			points[i * 2 + 1] = sc.nextInt();
			System.out.println();
		}
		for (int i = 0; i < 2; i++) {
			lengths[i] = getLength(points[i * 2], points[i * 2 + 1], 
					              points[(i + 1) * 2], points[(i + 1) * 2 + 1]);
		}
		lengths[2] = getLength(points[0], points[1], points[4], points[5]);
		
		if(isTrianlge(lengths)) {
			System.out.println(Math.round(heronArea(lengths)));
		}
		else {
			System.out.println(0);
		}

	}

	private static double heronArea(double[] lengths) {
		double perimeter = lengths[0] + lengths[1] + lengths[2];
		double semiperimeter = perimeter / 2;
		double area = Math.sqrt( semiperimeter * 
							     (semiperimeter - lengths[0]) * 
							     (semiperimeter - lengths[1]) * 
							     (semiperimeter - lengths[2]) );
		return area;
	}

	private static boolean isTrianlge(double[] lengths) {
		boolean isTriangle;
		isTriangle = (lengths[0] < lengths[1] + lengths[2] 
					  || lengths[1] < lengths[0] + lengths[2]
					  || lengths[2] < lengths[0] + lengths[1]);
		return isTriangle;
	}

	private static double getLength(int firstPointX, int firstPointY, int secondPointX, int secondPointY) {
		double length = Math.sqrt((firstPointX - secondPointX) * (firstPointX - secondPointX) 
								+ (firstPointY - secondPointY) * (firstPointY - secondPointY));
		return length;
	}
}

