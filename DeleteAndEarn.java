public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        // TC: O(max item)
        // SC: O(maximum item in the nums array)

        if (nums == null || nums.length == 0)
            return 0;

        int max = Integer.MIN_VALUE;
        // find the max item in the nums array
        for (int num : nums) {
            max = Math.max(max, num);
        }
        // instatiate new array with the maximum element + 1 length
        int[] dp = new int[max + 1];
        // for each occurance of an item in the nums array, add the item into the new dp
        // array at the nums valued index which gives total sum of each item at that
        // particular index value
        for (int i = 0; i < nums.length; i++) {
            dp[nums[i]] = dp[nums[i]] + nums[i];
        }

        int skip = 0;
        int take = 0;

        for (int i = 1; i < dp.length; i++) {
            int tempSkip = skip;
            skip = Math.max(skip, take);
            take = tempSkip + dp[i];
        }
        return Math.max(skip, take);

    }
}
