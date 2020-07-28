//Time complexity=O(n)
//Space Complexity=O(m), m=max value in the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int deleteAndEarn(int[] nums) {
        //Base case
        if(nums.length==0 || nums==null)
            return 0;
        int m=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)//Searching for the  max element in our array
        {
            m=Math.max(m,nums[i]);
        }
        int[] earned=new int[m+1];//Creating a array of size m i.e. value of max element
        for(int i=0;i<nums.length;i++)
        {
            earned[nums[i]]+=nums[i];//Adding all the element in the array we have created 
        }
        int dp[][]=new int[m+1][2];
        //Here we have two column in dp one is for don't choose and other one is for choose
        for(int i=1;i<dp.length;i++)
        {
            //In don't choose we are taking the max value form the previous row(i.e. max of previous choose and don't choose)
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=earned[i]+dp[i-1][0];//In choose we are taking the value of that index form the earned and are adding it to the don't choose of previous one.
        }
        return Math.max(dp[m][0],dp[m][1]);//Returning the max of last row
    }
}