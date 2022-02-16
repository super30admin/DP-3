/**
TC -  O(n) + O(m) where n is the length of an input array and m is the max element.
SC - O(n) where n is the maximum element in a input array.
**/

class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        
        for (int num: nums)
        {
            max = Math.max(max, num);
        }
        
        int arr[] = new int[max + 1];
        
        
        for(int i=0; i<nums.length; i++)
        {
            arr[nums[i]] += nums[i];
        }
        
        int dp[] = new int[max + 1];
        
        for (int i=0; i<=max; i++)
        {
            int select = arr[i] + (i-2 >= 0 ? dp[i-2] : 0);
            
            int notSelect = (i-1) >= 0 ? dp[i-1] : 0;
            
            dp[i] = Math.max(select, notSelect);
        }
        
        return dp[max];
    }
}