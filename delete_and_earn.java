// Time Complexity :O(max(nums.length,max value in num))
// Space Complexity :O(max(value in nums))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {

  public int deleteAndEarn(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int[] dp = new int[getMax(nums) + 1];

    //we keep on adding the sums to the dp array.
    for (int x : nums) {
      dp[x] += x;
    }

    int choose = 0, dchoose = 0;
    //Instead of deleting the values, we simply swap the values
    for (int x : dp) {
      int temp = dchoose;
      dchoose = Math.max(choose, dchoose);
      choose = temp + x;
    }
    return Math.max(choose, dchoose);
  }

  private int getMax(int[] nums) {
    int max = Integer.MIN_VALUE;
    for (int x : nums) {
      max = Math.max(max, x);
    }
    return max;
  }
}
//[2,2,3,3,3,4]
