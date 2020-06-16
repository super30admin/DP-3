/* Problem1- Delete and earn (DP3)

// Time Complexity : O(max(nums))
// Space Complexity : O(max(nums))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//We will consider a DP array initialising 0 at every index with length max(mums)-non optimal
//then we will add sum(nums) at each index in DP array
//we will consider skip and tail variables with curr_skip as max(skip, take) and curr_take as skip+values[i]
//we keep iterating nums array successively, and at the end return max(curr_skip, curr_take)
*/

class Solution {
    public int deleteAndEarn(int[] nums) {
        //intialising DP Array with length as max(nums)
        int[] values = new int[10001];         
        //iterating over nums array and initialising values at index in values array
        for(int num: nums){
            values[num] += num;
        }
        //intialise skip and take variables
        int skip = 0;
        int take = 0;
        //iterate over nums array and intialise values at corresponding index in values array
        for(int i = 1; i < values.length; i++){
            int curr_skip = Math.max(skip,take);
            int curr_take = skip + values[i];
            skip = curr_skip;
            take = curr_take;
        }
        //return max of last result(skip, take)
        return Math.max(skip, take);
    }
}
