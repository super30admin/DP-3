using System;
using System.Collections.Generic;
using System.Text;

namespace DynamicProgramming
{
    public class DeleteAndEarn
    {
        /*
         * T.C: max(n, maxnumber) where n is length of nums and maxnumer is maximum number in a array e.g [3,2,5] max num: 5 
         * S.C: O(maxnumber)
         * */
        public int GetMAxDeleteAndEarn(int[] nums)
        {
            int max = 0;
            foreach (var num in nums)
            {
                max = Math.Max(num, max);
            }
            //Console.WriteLine(max);
            int[] dp = new int[max + 1];

            for (int i = 0; i < nums.Length; i++)
            {
                //Console.WriteLine(nums[i]);
                dp[nums[i]] = dp[nums[i]] + nums[i];
            }


            int skip = 0;
            int take = dp[0];

            for (int i = 1; i < dp.Length; i++)
            {
                int temp = skip;
                skip = Math.Max(skip, take);
                take = temp + dp[i];
                Console.WriteLine(skip + ":" + take);
            }

            return Math.Max(skip, take);
        }
    }
}
