// Time Complexity : O(n)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)

// You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:

// Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
// Return the maximum number of points you can earn by applying the above operation some number of times.

// Example:
// Input: nums = [2,2,3,3,3,4]
// Output: 9
// Explanation: You can perform the following operations:
// - Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
// - Delete a 3 again to earn 3 points. nums = [3].
// - Delete a 3 once more to earn 3 points. nums = [].
// You earn a total of 9 points.
 
// Constraints:
// 1 <= nums.length <= 2 * 104
// 1 <= nums[i] <= 104

class Solution {
    public int deleteAndEarn(int[] nums) {

        // Base case: nums is empty or null
        if (nums == null || nums.length == 0){
            return 0;
        }
        
        // Finding maximum number to initialize size of DP array
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        
        // Array for storing total earned value for each number
        int[] matrixSum = new int[max + 1];
        for (int i = 0; i < nums.length; i++){
            matrixSum[nums[i]] = matrixSum[nums[i]] + nums[i];
        }

        // skip & take - max points when we skip or take current number respectively
        int skip = 0, take = 0;
        for (int i = 1; i < matrixSum.length; i++){
            int tempSkip = skip;
            skip = Math.max(skip, take); // skipping current, taking max of previous take and skip
            take = tempSkip + matrixSum[i]; // taking current, adding total to previous skip
        }

        // Returning maximum points
        return Math.max(skip, take);
    }
}