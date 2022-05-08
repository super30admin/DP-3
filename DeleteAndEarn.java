// Time Complexity : O(Max) + O(N) where max is the maximum number in the array and N is the length
// Space Complexity : O(Max) where max is the maximum number in the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max=0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }

        int[]arr = new int[max+1];

        //building a number array
        for(int i=0; i<nums.length; i++){
            arr[nums[i]]+=nums[i];
        }

        // dont take adjacent values like house robber
        int[] dp = new int[max+1];
        dp[1] = arr[1];
        for(int i=2;i<max+1; i++){
            dp[i] = Math.max(dp[i-1], arr[i] + dp[i-2] );
        }

        return dp[max];
    }
}
