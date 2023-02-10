//DP
//TC: O(n)
//SC: O(n)
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
         if(n == 1) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
       
        for(int i=2; i< n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
}


//DP
//TC: O(n)
//SC: O(1)
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        // int[] dp = new int[n];
        if(n == 1) return nums[0];
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);
      
       
        for(int i=2; i< n; i++){
            int temp = curr;
            curr = Math.max(curr,prev+nums[i]);
            prev = temp;
        }
        return curr;
    }
}
