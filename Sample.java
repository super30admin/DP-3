// Time Complexity : O(prices.length)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int maxDiff=0;
        int minFoundSoFar=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<minFoundSoFar){
                minFoundSoFar=prices[i];
            }
            else {
                int diff=prices[i]-minFoundSoFar;
                if(diff>maxDiff){
                    maxDiff=diff;
                }
            }
        }
        return maxDiff;
    }
}
