public class Solution
	{
        // Time Complexity : O(n) + O(max(n))
        // Space Complexity : O(1)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        public int DeleteAndEarn(int[] nums)
        {
            if (nums == null || nums.Length == 0)
                return 0;
            int max = int.MinValue;
            foreach (var num in nums)
            {
                max = Math.Max(num, max);
            }
            int[] arr = new int[max + 1];
            foreach (var num in nums)
            {
                arr[num] += num;
            }
            //house robber pattern
            int prev = arr[0];
            int curr = arr[1];
            for(int i = 2; i < arr.Length; i++)
            {
                int temp = curr;
                curr = Math.Max(curr, prev + arr[i]);
                prev = temp;
            }
            return curr;
        }
    }
