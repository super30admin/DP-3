import java.util.*;

public class DeleteAndEarn {
    // TC: O(N) where N is the length of nums
    // SC: O(N) where N is the maximum number in nums array
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxNum = Integer.MIN_VALUE;
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + n);
            maxNum = Math.max(maxNum, n);
        }

        int[] dp = new int[maxNum + 1];
        dp[1] = map.getOrDefault(1, 0);
        for (int i = 2; i < dp.length; i++) {
            int gain = map.getOrDefault(i, 0);
            dp[i] = Math.max(dp[i - 1], gain + dp[i - 2]);
        }
        return dp[maxNum];
    }
}
