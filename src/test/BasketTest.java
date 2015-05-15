package test;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import cart.productCode.Basket;
import cart.productCode.Product;

public class BasketTest {
	
	private Basket basket;
	
	@Before
	public void setUp() throws Exception{
		basket = new Basket();
	}

	@Test
	public void itemsCanBeAddedToTheBasket() throws Exception {
		
		basket.add(product("10.00"));
		basket.add(product("10.00"));
		
		assertEquals(2, basket.size());
	}
	
	private Product product(String val){
		return new Product(new BigDecimal(val));
	}
	
	@Test
	public void basketCanCalculateTheTotalCostOfABasket() throws Exception {
		
		basket.add(product("19.99"));
		basket.add(product("20.00"));
		
		assertEquals(new BigDecimal("39.99"), basket.total());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void basketDoesNotAcceptProductsWithANegativePrice() throws Exception {
				
		basket.add(product("-10.00"));
	}
	
	@Test
	public void basketDoesAcceptProductsWithZeroPrice() throws Exception {
				
		basket.add(product("0.00"));
		assertEquals(new BigDecimal("0.00"), basket.total());
	}
	
	@Test
	public void basketAddsSalesTaxToTotal() throws Exception {
				
		basket.add(product("20.00"));
		basket.add(product("20.00"));
		assertEquals(new BigDecimal("48.0000"), basket.totalWithSaleTax());
	}
	

}
