package cart.productCode;

import java.math.BigDecimal;

public class Product {

	private BigDecimal price; 
	
	public Product(BigDecimal price) {
		
		this.price = price;
	}

	public Product() {
		
	}

	public BigDecimal getPrice() {
		
		return price;
	}

}
