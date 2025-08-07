// Time Complexity : O(n + m) where n is the length of the input array and m is the maximum element in the array
// Space Complexity : O(m) where m is the maximum element in the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No




class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);          //get the max element in the array
        }
        int arr[]=new int[max+1];
        for(int num:nums){
            arr[num]+=num;    //store the sum of all occurrences of each number
        }
        int[] dp=new int[max+1];
        dp[0]=arr[0];
        dp[1]=Math.max(arr[0],arr[1]);  //base cases for dp array


        //dp[i] will store the maximum points we can earn by considering numbers up to i by choose or no choose
        for(int i=2;i<=max;i++){
            dp[i]=Math.max(dp[i-1],arr[i]+dp[i-2]);
        }
        return dp[max];
    }
}