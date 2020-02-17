//Time Complexity: O(n)
//Space Complexity: O(n)

//LeetCode " Yes"

class Solution {
    public int deleteAndEarn(int[] nums) {
        //edge
        if(nums == null || nums.length ==0) return 0;
        int max = Integer.MIN_VALUE;
        //find the maximum value in the array
        for (int i = 0;i<nums.length;i++){
             max = Math.max(max,nums[i]);
        }
        //dp array with the size of the max+1
        int [] dp = new int[max+1];
        //fill dp array such that the value of an element increments in the corresponding index position in the dp array
        for (int i=0;i<nums.length;i++){
            dp[nums[i]] = dp[nums[i]]+nums[i];
        }
        int skip =0, take=0;
        
        //if you choose the skip update take with sum of skip and dp
        //if you choose takethe update take value with max of skip and take of the previous
        for (int i=1;i<dp.length;i++){
            int tskip = Math.max(skip,take);
            int ttake = skip + dp[i];
             skip = tskip;
             take = ttake;
        }
        return Math.max(skip, take);
    }
}