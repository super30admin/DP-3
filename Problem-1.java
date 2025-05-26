// Time complexity - O(n)
// Space complexity - O(n)
// Did you solve on leetcode - yes
// Did you face any Problem - No
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            max = Math.max(max, nums[i]);
        } 
        int updatednums[] = new int[max + 1];
        for(int i=0;i<nums.length;i++) {        
            updatednums[nums[i]] += nums[i];
        } 

        int[] memo = new int[updatednums.length];
        Arrays.fill(memo, -1);
        return helper(updatednums,0, memo);
    }

    public int helper(int[] nums, int index, int[] memo) {
        if (index >= nums.length) return 0;
        if(memo[index] != -1) return memo[index];
        int rob = nums[index] + helper(nums, index+2, memo);
        int notRob = helper(nums, index+1, memo);
        memo[index] = Math.max(rob, notRob);
        return memo[index];
    }
}
