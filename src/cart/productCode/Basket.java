package cart.productCode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Basket {
	
	private List<Product> items = new ArrayList<Product>();

	public void add(Product product) {
		
		if(product.getPrice().compareTo(BigDecimal.ZERO) < 0)
			throw new IllegalArgumentException("Cannot add a product with a price less than zero.");
			
		items.add(product);
	}
	
	public int size() {
		
		return items.size();
	}

	public BigDecimal total() {
		
		BigDecimal runningTotal = new BigDecimal("0.00");
		for (Product product : items) {
			runningTotal = runningTotal.add(product.getPrice());
		}
		return runningTotal;
	}

	public BigDecimal totalWithSaleTax() {
		
		return total().multiply(new BigDecimal("1.20"));
	}

}
