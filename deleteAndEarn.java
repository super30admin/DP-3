/**
Problem: https://leetcode.com/problems/delete-and-earn/
TC: O (Max(n, max element))
SC: O(1)
*/

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        for (int n : nums) {
            max = Math.max(max, n);
        }
        
        int dp[] = new int[max + 1];
        for (int n : nums) {
            dp[n] += n;
        }
        
        int skip = 0, take = dp[0];
        for (int i = 1; i < dp.length; ++i) {
            int tempSkip = skip;
            skip = Math.max(skip, take);
            take = tempSkip + dp[i];
        }
        return Math.max(skip, take);
    }
}

/**
- Extension of house robber
	- https://leetcode.com/problems/house-robber/
	- https://github.com/Vaishnavik22/DP-1
	- To print chosen numbers, see https://github.com/Vaishnavik22/DP-1/blob/master/houseRobberPrintChosenHouses.java
*/