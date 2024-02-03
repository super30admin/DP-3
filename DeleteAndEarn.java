// time complexity - O(n + max), space - O(max)
//Iterate over the input array nums to find the maximum value (max).
//Initialize an array dp of size max+1 to store the sum of values at each index.
//Iterate over the nums array again and populate the dp array with the sum of values at their respective indices.
//Use dynamic programming to calculate the maximum sum of non-adjacent elements.

class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        if(nums == null || n == 0) return 0;  
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){ //O(n)
             max = Math.max(max, nums[i]);
        }
        int [] dp = new int[max+1];

        for(int i=0;i<n;i++){ //O(n)
           dp[nums[i]] += nums[i];
        }
      
        for(int i =2;i<dp.length;i++){ //O(max) , max= max value in nums
            dp[i] = Math.max(dp[i-1], dp[i]+dp[i-2]);
        }
        return dp[dp.length-1];
        


    }
}