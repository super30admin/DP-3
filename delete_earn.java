// Time Complexity : O(n)
// Space Complexity : O(n)+O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 


// Your code here along with comments explaining your approach: 
// first we are finding the max element and then initializing a new array of max element size.
// we are building new array such that we sum up the total occurances of each of the elements.
// now we are building a dp array. be considering the max of prev , present+ prev(prev) (i-2)
// the last element in the dp array gives the max value that needs to be returned.

class Solution {
    public int deleteAndEarn(int[] nums) {
        //null
        if(nums == null || nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
            max = Math.max(max,nums[i]);
        }
        int arr[] = new int[max+1];
        for(int i=0;i<nums.length;i++)
        {
            int val = nums[i];
            arr[val] = arr[val]+val;
        }
        int dp[] = new int[arr.length];
        dp[0] =0;
        dp[1]= Math.max(arr[0],arr[1]);
       
        for(int i=2;i<dp.length;i++)
        {
            dp[i]= Math.max(dp[i-1], arr[i]+dp[i-2]);
        }
        return dp[arr.length-1];
    }
}