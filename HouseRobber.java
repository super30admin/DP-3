// Time Complexity : O(number of houses)
// Space Complexity : O(number of houses)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class HouseRobber {
    // Time: O(number of houses)
    // Space: O(number of houses)
    public int rob(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        int n = nums.length; // length of house

        int[] dp = new int[n];
        // if there is only 1 element
        if(n == 1) return nums[0];
        dp[0] = nums[0]; // is there is only 1 element that will be the robbed amount

        // if there are only 2 elements
        if(n == 2) return Math.max(nums[1], nums[0]);
        dp[1] = Math.max(nums[1], nums[0]); // if 2 houses then take the max look of the two

        for(int i = 2; i < nums.length; i++) {
            //  we will start from index 2, because all of before is taken
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        return dp[n-1];
    }
}
