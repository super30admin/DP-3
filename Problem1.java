// Time Complexity : O(n2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 0; i< prices.length; i++){
            for(int j = i+1; j< prices.length; j++){
                if(prices[i]<prices[j]){
                    if (prices[j] - prices[i] > maxProfit){
                        maxProfit = prices[j] - prices[i];
                    }    
                }
            }
        }
        return maxProfit;
    }
}