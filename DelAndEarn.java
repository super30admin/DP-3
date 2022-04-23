// Time Complexity: O(max(n, max_element)) where n is the length of the array and max_element is the element with the highest value.
// Space Complexity: O(max_element) where max_element is the element with the highest value.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class DelAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for(int num: nums) {
            max = Math.max(max, num);
        }
        int[] dp = new int[max + 1];    // Array is filled with 0 where value is not present.
        for(int num: nums) {
            dp[num] = num + dp[num];    // Total of the same values is stored.
        }
        int skip = 0;
        int take = dp[0];
        for(int i = 1; i < dp.length; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + dp[i];
        }
        return Math.max(skip, take);
    }
}