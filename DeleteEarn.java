// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : to figure out the logic drew it on whiteboard

// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int n : nums){
            max = Math.max(n,max);
        }

        int[] sum = new int[max+1];
        
        //map the sum each number will contribute 
        for(int i = 0 ; i < nums.length ; i++){
            sum[nums[i]] += nums[i]; 
        }
        
        int prev = sum[0];
        int curr = Math.max(prev,sum[1]);

        for(int i = 2 ; i < sum.length ; i++){
            int tempCurr = curr;
            //max between not choose and choose
            curr = Math.max(curr, sum[i] + prev); // if we choose a number, since we can not take n-1 & n+1 we need to add prev
            prev = tempCurr;
        }

        return curr;
    }
}