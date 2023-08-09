// TC : O(n) +O(max(n))
// SC:O(max(n))

class Solution {
    public int deleteAndEarn(int[] nums) {

        if(nums== null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int max = nums[0];


        for(int i =0; i< nums.length; i++) {
            if(nums[i] > max)
                max = nums[i];
        }

        int[] dp = new int[max+1];

        for(int i =0; i<nums.length; i++) {
            dp[nums[i]] = dp[nums[i]] +nums[i];
        }

        int prev = dp[0];
        int curr = Math.max(dp[0], dp[1]);

        //dp can be used now
        for(int i =2; i<dp.length; i++) {
            int temp = curr;
            curr = Math.max(curr, dp[i] + prev);
            prev = temp;
        }

        return curr;

    }
}