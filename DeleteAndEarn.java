//Time Complexity: O(2^n)
//Space Complexity: O(1)
// Time Limit Exceeded Exception on leetcode

class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);

        return helper(nums, 0, Integer.MIN_VALUE, 0);
    }

    private int helper(int[] nums, int i, int prev, int sum) {
        if(i == nums.length) {
            return sum;
        }

        if(prev == nums[i]) {
            return helper(nums, i+1, prev, sum+nums[i]);
        }

        if(nums[i]+1 == prev || nums[i]-1 == prev) {
            return helper(nums, i+1, prev, sum);
        }

        return Math.max(helper(nums, i+1, 0, sum), helper(nums, i+1, nums[i], sum + nums[i]));

    }
}