/*
* Time complexity is O(Math.max(nums.length, max element in )) as we are iterating nums array for filling DP and then DP array having max of nums as length
Space complexity: O(max from nums) used by DP array
Approach: So here we are heading toward the approach of Dp to chosse an element or not chosse element it is same as hose robber as here also we aren't allowed to select adjacent elements
but before going to that we need to have adding of all recurring numbers so we creat an array to store sum of all the numbers
*/
class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;

        for(int num : nums){
            max = Math.max(max, num);
        }

        int dp[] = new int[max + 1];

        for (int num : nums) {
            dp[num] += num;
        }

        int skip = 0, take = dp[0];
        for(int i = 1; i< dp.length; i++) {
            int tempSkip = skip;
            skip = Math.max(skip, take);
            take = dp[i] + tempSkip;
        }

        return Math.max(skip, take);
    }
}