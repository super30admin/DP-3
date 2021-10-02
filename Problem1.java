// Time Complexity : O(max(N))
// Space Complexity : O(max(N))
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

public class Problem1 {

    public static int deleteAndEarn(int[] nums) {
        int[] dp = new int[getMax(nums) + 1];

        for(int x : nums)
            dp[x] += x;

        for (int i = 2; i < dp.length; ++i)
            dp[i] = Math.max(dp[i] + dp[i - 2], dp[i-1]);

        return dp[dp.length - 1];
    }

    public static int getMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int x : nums)
            max = Math.max(max, x);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{2,2,3,3,3,4})); // 9
    }
}
