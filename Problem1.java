
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


class Solution {
/* Brute force solution - find max for all combinations
// Time complexity: O(N^2)
// Space complexity: O(1)
   public int maxProfit(int[] prices)
   {  
    if(prices.length <= 1) //base case
            return 0;
    int max = 0;
        
       //compare next element with previous for all combinations
    for(int i = 0; i < prices.length - 1; i++)
    {
        for(int j = i + 1; j < prices.length; j++)
        {
            if(prices[j] - prices[i] > max)
                max = prices[j] - prices[i];
        }
    }
        
    return max;
} */

//Optimised solution
//Time complexity: O(n)
//Space complexity: O(n)
//Approach: Have a local min and max, check if current price-min > max, if yes update max. Else keep finding the next min
  public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i =0;i<prices.length;i++){
            if(prices[i]-min>max){
                max = prices[i]-min;
            }
          
            min = Math.min(prices[i],min);
        }
        return max;
    }

}
