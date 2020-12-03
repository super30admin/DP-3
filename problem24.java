// Time Complexity : O(N)
 
// Space Complexity :  0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] sum = new int[10002]; 
        
        for(int i = 0; i < nums.length; i++){
            sum[nums[i]] += nums[i]; 
        }
        
        for(int i = 2; i < sum.length; i++){
            sum[i] = Math.max(sum[i-1], sum[i-2] + sum[i]);
        }
        return sum[10001];
    }
}
