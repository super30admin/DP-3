// Time Complexity : O(N) where N is nums.length
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// **** NOTE TO SELF: Choose between dp array and dp matrix based on number of constraints in the question **** //

/*
Approach:
=========
1. Check maximum element in the array and create array of that size. 
2. Calculate maximum sum gained if that value is chosen and update sum at that index in the new array i.e. if we have 2 21s in array, go to sum[21] and update it to 42
3. Use this dp array to calculate max sum similar to house robber problem 
*/

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        
        //find max value
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max)
                max  = nums[i];
        }
        
        // update total sum for that element at its index 
        // we have only constraint here, which is nums, so dp array is sufficient to get the result 

        int[] sum = new int[max+1];
        for(int i = 0; i < nums.length; i++) {
            sum[nums[i]] += nums[i];
        }
        
        int skip = 0, choose = 0;
        
        //curr_skip is if we dont choose this element, curr_choose is amount if we pick it
        //At every step, we are making decision whether to choose or pick and calculating sum continuously
        for(int i = 0; i < sum.length; i++) {
            int curr_skip = Math.max(skip,choose);
            int curr_choose = skip + sum[i];
            skip = curr_skip;
            choose = curr_choose;
        }

        // As we calculated continuous sum similar to house robber problem, now it is max of skip and choose after the last element
        return Math.max(skip,choose);
    }
}

class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        // array of max size
        int max = getMax(nums);
        int[] dp = new int[max+1];
        for(int i: nums) {
            dp[i] += i;
        }
        
        int choose = 0, notChoose = 0;
        for(int i: dp) {
            int temp = notChoose;
            notChoose = Math.max(choose, notChoose);
            choose = i + temp;
        }
        return Math.max(choose, notChoose);
    }
    private int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i: nums)
            max = Math.max(i, max);
        return max;
    }
}
