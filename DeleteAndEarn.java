public class DeleteAndEarn {
    // Time complexity: O(max of(nums.length, dp.length)
    // Space complexity: O(nums.length)
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int max = 0;

        // First we need to find out a maximum element from the input array

        for(int num : nums) {
            max = Math.max(max,num);
        }

        // Use this value to create a DP array of size max + 1
        int[] dp = new int[max + 1];

        // Store the summation at an index in dp which is equal to the input array element
        for(int num : nums) {
            dp[num] = dp[num] + num;
        }

        // skip denotes skipping the current summation (total points by adding a specific point. eg, 4 by adding 2 twice)
        int skip = 0;

        // take denotes considering the current summation (total points by adding a specific point. eg, 4 by adding 2 twice)
        int take = dp[0];
        for(int i=1; i < dp.length;i++){
            int temp = skip;
            skip = Math.max(skip,take);
            take = temp + dp[i];
        }

        return Math.max(skip,take);
    }
}
