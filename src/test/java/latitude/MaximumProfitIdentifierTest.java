package latitude;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

public class MaximumProfitIdentifierTest {

	private MaximumProfitIdentifier identifier = new MaximumProfitIdentifier();
	
	@Test
	public void testNull() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> identifier.findMaximumProfit(null));
		assertTrue(ex.getMessage().contains("No stock prices were provided."));
	}
	
	@Test
	public void testNoPrices() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> identifier.findMaximumProfit(new int[] {}));
		assertTrue(ex.getMessage().contains("No stock prices were provided."));
	}
	
	@Test
	public void testOnePrice() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> identifier.findMaximumProfit(new int[] {1}));
		assertTrue(ex.getMessage().contains("Only one stock price provided. At least two prices are needed to be able to buy and sell."));
	}
	
	@Test
	public void testNegativePrice() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> identifier.findMaximumProfit(new int[] {5, 10, 20, -5}));
		assertTrue(ex.getMessage().contains("Stock prices can't be negative"));
	}
	
	@Test
	public void testCantSellAtSameTimeYouBuy() {
		assertEquals(identifier.findMaximumProfit(new int[]{5, 3}), -2); 
		assertEquals(identifier.findMaximumProfit(new int[]{8, 7, 3, 1}), -1); 
	}
	
	@Test
	public void testSamePrice() {
		assertEquals(identifier.findMaximumProfit(new int[]{5, 5, 5, 5}), 0); 
	}
	
	@Test
	public void testProvidedExample() {
		assertEquals(identifier.findMaximumProfit(new int[]{10, 7, 5, 8, 11, 9}), 6); 
	}
	
	@Test
	public void testMultipleMax() {
		assertEquals(identifier.findMaximumProfit(new int[]{40, 80, 30, 60, 10, 20}), 40); 
	}
	
}
