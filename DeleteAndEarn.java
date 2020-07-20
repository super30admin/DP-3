// Time Complexity : O(m+n) m is the length of input array, n is the range of the value of each element
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//Similar to House robber problem. Here store the sums of each occurrences in an array


class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
	        for (int num : nums) {
	            count[num] += num;
	        }
        int[] dp = new int[10001];
	        dp[1] = count[1];
	        for (int i = 2; i < count.length; i++) {
	            dp[i] = Math.max(dp[i - 1], dp[i - 2] + count[i]);
	        }
        return dp[10000];
    }
}