// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int maxn = nums[0];
        for (int num : nums){
            maxn = Math.max(num, maxn);
        }

        int[] arr = new int[maxn+1];
        for (int num : nums){
            arr[num] += num;
        }
        //recusrive approach - TLE
        //return helper(arr, 0, 0); 

        int[] dp = new int[maxn+1];
        dp[0] = arr[0];
        dp[1] = Math.max(dp[0], 0+arr[1]);
        for (int i =2;i<maxn+1;i++){
            dp[i] = Math.max(dp[i-1], arr[i]+dp[i-2]);
        }
        return dp[maxn];


        // space oprimization - without dp array
        // int prev = arr[0];
        // int curr = arr[1];

        // for (int i = 2;i<arr.length;i++){
        //     int temp = curr;
        //     curr = Math.max(curr, prev+arr[i]);
        //     prev = temp;
        // }
        // return curr;
    }

    private int helper(int[] nums, int idx, int sum){
        //base
        if (idx >= nums.length) return sum;

        // choose
        int case1 = helper(nums, idx+2, sum+nums[idx]);
        // not to chosse
        int case2 = helper(nums, idx+1, sum);
        return Math.max(case1,case2);
    }
}