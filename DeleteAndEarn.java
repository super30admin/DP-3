class Solution {
    public int deleteAndEarn(int[] nums) {
        // Check if the input array is null or empty
        if (nums == null || nums.length == 0)
            return 0;
        
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        // Find the maximum element in the input array
        for (int i = 0; i < n; i++)
            max = Math.max(max, nums[i]);

        // Create an array dp to store the sums of elements with the same value
        int[] dp = new int[max + 1];

        // Populate the dp array with the sums of elements with the same value
        for (int i = 0; i < n; i++) {
            int index = nums[i];
            dp[index] += nums[i];
        }

        int skip = 0;
        int take = dp[0];

        // Calculate the maximum score by considering skipping or taking each value
        for (int i = 1; i < dp.length; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + dp[i];
        }
        // Return the maximum score between skip and take
        return Math.max(skip, take);
    }
}

// Time Complexity: O(N) + O(max), where N is the length of the input array, and max is the maximum value in the input array.
// Space Complexity: O(max), as we create an array dp with a size of max+1.
