// Time Complexity :O(n)
// Space Complexity :O(max value in input array)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach


class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int max = Integer.MIN_VALUE;

        for(int i = 0; i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }

        int[] dp = new int[max+1];

        for(int i=0;i<nums.length;i++){
            dp[nums[i]] = dp[nums[i]]+nums[i];
        }

        int skip = 0;
        int take = 0;

        for (int i=0;i<max+1;i++){
            int curr_skip = Math.max(skip,take);
            int curr_take = skip+dp[i];
            skip = curr_skip;
            take = curr_take;
        }

        return Math.max(skip,take);
    }
}
