// Time Complexity : O(max(n)) + O(n) [n is the length of nums]
// Space Complexity : O(max(n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//tranform the given array and then use the house robber pattern
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length ==0 || nums == null) return 0;
        int max = Integer.MIN_VALUE;
        //find the max value in given array
        for(int num : nums){
             max = Math.max(max,num);
        }
        //create an array of length of max value found in the given array and value in the array is the sum of values found of that index in the originl array
        int[] dp = new int[max+1];
        for(int num : nums){
            dp[num] = dp[num] + num;
        }
//implement the logic of huse robber pattern
    int skip = 0 , take = dp[0];
    for (int i=1;i<dp.length;i++){
        int temp = skip;
        //case not choose
        skip = Math.max(skip,take);
        //choose
        take = temp + dp[i];
    }
        return Math.max(skip,take);
    }
}