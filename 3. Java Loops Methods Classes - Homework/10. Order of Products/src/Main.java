import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeSet;




public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		double totalSum = 0;
		TreeSet<Product> products = new TreeSet<Product>();
		try {
			Scanner sc = new Scanner(new File("Products.txt"));
			while (sc.hasNext()) {
				products.add(new Product(sc.next(), sc.nextDouble()));
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Scanner sc = new Scanner(new File("Order.txt"));
			while (sc.hasNext()) {
				double quantity = sc.nextDouble();
				String productName = sc.next();
				for (Product product : products) {
					if (product.equals(new Product(productName, 0))) {
						totalSum += quantity * product.getPrice();
					}
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			PrintWriter pw = new PrintWriter(new File("Output.txt"));
			DecimalFormat formatter = new DecimalFormat("#0.00");
			pw.println(formatter.format(totalSum));
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
