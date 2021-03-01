package DP-3;

class Solution {
    public int deleteAndEarn(int[] nums) {

        //Declaring an array of size max number in the given array nums
        int[] dp = new int[maxNum(nums) + 1];

        //add the number of occurances of a number to the array to particular index
        for(int i=0; i<nums.length; i++){
            dp[nums[i]] += nums[i]; 
        }

        int C = 0, DC = 0;
        int temp = -1;

        //looping through the dp array and checking what happens if we choose a number or not
        for(int x : dp){
            temp = C;
            C = x + DC;
            DC = Math.max(temp, DC);
        }

        // finally return the max value of choose or dont choose
        return Math.max(C, DC);
    }
    
    //This function is used to calculate the max value in an array
    private static int maxNum(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n) 