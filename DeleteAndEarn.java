// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach: DP Array

class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] dp = new int[10001];
        
        for (int num : nums) {
            dp[num] += num;
        }
    
        int prevMax = 0, currMax = 0;
        for (int i = 1; i < dp.length; i++) {
            int temp = currMax;
            currMax = Math.max(prevMax + dp[i], currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
