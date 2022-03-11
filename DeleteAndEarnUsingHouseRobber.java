import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * Time complexity is O(max num)
 * space complexity is O(max num)
 */
class Solution {
    int[] dp;
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> numFreq = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            max = Math.max(num, max);
            int count = numFreq.getOrDefault(num, 0);
            numFreq.put(num, count+1);
        }
        
        int[] houses = new int[max+1];
        
        // Arrays.fill(houses, 0);
        
        for(int key : numFreq.keySet()) {
            houses[key] = key*numFreq.get(key);
        }
        return rob(houses);
    }
    
    private int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        
        return rob(nums, 0);
    }
    
    private int rob(int[] nums, int i) {
        if(i >= nums.length) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        // rob i
        int case1 = nums[i] + rob(nums, i+2);
        // don't rob i
        int case2 = rob(nums, i+1);
        
        dp[i] = Math.max(case1, case2);
        return dp[i];
        //return Math.max(case1, case2);
    }
}