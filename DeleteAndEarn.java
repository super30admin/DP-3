public class DeleteAndEarn {

  /**
   * Time Complexity : O(m+n)
   * Space Complexity : O(m*n)
   * Did this code successfully run on Leetcode : Yes
   *
   */

  private static int deleteAndEarn(int[] nums) {
    int n = nums.length;
    // Count the freq
    int countFreq[] = new int[10001];
    for (int i = 0; i < n; i++) {
      countFreq[nums[i]]++;
    }
    int dp[] = new int[10001];
    dp[10000] = countFreq[10000];
    // max stores the maximum value of points earned
    int max = dp[10000];

    // Traverse from 9999 to 1 and find the value of dp[i]
    for (int i = 9999; i >= 0; i--) {
      // Take this
      int taking;
      if (i + 2 <= 10000) {
        taking = (countFreq[i] * i) + dp[i + 2];
      } else {
        taking = (countFreq[i] * i);
      }
      // Do not take this
      int avoiding = dp[i + 1];
      // Assign the max value
      dp[i] = Math.max(taking, avoiding);
      // Update the max value
      max = Math.max(max, dp[i]);
    }

    // return the max earn
    return max;
  }

  public static void main(String[] args) {

    int nums1[] = { 3, 4, 2 };
    System.out.println(deleteAndEarn(nums1));

    int nums2[] = { 2, 2, 3, 3, 3, 4 };
    System.out.println(deleteAndEarn(nums2));
  }
}