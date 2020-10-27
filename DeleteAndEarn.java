// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


class Solution {
    public int rob(int[] nums) {
        if(nums ==null || nums.length == 0){
            return 0;
        }
        int skip = 0; int take = 0;
        for(int i = 0;i< nums.length;i++){
            int temp = skip;
            skip = Math.max(skip,take);
            take = temp + nums[i];
        }
        return Math.max(skip,take);
        // return helper(nums, 0, 0 );
    }
    //recursive approach - 2^N
    // private int helper(int[] nums, int index, int sum){
    //     // base
    //     if(index >= nums.length ){
    //         return sum;
    //     }
    //     // logic
    //     int case0 = helper(nums, index + 1, sum);
    //     int case1 = helper(nums, index + 2, sum + nums[index]);
    //     return Math.max(case0, case1);
    // }
}