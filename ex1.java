//Time Complexity = O(m + n) and Space Complexity = O(m)
//where m is the maximum element in nums array and 
//n is the length of nums array given in the delete and earn problem.
class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int freq[] = new int[10001];
        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }
        int dp[] = new int[10001];
        dp[10000] = freq[10000];
        int max = dp[10000];
        for (int i = 9999; i >= 0; i--) {
            int taking;
            if (i + 2 <= 10000) {
                taking = (freq[i] * i) + dp[i + 2];
            } else {
                taking = (freq[i] * i);
            }
            int notTaking = dp[i + 1];
            dp[i] = Math.max(taking, notTaking);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}