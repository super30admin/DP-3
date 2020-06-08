/**
 * Delete and Earn : For an array nums of integers, For each iteration,
 * you pick any nums[i] and delete it to earn nums[i] points.
 * After, you must delete every element equal to nums[i] - 1 and nums[i] + 1.
 * You start with 0 points. Return the maximum number of points you can earn
 *
 * similar to house robber with little modification:
 * Since i have to delete the ele one greater and less than the number, i will arrange it in sorted order from the 0 to max val in the given array
 * then for each cell, check if the previous val is reater or previous to previous number and the current is greater--similar to house robber
 */

// Time Complexity : Exponential : O(2^n) where n is the max ele in the given array
// Space Complexity : O(n) where n is the max ele in the given array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num: nums)
            max = Math.max(max,num);

        int[] dp = new int[max+1];
        Arrays.fill(dp,0);
        for(int num: nums)
            dp[num] += num;

        return helper(dp,0,0);
    }
    private int helper(int[] nums, int index, int earn){
        //base case
        if(index >= nums.length)
            return earn;
        //choose
        int choose = helper(nums,index+2,earn+nums[index]);

        //dont choose
        int notchosen  = helper(nums,index+1,earn);

        return Math.max(choose,notchosen);
    }
}

// Your code here along with comments explaining your approach


// Time Complexity : O(n) - n: max element in the given array
// Space Complexity : O(n) - n: max element in the given array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no     --similar to house robber with little modification


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num: nums)
            max = Math.max(max,num);

        int[] dp = new int[max+1];
        Arrays.fill(dp,0);
        for(int num: nums)
            dp[num] += num;

        for(int i=2;i<=max;i++){
            dp[i] =  Math.max(dp[i-1],dp[i-2]+dp[i]);
        }
        return dp[max];
    }
}