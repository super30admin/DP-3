// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class BuySellStock {

    public int maxProfit(int[] prices) {
        int profit = 0;
        if(prices.length == 0) return 0;
        if(prices.length == 1) return prices[0];

        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<prices.length;i++){
          if(prices[i] < min){
              min = prices[i];
          }
          else if(prices[i] - min > profit)
            profit = prices[i] - min;
        }

        return profit;   
    }
    public static void main(String[] args){
        System.out.println("BuySellStock");
        int[] prices = {7,1,5,3,6,4};
        BuySellStock obj = new BuySellStock();
        System.out.println(obj.maxProfit(prices));
    }
}