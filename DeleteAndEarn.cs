using System;
using System.Collections.Generic;
using System.Text;

namespace LeetCodeSuper30
{
    class DeleteAndEarnLC
    {
        //Time Complexity: O(n) +  O(max of nums) = O(n)
        //Space Complexity: O(max)
        public int DeleteAndEar(int[] nums)
        {
            if (nums == null || nums.Length == 0)
            {
                return 0;
            }
            int max = 0;
            foreach (int num in nums)
            {
                max = Math.Max(max, num);
            }
            int[] dp = new int[max + 1];
            foreach (int num in nums)
            {
                dp[num] += num;
            }
            int skip = 0, take = dp[0];
            for (int i = 1; i < dp.Length; i++)
            {
                int temp = skip;
                skip = Math.Max(skip, take);
                take = temp + dp[i];
            }
            return Math.Max(skip, take);
        }
    }
}
