import java.util.Scanner;


public class _01_Problem1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = Integer.parseInt(sc.nextLine());
		String[] numbers = sc.nextLine().split(" ");
		boolean isAny = false;
		
		for(int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (i == j)
					continue;
				else {
					for (int m = 0; m < numbers.length; m++) {
						if(m == i || m == j) 
							continue;
						else {
							for (int k = 0; k < numbers.length; k++) {
								if (k == m || k == j || k == i)
									continue;
								else {
									String str1 = numbers[i] + numbers[j];
									String str2 = numbers[k] + numbers[m];
									if(str1.equals(str2)) {										
										System.out.println(numbers[i] + "|" + numbers[j] + "==" + numbers[k] + "|" + numbers[m]);
										isAny = true;
									}
								}
							}
						}
					}
				}
			}
		}
		
		if(!isAny) 
			System.out.println("No");
	}

}
