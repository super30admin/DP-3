//This problem was asked at Amazon
//
//
//
//        For an array nums of integers, For each iteration, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 and nums[i] + 1.
//
//        You start with 0 points. Return the maximum number of points you can earn.
//
//        Example 1:
//
//        Input: nums = [3, 4, 2]
//
//
//
//        Output: 6

// Time Complexity : O(n+m)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach


class Solution {
    public int deleteAndEarn(int[] nums) {

        //edge
        if (nums.length == 0)
            return 0;

        int[] values = new int[10001];
        for (int num : nums)
            values[num] += num;

        int prev1 = 0;
        int prev2 = 0;

        for (int value : values) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + value, prev1);
            prev2 = tmp;
        }
        return prev1;
    }
}