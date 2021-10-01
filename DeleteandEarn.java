//Time Complexity: O(Max(len of num), max(value in num))
//        Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No




class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null && nums.length == 0) return 0;
        int dp[] = new int[getMax(nums) + 1];
        for(int x: nums){
            dp[x] += x;
        }

        //Same Implementation as House Robber

        int C = 0, DC = 0;
        for(int x : dp){
            int temp = DC;
            DC = Math.max(C,DC);
            C = temp + x;
        }
        return Math.max(C,DC);


    }
    public int getMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int x : nums)
            max = Math.max(x,max);
        return max;
    }
}


// Your code here along with comments explaining your approach
