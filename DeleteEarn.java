package com.example.problems;
//Time Complexity : O(N^2)
//Space Complexity : O(N^2)
//Did this code successfully run on Leetcode : yES
//Any problem you faced while coding this :nO


public class DeleteEarn {
	public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] values = new int[n];
        for (int num : nums)
            values[num] += num;

        int take = 0, skip = 0;
        for (int i = 0; i < n; i++) {
            int takei = skip + values[i];
            int skipi = Math.max(skip, take);
            take = takei;
            skip = skipi;
        }
        return Math.max(take, skip);
    }
}
