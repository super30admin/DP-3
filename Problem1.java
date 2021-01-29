// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this : N


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length==0)
            return 0;

        int[] dp = new int[getMax(nums)+1];

        for(int num : nums){
            dp[num] += num;
        }

        int lastNum = 0;
        int prev = 0;

        for(int i=0;i<dp.length;i++){
            int temp = lastNum;
            lastNum = Math.max(lastNum,prev + dp[i]);
            prev = temp;
        }

        return lastNum;
    }

    public int getMax(int[] nums){
        int max = Integer.MIN_VALUE;

        for(int num: nums){
            max = Math.max(max, num);
        }

        return max;
    }
}