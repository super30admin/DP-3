/*
Alternative approach: Remember house robber?
Go through that problem before reading this alternative approach.
if you some how convert the array into house robber problem array then it is simple.
Try to get the max element and create an array of size max ele.
Then for the elements present in the given array put the ele  freq[i] in the new array and for the
 rest put 0. Then now you can safely assume that it is house robber problem.

*/

// Approach: Here we are sorting the array and will start from the first element. the two while loops
// below will add all the current element to the sum and curr+1 ele to the sum and then we move to
// the next index. Observe the "nextidx" parameter.

// TC: O(n)
// SC: O(n)




class Solution {
  public int deleteAndEarn(int[] nums) {
    Arrays.sort(nums);
    int[] dp = new int[nums.length];
    return solve(nums, nums.length, 0, dp);
  }

  private int solve(int[] nums, int n, int idx, int[] dp) {

    if(idx >= n)
      return 0;


    int nextidx = idx;
    int val = nums[idx];
    int sum = 0;

    // Adding all the same elements to sum.
    while(nextidx < n && nums[nextidx] == val) {
      sum += nums[nextidx];
      nextidx++;
    }
    // since we need to add all the duplicate elements to the sum increase the idx. i.e skipping all i+1 elements.
    while(nextidx < n && nums[nextidx] == val+1)
      nextidx++;

    if(dp[idx] != 0)
      return dp[idx];

    // either you pick or you skip
    int pick = sum +solve(nums, n, nextidx, dp);
    int notpick = solve(nums, n, idx+1, dp);

    return dp[idx] = Math.max(pick, notpick);
  }
}