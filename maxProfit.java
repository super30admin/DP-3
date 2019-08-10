// Time Complexity : O(n)
// Space Complexity : O(n) n is the number of prices of stocks
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no





class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int res = 0;
        int value = prices[0];
        for(int i = 1; i < prices.length; i++){

            if(value < prices[i]){

               res = Math.max( res, prices[i] - value );

            }

            else{
                value = prices[i];
            }
        }

        return res;
    }
}