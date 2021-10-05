// Time Complexity : O(3n) = O(numbers of element in nums + maximum element in nums)
// Space Complexity : O(maximum element in nums)  DP's size
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int[] dp = new int[getMax(nums) +1];
        //initializing dp array with sum of each element 
        for(int i=0;i<nums.length;i++){
            dp[nums[i]]= dp[nums[i]] +nums[i];
        }
        
        int C = 0, DC = 0;
        // if we dont choose then previous step maximum out of C and DC
        //if we choose then we do not choose previous one so sum of prev DC and current sum
        for(int i=0;i<dp.length;i++){
            int temp=DC;
            DC = Math.max(C,DC);
            C = dp[i] + temp;
        }
        
        return Math.max(C, DC);
    }
    
    private int getMax(int[] nums){
        int max = 0;
        for(int x:nums){
            max = Math.max(max,x);
        }
        return max;
    }
}