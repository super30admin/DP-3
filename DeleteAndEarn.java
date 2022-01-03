class Solution {
    // Time Complexity : O(n + max(n)), where n is the no of elements in the arr and max(n) is the max element in the arr.
    // Space Complexity : O(max(n))
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        //first find the max element in the array
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        //create a freq arr that will store freq of each element upto the max element
        int[] freq = new int[max+1];
        for(int i = 0; i < nums.length; i++) {
            freq[nums[i]] += 1;
        }
        //create a dp array that will have rows equal to max+1 elements and col as 2 (for skip and take)
        int[][] dp = new int[max+1][2];
        for(int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]); //if not taking the element, then take max
            //of prev element skip or take values
            dp[i][1] = dp[i-1][0] + freq[i]*i; //if taking that element, then take prev element skip value
            //and val of curr element from freq arr
        }
        return Math.max(dp[max][0], dp[max][1]);
    }
}