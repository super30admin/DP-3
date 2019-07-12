class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1)return 0;
        
        int max=0;
        for(int i=0;i<prices.length;i++)
        {
           for(int j=i+1;j<prices.length;j++) 
           { if(prices[i]<prices[j] && max<(prices[j]-prices[i])){ max=prices[j]-prices[i];}}
        }
        return max;
    }
}