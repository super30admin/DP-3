package DP3;
/*S30 Big N Problem #25 {Medium} - https://www.youtube.com/watch?v=h-WJiAHq_D0
    For an array nums of integers, For each iteration, you pick any nums[i] and delete it to earn nums[i] points. 
    After, you must delete every element equal to nums[i] - 1 and nums[i] + 1.

    You start with 0 points. Return the maximum number of points you can earn.

    Example 1:
    Input: nums = [3, 4, 2]
    Output: 6
    Explanation: 
    Delete 4 to earn 4 points, consequently 3 is also deleted.
    Then, delete 2 to earn 2 points. 6 total points are earned.

    Example 2:
    Input: nums = [2, 2, 3, 3, 3, 4]
    Output: 9
    Explanation: 
    Delete 3 to earn 3 points, deleting both 2's and the 4.
    Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
    9 total points are earned.

    Note:

    The length of nums is at most 20000.
    Each element nums[i] is an integer in the range [1, 10000].
    Source Link: https://leetcode.com/problems/delete-and-earn/
-------------------------------------------------------------------------------------------------------
Time complexity :O(N) 
space complexity:O(N) 
Approach:
Did this code run successfully in leetcode : yes
problems faces : no*/

public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] dpArray = new int[max + 1];

        for (int i = 0; i < nums.length; i++) {
            dpArray[nums[i]] = dpArray[nums[i]] + nums[i];
        }

        int skip = 0;
        int take = 0;

        for (int i = 0; i < dpArray.length; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + dpArray[i];
        }

        return Math.max(skip, take);
    }

}
