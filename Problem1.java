public class Problem1 {
    //Time Complexity O(n*k)
    // Space Complexity O(K)
//    where n = nums.length, k = highest value from k
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        int[] dp = new int[max + 1];

        for (int num : nums) {
            dp[num] = dp[num] + num;
        }
        int skip = 0;
        int taken = dp[0];

        for (int i = 1; i < dp.length; i++) {
            int temp = skip;
            skip = Math.max(skip, taken);
            taken = temp + dp[i];
        }
        return Math.max(skip, taken);
    }
}
