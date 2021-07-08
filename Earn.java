// Time Complexity : O(n) + maximum(O(n)) since we are traversing through both arrays. The first array is the original array and the new 
// array is the reordering of the elements such that deletions could be made easier.
// Space Complexity : O(n) We are using a DP matrix but the number of columns would be always constant as 2. hence n is the number of elements in the new array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Pre-Processing step was challenging to understand
/* Your code here along with comments explaining your approach: We copied the elements from the original array to the new array such that the
elements appear in the index same as their value so that same numbers sum up and we dont have to do additional traversing of the array back and forth.
Once we get the nums_ordered, we reduce it to a problem where we need to avoid adjacent elements since they would be deleted in consecutive order,
but we add the adjacent elements to get the max number.
*/
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0 || nums == null){return 0;}
        int[] nums_ordered = new int[Arrays.stream(nums).max().getAsInt()+1]; // Gettng the max of original array to decide the size
        int[][] dp = new int[nums_ordered.length][2];
        for(int i = 0; i < nums.length; i++) {
            nums_ordered[nums[i]] += nums[i];                   // Copying the elements from original array to the new array
        }
        for(int i = 1 ; i<nums_ordered.length;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);                // Maximum of the previous row is the cost if I dont choose current value
            dp[i][1] = dp[i-1][0]  + nums_ordered[i];                   // If I choose this value, the previous value isnt chosen, hence the cost    
        }
        return Math.max(dp[dp.length-1][0], dp[dp.length-1][1]);            // Maximum return from the last row
    }
}