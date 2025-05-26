/*
  Time complexity: O(m+n)
  Space complexity:O(m+n)

  Code ran successfully on leetcode: Yes

  Approach: The array arr is formed such that the numbers of nums are used as index in arr and the value being product of frequency with the number.
*/

using System.Linq;

public class Solution {
    public int DeleteAndEarn(int[] nums) {
        int[] arr = new int[nums.Max()+1];

        for(int i=0;i<nums.Length;i++)
        {
            arr[nums[i]]+=nums[i];
        }

        if(arr.Length==1) return arr[0];
        if (arr.Length==2) return Math.Max(arr[0],arr[1]);

        int prev = arr[0];
        int curr = Math.Max(arr[0],arr[1]);

        for(int i=2;i<arr.Length;i++)
        {
            int temp = curr;
            curr = Math.Max(prev+arr[i],curr);
            prev = temp;
        }

        return curr;
    }
}
