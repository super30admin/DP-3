package S30.DP_3;

/*DP Solution
Time Complexity : Put: O(n),
Space Complexity : O(m + n),  m is arr length, n is nums length
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class MaxDeleteAndEarn {

    public int deleteAndEarn(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        //transform array by collecting cumulative value of each element -- this turns the problem into a house robber problem

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max,nums[i]);
        }

        int[] arr = new int[max+1];
        for(int i = 0; i < nums.length; i++){
            arr[nums[i]] += nums[i];
        }

        //if you earn from an element, cannot earn from adjacent elements
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = arr[1];
        for(int i = 2; i < arr.length; i++){
            dp[i] = Math.max(dp[i-1], arr[i] + dp[i-2]);
        }

        return dp[dp.length - 1];
    }

}
