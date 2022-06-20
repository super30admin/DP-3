package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {
    class Solution {
        public int deleteAndEarn(int[] nums) {
            if(nums.length == 1){
                return nums[0];
            }
            Map<Integer, Integer> map = new HashMap<>();
            int max = nums[0];
            for(int n: nums){
                map.put(n,map.getOrDefault(n,0)+n);
                max=Math.max(max,n);
            }
            if(map.size() ==1){
                for(int key: map.keySet()){
                    return map.get(key);
                }
            }
            int[] dp = new int[max+1];
            dp[0] = 0;
            dp[1] = map.getOrDefault(1,0);
            for(int i = 2;i<dp.length;i++){
                dp[i] = Math.max(dp[i-1], map.getOrDefault(i,0) + dp[i-2]);

            }

            return dp[max];
        }
    }
}
