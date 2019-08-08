/*
Time Complexity :O(n)- Need to traverse entire array
Space Complexity :I think its O(1), as i am just using 3 variables
Did this code successfully run on Leetcode : Yes
Output from Leetcode: "Runtime: 0 ms, faster than 100.00% of Java online submissions for Best Time to Buy and Sell Stock.
Memory Usage: 35.8 MB, less than 100.00% of Java online submissions for Best Time to Buy and Sell Stock"

Any problem you faced while coding this : Few conditions were missed during whiteboard coding, 
but as Test Cases failed those conditions were added accordingly


Your code here along with comments explaining your approach
 * */
class Solution {
    public static int maxProfit(int[] prices) {
        //Initialize the buy var to maximum value
        int buy= Integer.MAX_VALUE;
        int sell=0, profit=0;
        //Interate over the array, set the buy value to prices value
        //if the existing buy value is greater.
        for(int i=0; i< prices.length; i++){
            if(buy> prices[i]){
                buy=prices[i];
                //Need to reset the value of sell, as buy's value is changing
                //Condition: cannot set sell before buy
                sell=0;
            }else{ //Set the sell value if the existing sell value is lesser than prices array value
                if(sell < prices[i]){
                    sell = prices[i];
                    //Calulate or update the profit if existing value is less
                    if(profit < sell-buy) profit = sell-buy; 
                }
            }  
        }
        return profit;   
    }
    
    public static void main(String[] args) {
    		int[] prices= {2,1,2,1,0,1,2};
    		System.out.println("Profit earned: "+maxProfit(prices) );
    }
}