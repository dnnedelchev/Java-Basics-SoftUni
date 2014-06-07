
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;



public class _03_Problem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String expression = sc.nextLine().replaceAll(" ", "");
		
		BigDecimal totalSum = new BigDecimal("0");
		
		for(int i = 0; i < expression.length(); ) {
		
			int signPos = nextSignPossition(expression, 1);
			int nextSignPost = nextSignPossition(expression, signPos + 1);
			if(nextSignPost == -1) {
				BigDecimal firstNumber = new BigDecimal(expression.substring(0, signPos));
				String operation = expression.substring(signPos, signPos + 1);
				BigDecimal secondNumber = new BigDecimal(expression.substring(signPos + 1, expression.length()));
				
				totalSum = calc(firstNumber, secondNumber, operation);
				
				break;
			}
			BigDecimal firstNumber = new BigDecimal(expression.substring(0, signPos));
			String operation = expression.substring(signPos, signPos + 1);
			BigDecimal secondNumber = new BigDecimal(expression.substring(signPos + 1, nextSignPost));
			
			String sum = calc(firstNumber, secondNumber, operation) + "";
		
			expression = sum  + expression.substring(nextSignPost);
		
		}		
		
		System.out.println(totalSum);
		
		
		
	}
	
	public static BigDecimal calc(BigDecimal firstValue, BigDecimal secondValue, String sign) {
		BigDecimal sum = new BigDecimal("0");
		switch (sign) {
		case "+":
			sum = firstValue.add(secondValue);
			break;
		case "-":
			sum = firstValue.subtract(secondValue);
			break;
		default:
			break;
		}
		
		return sum;
	}
	
	public static int nextSignPossition (String expression, int start) {
		int signPos;
		int plusIndex = expression.indexOf("+", start);
		int minusIndex = expression.indexOf("-", start);
		
		if (plusIndex == -1 && minusIndex == -1) {
			signPos = -1;
		}
		else {
			signPos = (plusIndex < minusIndex && plusIndex != -1 || minusIndex == -1) ? plusIndex : minusIndex;
		}
		
		return signPos;
		
	}
	

}