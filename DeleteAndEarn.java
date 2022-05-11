// Time Complexity :O(n+min(k,n*(log n))) n is length of nums, k is max ele in nums
// Space Complexity :O(N)
import java.util.HashMap;

class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int max = 0;
        for (int i = 0 ; i < nums.length; i++) {
            if (map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);
            max = Math.max(max, nums[i]);
        }
        int[] dp = new int[max + 1];
        dp[0] = 0;
        dp[1] = map.containsKey(1) ? map.get(1) : 0;
        int res = dp[1];

        for (int i = 2 ; i <= max ; i++) {
            int mapVal = map.containsKey(i) ? map.get(i) * i : 0;
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + mapVal);
            res = Math.max(res, dp[i]);
        }
        
        return res;
        
    }
}