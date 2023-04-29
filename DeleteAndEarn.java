// Time Complexity : O(n) + O(max)
// Space Complexity : O(max)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * We realized that recurrsion has 2 problem with given array: 1. it is not sorted and thus we wont know how
 * much that value contributes and 2. to find adjacent we will have to traverse. So we find the max element and 
 * create array of length max + 1. And fill this array such that each index says how much that value contributes.
 * we use Array as its contiguous and adj. conditions can be taken care of not selecting nums[i] - 1 and nums[i] + 1 if we select nums[i].
 * Then same as house robber. 
 */

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            max = Math.max(max, num);
        }

        int[] dp = new int[max + 1];
        for(int i = 0; i < nums.length; i++) {
            int index = nums[i];
            dp[index] = dp[index] + nums[i];
        }

        int skip = 0;
        int take = dp[0];
        for(int i = 1; i < max + 1; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + dp[i];
        }
        return Math.max(take, skip);
    }
}
