class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1)return 0;
        int maxP=0,min=9999;
       
        for(int i=0;i<prices.length;i++)
        {
            Math.min(min,prices[i]);
            Math.max(maxP,prices[i]-min);
        }
        return maxP;
    }
}