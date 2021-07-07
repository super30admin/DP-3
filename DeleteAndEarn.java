//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes  
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
/*
 * This problem states that whenever we choose a number for maximizing our points, the adjacent numbers i.e. i-1 and i+1 numbers should not 
 * be included. So, instead of iterating over the given array again and again for validating if the number should be included or not, 
 * a dp array is being created. The dp array will hold elements upto the maximum number in original array.
 * dp array is updated by iterating over original array. Now, this problem boils down to the house robber problem wherein we cannot consider 
 * adjacent elements.
 */

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        // finding maximum element in the nums array
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        // creating an auxiliary array of length maximum found above
        int[] dp = new int[max+1];
        for(int i = 0; i < nums.length; i++) {
            dp[nums[i]] += nums[i];
            
        }
        // solving the two cases when we either skip a number or choose a number
        int[][] dpNew = new int[dp.length][2];
        for(int i = 1; i < dpNew.length; i++) {
            dpNew[i][0] = Math.max(dpNew[i-1][0], dpNew[i-1][1]);
            dpNew[i][1] = dp[i] + dpNew[i-1][0];
        }
        return Math.max(dpNew[dpNew.length-1][1], dpNew[dpNew.length-1][0]);
    }
}