// TC: O(N) - O(max(N, maxElement)) : N-> nums.length, maxElement ->maximum Element of nums array 
// SC: O(maxElement), maxElement -> maximum Element of nums array
// Did it run successfully on Leetcode? : Yes
class Solution {
    public int deleteAndEarn(int[] nums) {
       if ( nums == null || nums.length == 0)
           return 0;
       int max = 0;
       for (int n : nums)
       {
           max = Math.max(max, n);
           
       }
      int arr[] = new int[max+1];
      for ( int i = 0; i < nums.length ; i++)
      {
         arr[nums[i]] = arr[nums[i]] + nums[i];
      }
    
      int use = 0;
      int skip = arr[0];
      for ( int i = 1; i < arr.length; i++)
      {
          int temp = skip;
          skip = Math.max(use, skip);
          use = temp + arr[i];
      }
        return Math.max(skip, use);
    }
}
