package latitude;

public class MaximumProfitIdentifier {

	/**
	 * Efficient algorithm with O(N) complexity
	 * @param stockPrices - Prices for a given stock where the index in the array represents the minutes past 10:00AM
	 * @return Maximum profit attainable from buying and selling a stock given the provided stockPrices 
	 */
	public int findMaximumProfit(int[] stockPrices) {
		
		if( stockPrices == null || stockPrices.length == 0 ) {
			throw new IllegalArgumentException("No stock prices were provided. Argument was null.");
		}
		
		if( stockPrices.length == 1 ) {
			throw new IllegalArgumentException("Only one stock price provided. At least two prices are needed to be able to buy and sell.");
		}
		
		boolean set = false;
		
		Integer lowPrice = null;
		Integer highPrice = null;
		Integer maxDifference = null;
		
		for(int price: stockPrices) {
			
			if( price < 0 ) {
				throw new IllegalArgumentException("Provided " + price + " which is negative. Stock prices can't be negative");
			}
			
			if(!set){
				
				lowPrice = price;
				set = true;
				continue;
				
			}
			
			// Check for high price == null in case this is the second price in the list.
			if( highPrice == null || price > highPrice ) {
				
				highPrice = price;
				int difference = highPrice - lowPrice;

				if( maxDifference == null || difference > maxDifference ) {
					maxDifference = difference;
				}
				continue;
				
			}
			
			if( price < lowPrice ) {
				
				lowPrice = price;
				highPrice = null;
				
			}
			
		}
		
		return maxDifference;
		
	}
	
	
	public static void main(String[] args) {
		// Left blank as challenge said to write an efficient function, not program. 
	}

}
