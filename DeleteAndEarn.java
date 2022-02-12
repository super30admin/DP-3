// Time Complexity: O(n) where n is the max value in nums
// Space Complexity: O(n) where n is the max value in nums
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: Find the max value in nums by iterating over it. Create an array and 
// fill it with the frequency*element values. Then we start calculating the max value 
// between earning previous position or earning previous to previous and including current value.

// LC- 740 Delete and Earn

class DeleteAndEarn {
  public int deleteAndEarn(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int max = 0;

    for (int n : nums) {
      max = Math.max(max, n);
    }

    if (max == 1) {
      return nums.length;
    }

    int[] dp = new int[max + 1];
    for (int n : nums) {
      dp[n] = n + dp[n];
    }

    for (int i = 2; i < max + 1; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + dp[i]);
    }

    return dp[max];
  }
}