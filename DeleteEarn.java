/* Time Complexity : O(M) + O(N) -- where N is the number of elements in the input array and M is the maximum element from the input 
array. This is considered as we use a for loop to create an array of size max+1*/
// Space Complexity : O(M) + O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to refer to class discussion


// Your code here along with comments explaining your approach
/* Approach -
 * We try to convert the problem into house robber problem by converting i/p array into a array with no repeated values (these
 * repeat valued are summed up against a index which is the value itself e.g. 22233344 -> {2:6,3:9,4:8} -- where key is the index of array
 * bascically underhood implementation of hasmap!!). Then the house robber problem approach is repeated over this newly generated 
 * array.
 */


class Solution {
    public int deleteAndEarn(int[] nums) {
        // finding max from i/p array
        int max = nums[0];
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
        }

        /*creating array of size max and storing the 
        values at corresponding indices*/
        int[] arr = new int[max+1];
        for(int i=0;i<nums.length;i++){
            int curr = nums[i];
            arr[curr] = arr[curr] + curr;
        }
        
        /* Filling the dp array based on the developed pattern*/
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        for(int j=2;j<arr.length;j++){
            dp[j] = Math.max(dp[j-1],arr[j]+dp[j-2]);
        }

        return dp[arr.length-1];

    }

}