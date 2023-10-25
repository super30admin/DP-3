// Time Complexity : O(n) + O(m) , n -> length of nums array , m -> maximum element
// Space Complexity : O(m)
class DeleteAndEarn {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 3, 3, 3, 4 };
        int result = deleteAndEarn(nums);
        System.out.println(result);
    }

    private static int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        // Pre-Processed Array
        int[] arr = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            arr[curr] += curr;
        }
        // House-Robber DP Array
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(dp[0], dp[1]);
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - 2]);
        }
        return dp[arr.length - 1];
    }
}