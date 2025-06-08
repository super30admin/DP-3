// Time Complexity : O(max(n, max ele in input array))
// Space Complexity : O(max ele in input array)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach: For each element in the input array, compute the total sum possible (number of occurences * element)
// According to the problem if we choose ith element, all occurences of (i-1) and (i+1) need to be removed
// This is same as house robber, if we choose i, the neighboring elements can't be chosen. Choose max possible sum such that consecutive elements cannot be chose.
// Solve using DP

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(nums[i], max);
        }
        int arr[] = new int[max+1];
        for(int i=0;i<nums.length;i++){
            arr[nums[i]] +=nums[i];
        }
        int dp[] = new int[max+1];
        if(arr.length==2){
            return arr[1];
        }
        dp[1] = arr[1];
        dp[2] = Math.max(dp[1], arr[2]);
        for(int i=3;i<arr.length;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]);
        }
        return dp[arr.length-1];
    }
}