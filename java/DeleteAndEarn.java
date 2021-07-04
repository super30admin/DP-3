740. Delete and Earn
        You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:

        Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
        Return the maximum number of points you can earn by applying the above operation some number of times.

        Example 1:

        Input: nums = [3,4,2]
        Output: 6
        Explanation: You can perform the following operations:
        - Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
        - Delete 2 to earn 2 points. nums = [].
        You earn a total of 6 points.
        Example 2:

        Input: nums = [2,2,3,3,3,4]
        Output: 9
        Explanation: You can perform the following operations:
        - Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
        - Delete a 3 again to earn 3 points. nums = [3].
        - Delete a 3 once more to earn 3 points. nums = [].
        You earn a total of 9 points.

// Time Complexity : O(max(N, max(nums))
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*

 */
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0) return 0;

        int max = nums[0];
        for(int i=1; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        int[] arr = new int[max+1];
        for(int num : nums){
            arr[num] += num;
        }

        int choose = arr[0], skip=0;
        for(int i=0; i<arr.length; i++){
            int prevSkip = skip;
            skip = Math.max(skip, choose);
            choose = arr[i] + prevSkip;
        }
        return  Math.max(skip, choose);
    }
}