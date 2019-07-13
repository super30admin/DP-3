class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1)return 0;
        int maxP=0,min=9999;
       
        for(int i=0;i<prices.length;i++)
        {
            if(min>prices[i]){min=prices[i];}
            else if(prices[i]-min>maxP){maxP=prices[i]-min;}
        }
        return maxP;
    }
}