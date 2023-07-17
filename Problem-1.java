// Time Complexity : O(n) +O(max(n))
// Space Complexity :O(max(n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//1st solution using dp Array
class Solution {
    public int deleteAndEarn(int[] nums) {

        if(nums== null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        int max = nums[0];

        //O(n) +O(max(n))
        for(int i =0; i< nums.length; i++) {
            if(nums[i] > max) max = nums[i];
        }
        
        int[] dp = new int[max+1]; //o(max(n))                  

        for(int i =0; i<nums.length; i++) { //O(n)
            dp[nums[i]] = dp[nums[i]] +nums[i];
        }

        int prev = dp[0];
        int curr = Math.max(dp[0], dp[1]);
        
        //dp is the array to use now
        for(int i =2; i<dp.length; i++) { // O(max(n))
            int temp = curr;
            curr = Math.max(curr, dp[i] + prev);
            prev = temp;
        }

        return curr;

    }
}
