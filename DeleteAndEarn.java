//Time Complexity: O(n + maxValue)
//Space Complexity: O(n+maxValue)
// ** Leetcode: #740. Delete and Earn 
// Question has a type-> It is AND not or->After, you must delete every element equal to nums[i] - 1 AND nums[i] + 1.
class Solution {
    public int deleteAndEarn(int[] nums) {
        int n=nums.length;
        if(n==1)
            return nums[0];
        
        int max=nums[0];
        for(int i=1;i<n;i++)
        {
            max=Math.max(max,nums[i]);
        }
        
        // Form an array of length max+1. Since given that nums[] will be +ve
        int[] arr=new int[max+1];
        
        for(int i=0;i<n;i++)
        {
            arr[nums[i]]+=nums[i];
        }
        
        //Now with arr[], the problem has turned into a houserobber problem. We can not choose two adjacent elements.
        int[] dp=new int[max+1];
        for(int i=1;i<max+1;i++)
        {
            //choose=> dp[i]= dp[i-2]+arr[i];            
            //not choose =>  dp[i]=dp[i-1];
            // find max of above two cases
            
            if(i==1)
                dp[i]=Math.max(dp[i-1],arr[i]);
            else
                dp[i]=Math.max(dp[i-1],dp[i-2]+arr[i]);
            
        }
        
        return dp[max];
        
    }
}