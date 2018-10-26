package com.changhun.z.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most 2 times
(i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.


Intuit
easy

 * @author changhun
 *
 */
public class EP5_7_BestTime_to_Buy_and_Sell_Stock_Twice {

	public static class Solution1 {
		public static double buyAndSellStockTwice(List<Double> prices) {

			double maxTotalProfit = 0.0;
			List<Double> firstBuySellProfits = new ArrayList<>();
			double minPriceSoFar = Double.MAX_VALUE;

			// Forward phase. For each day, we record maximum profit if we
			// sell on that day.
			for (int i = 0; i < prices.size(); ++i) {
				minPriceSoFar = Math.min(minPriceSoFar, prices.get(i));
				maxTotalProfit = Math.max(maxTotalProfit, prices.get(i) - minPriceSoFar);
				firstBuySellProfits.add(maxTotalProfit);
			}

			// Backward phase. For each day, find the maximum profit if we make
			// the second buy on that day.
			double maxPriceSoFar = Double.MIN_VALUE;
			for (int i = prices.size() - 1; i > 0; --i) {
				maxPriceSoFar = Math.max(maxPriceSoFar, prices.get(i));
				maxTotalProfit = Math.max(maxTotalProfit, maxPriceSoFar - prices.get(i) +
			                                       firstBuySellProfits.get(i - 1));
			}
			return maxTotalProfit;
		}
	}
	
	
	public static void main(String[] args) {
		List<Double> price = Arrays.asList(7.0, 1.0 ,5.0, 3.0,  6.0, 4.0,10.0);
				
		System.out.println(Solution1.buyAndSellStockTwice(price));



	}
}
