/**
 Time Complexity: O(N + M) where N is the maximum number in the input array and M is the length of the input array.
 Space Complexity: O(N) where N is the maximum number in the input array.
 did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No
 */
/**
 * This problem is similar to the house robber problem where if we take an element, we cannot take its adjacent elements. Here, if we take an element 'x', we cannot take 'x-1' and 'x+1'.
 * We first create an array 'arr' where each index represents the total points we can earn by taking that number (i.e., arr[i] = i * frequency of i in nums).
 * Then, we use dynamic programming to decide whether to take or skip each number, similar to the house robber problem.
 */

class deleteAndEarn {
    public int deleteAndEarn(int[] nums) {

        int max=0;
        for (int num:nums)
        {
            max=Math.max(max,num);
        }

        int[] arr=new int[max+1];
        for (int num:nums)
        {
            arr[num]+=num;
        }

        int[] dp=new int[max+1];
        dp[0]=arr[0];
        dp[1]=Math.max(arr[0],arr[1]);

        for(int i=2;i<=max;i++)
        {
            dp[i]=Math.max(dp[i-1],arr[i]+dp[i-2]);
        }
        return dp[max];
        
    }
    
}