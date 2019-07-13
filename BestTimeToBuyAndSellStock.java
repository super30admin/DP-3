package day9;

//Time Complexity : O(n) where n is the length of prices array 
//Space Complexity : O(1) where 2 variables are used
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : no

public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {

		int minValue = Integer.MAX_VALUE;
		int maxProfit = 0;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minValue) {
				minValue = prices[i];
			} else {
				if ((prices[i] - minValue) > maxProfit) {
					maxProfit = prices[i] - minValue;
				}
			}
		}
		return maxProfit;

		/*
		 * int pricesSize = prices.length;
		 * 
		 * int minPricePos = 0,maxProfit = 0; 
		 * for(int i = 1; i < prices.length; i++) {
		 * if(prices[i] - prices[minPricePos] > maxProfit) 
		 * maxProfit = prices[i] - prices[minPricePos] ; 
		 * else if(prices[i] - prices[minPricePos] < 0)
		 * minPricePos = i; 
		 * } 
		 * return maxProfit;
		 */

		// Tried Brute force 1

//        int min = 0, max = Integer.MIN_VALUE, max1 = Integer.MIN_VALUE + 1, profit = 0;

//        if(prices == null || prices.length == 0) return -1;

//       for(int i = 0; i < prices.length - 1; i++) {

//           if (prices[i] > prices[i + 1]) {
//               if(prices[i] > max) {
//               max = prices[i];
//           }
//            else max1 = prices[i];   
//           }
//           else if (prices[i] < prices[i + 1] && prices[i] < min) {
//               min = prices[i];
//           }

//       }
//            return profit = max1 - min;

	}
}
