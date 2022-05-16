// Time Complexity :O(n)+O(m) where n is no of elements in given array and m is maximum element among the array
// Space Complexity :O(m)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {// we will create an array of size maximum number among array and will insert
                // total value of number in d=same index for eg if we have 3 , three times,
                // we'll store 9 in our array and this problem will be converted to house robber
                // problem
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length < 2) {
            return nums[0];
        }
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] dp = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[nums[i]] += nums[i];

        }
        int choose = dp[0];
        int notChoose = Math.max(dp[0], dp[1]);
        for (int i = 2; i < dp.length; i++) {
            int temp = choose;
            choose = notChoose;
            notChoose = Math.max(notChoose, temp + dp[i]);
        }
        return Math.max(choose, notChoose);
    }
}