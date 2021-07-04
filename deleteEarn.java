// Time Complexity : O(n)
// Space Complexity : O(m) -- m is max int in nums 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = nums[0];
        // find max in array
        for(int i=1; i<nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        int len = max;
        int[] earnings = new int[len+1];
        int[][] res = new int[len+1][2];
        res[0][0] = 0;
        res[0][1] = 0;
        //create earnings array
        for(int j=0; j<nums.length; j++){
            earnings[nums[j]] += nums[j]; 
        }
        for(int k=1; k<res.length; k++){
            //not choose current element
            res[k][0] = Math.max(res[k-1][0], res[k-1][1]);
                
            // choose current element   
            res[k][1] = res[k-1][0] + earnings[k];
        }
        return Math.max(res[res.length-1][0], res[res.length-1][1]);
    }
}