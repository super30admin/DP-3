// Time Complexity : O(n)
// Space Complexity : O(n) -> O(n) for creating arr, O(n) to create a DP from arr
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
    //None

// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        
        //base case
        if(nums == null || nums.length == 0){
            return 0;
        }

        //find max elements
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        int[] arr = new int[max + 1];
        //fill arr
        for(int i = 0; i < nums.length; i++){
            arr[nums[i]] = arr[nums[i]] + nums[i];
        }
        
        //2D DP matrix
        int[][] dp = new int[arr.length][2];
        //Initialize first row
        dp[0][0] = 0;
        dp[0][1] = arr[0];

        //staring from first index
        for(int i = 1; i < arr.length; i++){
            //case 0 should be filled with Max of previous values of either picking or not picking the current point
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            //case 1 will be not picking the previous point + amount obtained by picking the current point
            dp[i][1] = dp[i-1][0] + arr[i];
        }

        //returning the maximum between both the columns of last row
        return Math.max(dp[arr.length - 1][0], dp[arr.length - 1][1]);


    }
}