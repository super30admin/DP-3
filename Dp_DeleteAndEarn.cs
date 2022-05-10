using System;
namespace Algorithms
{
    public class Dp_DeleteAndEarn
    {
        /// Time Complexity : O(N)  + O(Max(n))
        // Space Complexity :O(Max(n)) 
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No
        public int DeleteAndEarn(int[] nums)
        {
            int max = 0;
            foreach (int num in nums)
            {
                max = Math.Max(max, num);
            }
            int[] arr = new int[max + 1];
            foreach (int num in nums)
            {
                arr[num] += num;
            }
            int choose = arr[0];
            int noChoose = arr[1];

            for (int i = 2; i < arr.Length; i++)
            {
                int temp = choose;
                choose = Math.Max(choose, noChoose);
                noChoose = temp + arr[i];
            }
            return Math.Max(choose, noChoose);
        }
    }
}
