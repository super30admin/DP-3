// Time Complexity : O(n + max(n)), where n array of nums
// Space Complexity : O(max(n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* First we convert our nums array into sumsArray where each cell represents the number and value the sum of that number in original
   nums array. We then use dp here. We use 2 variables to keep track of previous 2 nums. If we dont select the current num value would be equal to
   value of curr for previous house. Else if we select current value would be sum of value of previous to previous num and value 
   of current num. We take max of both cases. Eventually when we iterate through the maxArray we have max value stored in curr and 
   return it. Problem is hence reduced to House Robber.
*/

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;

        int maxNum = nums[0];
        for(int num: nums) {
            maxNum = Math.max(maxNum, num);
        }

        int[] sumArr = new int[maxNum + 1];

        for(int num: nums) {
            sumArr[num] += num;
        }

        int prev = sumArr[0];
        int curr = sumArr[1];

        for(int i = 2; i < sumArr.length; ++i) {
            int temp = curr;
            curr = Math.max(curr, prev + sumArr[i]);
            prev = temp;
        }
        return curr;
    }
}

