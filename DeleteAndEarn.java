// Time Complexity : O(N) : O(n) + O(max(nums)) where n is length of nums
// Space Complexity : O(N) : means O(max(nums)), we do this in O(1) using three vars, prev, curr and temp in the optimized solution 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, playing around with the indices

/*Approach:
Find out the max value in nums. Using this we build an array of size max+1
We keep storing the sums of the distinct earnings at the respective indices.
Now this probel is exactly same as house robber. So we apply DP.
*/
class Solution DeleteAndEarn{
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int num: nums){
            max = Math.max(max, num);
        }
        int[] dp = new int[max + 1];
        for (int num : nums){
            dp[num] += num;
        }
        for (int i = 2; i <=max ; i++){
            dp[i] = Math.max(dp[i-1],(dp[i-2] + dp[i]));
        }
        return dp[max];
    }

    public int optimizeddeleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int num: nums){
            max = Math.max(max, num);
        }
        int[] dp = new int[max + 1];
        for (int num : nums){
            dp[num] += num;
        }
        int prev = dp[0];
        int curr = dp[1];
        for (int i = 2; i < dp.length ; i++){
            int temp =curr;
            curr = Math.max(curr,(prev + dp[i]));
            prev = temp;
        }
        return curr;
    }
}