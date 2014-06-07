import java.text.DecimalFormat;


public class Product implements Comparable <Product>{
	private String name;
	private double price;
	Product (String name, double price) {
		this.name = name;
		this.price = price;
	}
	public double getPrice() {
		return this.price;
	}
	@Override 
	public String toString() {
		DecimalFormat formatter = new DecimalFormat("#0.00");
		return formatter.format(this.price) + " " + this.name;
	}
	@Override
	public int compareTo(Product arg) {
		if(this.price < arg.price)
			return -1;
		else if (this.price > arg.price)
			return 1;
		return 0;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}