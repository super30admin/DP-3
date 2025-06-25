// DP
// First, gather all values into buckets where arr[i] holds total value of number i. 
// Then use dynamic programming, where each dp[i] tells us the max points we can get using up to number i.
// It's similar to house robber problem — you either take i and skip i-1, or skip i and take dp[i-1].
// Time Complexity - O(n + k), where: n = length of input array (to build frequency map), k = max number in the array (to fill dp from 0 to max)
// Space Complexity - O(k), where k = max number in input for both arr[] and dp[] arrays

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num: nums){
            max = Math.max(max, num);
        }
        int[] arr = new int[max+1];
        for(int num: nums){
            arr[num] += num;
        }
        int[] dp = new int[max+1];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for(int i=2; i<=max; i++){
            dp[i] = Math.max(dp[i-1], arr[i]+dp[i-2]);
        }
        return dp[max];
    }
}