//tc=O(n) +  O(max)
//sc=O(max)
class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            max = max < nums[i] ? nums[i] : max;
        }

        int[] dp = new int[max+ 1];
        for(int i = 0; i < nums.length; i ++) {
            int index = nums[i];
            dp[index] = dp[index] + index;
        }

        int skip = 0;
        int take =dp[0]; 

        for (int i = 1; i < max +1; i++) {
            int temp = skip;            
            skip = Math.max(skip, take);
            take = dp[i] + temp;           
        }

        return Math.max(skip, take);
             
    }
}