// Time Complexity : O(max(length of array, max element in array))
// Space Complexity : O(max element in array)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*

This problem is similar to house robber problem. Over here the DP[i] is the freq of 
element in nums element. 
Then similar to house robber approach is used.

*/

public class DeleteAndEarn {
    

    public static int deleteAndEarn(int[] nums)
    {
        if(nums==null || nums.length==0)
        {
            return 0;
        }

        int max = Integer.MIN_VALUE;

        for(int i =0;i<nums.length;i++)
        {
            max = Math.max(nums[i], max);
        }

        int[] dp = new int[max+1];

        for(int i:nums)
        {
            dp[i]+=i;
        }

        int skip=0,take=dp[0];
        for(int i =1;i<dp.length;i++)
        {
            int temp = skip;
            skip = Math.max(skip,take);
            take = temp + dp[i];
        }

        return Math.max(skip,take);
        
    }

    public static void main(String args[])
    {
        int nums[] = {2,2,3,3,3,4};
        System.out.println(deleteAndEarn(nums));
    }
}
