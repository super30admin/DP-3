//The approach here is to use bottom up approach using tabulation
//To solve this,we first organize the given data using bucket sort and then at each index, we check the maximum of the left or other left + current element
//In the end, we return the last value in dp array as the result
//Time Complexity: O(n)
//Space Complexity: O(n)
class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            max = Math.max(max, nums[i]);
        }
        int[] arr = new int[max+1];
        for(int i = 0; i<nums.length; i++){
            int cur = nums[i];
            arr[cur] = arr[cur]+ cur;
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(dp[0], arr[1]+0);
        for(int i = 2; i<arr.length; i++){
            dp[i] = Math.max(dp[i-1], arr[i] + dp[i-2]);
        }
        return dp[arr.length-1];
    }
}