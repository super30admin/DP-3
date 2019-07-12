// Time Complexity :O(n) --> beacuse of for loop
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class BuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int profit = 0,buy = prices[0];
        for(int i =1;i<prices.length;i++){
            if(prices[i]-buy>profit)
                profit = prices[i]-buy;
            else if(prices[i]<buy)
                buy = prices[i];
        }
        return profit;
    }
    public static void main(String[] args) {
        int [] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
