package com.changhun.z.array;
/**
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction 
(i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

Intuit
easy

 * @author changhun
 *
 */
public class L121_BestTime_to_Buy_and_Sell_Stock1 {
	/**
	 * We need to find out the maximum difference (which will be the maximum profit) 
	 * between two numbers in the given array. 
	 * Also, the second number (selling price) must be larger than the first one (buying price).

In formal terms, we need to find max(prices[j]−prices[i]), for every i and j such that j>i. 
	 *
	 * Time complexity : O(n^2). Loop runs n(n−1)/2 times.
	 * Space complexity : O(1). Only two variables maxprofit and profit are used.
	 * 
	 * @author changhun
	 *
	 */
	public static class Solution1 {
	    public static int maxProfit(int prices[]) {
	        int maxprofit = 0;
	        for (int i = 0; i < prices.length - 1; i++) { // 0 ~ (n-1)
	            for (int j = i + 1; j < prices.length; j++) { // 1 ~ n
	                int profit = prices[j] - prices[i];
	                if (profit > maxprofit)
	                    maxprofit = profit;
	            }
	        }
	        return maxprofit;
	    }
	}
	
	/**
	 * The points of interest are the peaks and valleys in the given graph. 
	 * We need to find the largest peak following the smallest valley. 
	 * We can maintain two variables - minprice and maxprofit corresponding to the smallest valley and maximum profit 
	 * (maximum difference between selling price and minprice) obtained so far respectively.
	 * 
	 * Time complexity : O(n). Only a single pass is needed.
	 * Space complexity : O(1). Only two variables are used.
	 * @author changhun
	 *
	 */
	public static class Solution2 {
	    public static int maxProfit(int prices[]) {
	        int minprice = Integer.MAX_VALUE;
	        int maxprofit = 0;
	        for (int i = 0; i < prices.length; i++) {
	            if (prices[i] < minprice)
	                minprice = prices[i];
	            else if (prices[i] - minprice > maxprofit)
	                maxprofit = prices[i] - minprice;
	        }
	        return maxprofit;
	    }
	}
	
	public static class Solution3 {
		public static int maxProfit(int[] prices) {
			int minPrice = Integer.MAX_VALUE;
			int maxProfit = 0;
			for (int i = 0; i < prices.length; i++) {
				if (prices[i] < minPrice) 
					minPrice = prices[i];
				else if (prices[i] - minPrice > maxProfit)
					maxProfit = prices[i] - minPrice;
			}
			return maxProfit;
		}
	}
	
	
	public static void main(String[] args) {
		int [] price1 = {7,1,5,3,6,4};
		int [] price2 = {7,6,4,3,1};
				
		System.out.println(Solution1.maxProfit(price1));
		System.out.println(Solution2.maxProfit(price1));

		System.out.println(Solution1.maxProfit(price2));
		System.out.println(Solution2.maxProfit(price2));
	}
}
