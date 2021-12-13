// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We take max element from nums array and decalre new array of size max.
 * In this new array (lets say temp) we keep total of elements in nums such that temp[i] = temp[i] + i;
 * In our dp array, we calculate the cost by choosing current row as well as not choosing current row.
 * not choosing current row = max between previous row values
 * Choosing current row = previous row not choosing + current row choosing.
 * This way we calculate for all rows.
 * finally, we return value which is maximum in last row. 
*/


class Solution {
    public int deleteAndEarn(int[] nums) {
       
        int max_ele = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length;i++){
            max_ele = Math.max(max_ele, nums[i]);
        }
        int[] temp = new int[max_ele + 1];
        
        for(int i = 0; i < nums.length;i++){
            temp[nums[i]] += nums[i]; 
        }
        
        int[][] dp = new int[temp.length+1][2];
        
        for(int r = 1; r < dp.length;r++){
            dp[r][0] = Math.max(dp[r-1][0], dp[r-1][1]);
            dp[r][1] = dp[r-1][0] + temp[r-1];
        }
    
        return Math.max(dp[dp.length -1][0] , dp[dp.length-1][1]);
    }
    
    
}