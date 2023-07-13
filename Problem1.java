// Time Complexity : O(N+M) where N is the length of nums, new array on which dp is created.
// Space Complexity : O(N+M)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// array is created with the sum of the same nums at the respective index. dp array is create by calculating the max of the current sum + previous to the previous sum 
// and adjecent sum as in the given problem if the element is considered the adjecent numbers are deleted.

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num : nums){
            max = Math.max(num, max);
        }
        int[] arr = new int[max+1];
        for(int num:nums){
            arr[num] += num; 
        }
        int[] dp = new int[arr.length+1];
        if(arr.length == 1) return arr[0];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        for(int i=2;i<arr.length;i++){
            dp[i] = Math.max(arr[i]+dp[i-2],dp[i-1]);
        }
        return dp[arr.length-1];
    }
}