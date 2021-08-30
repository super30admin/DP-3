// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Delete and earn:
 * 
 * You are given an integer array nums. You want to maximize the number of
 * points you get by performing the following operation any number of times:
 * 
 * Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must
 * delete every element equal to nums[i] - 1 and every element equal to nums[i]
 * + 1. Return the maximum number of points you can earn by applying the above
 * operation some number of times.
 * 
 * Input: nums = [3,4,2] Output: 6 Explanation: You can perform the following
 * operations: - Delete 4 to earn 4 points. Consequently, 3 is also deleted.
 * nums = [2]. - Delete 2 to earn 2 points. nums = []. You earn a total of 6
 * points.
 */

public class DeleteEarn {

    public int deleteAndEarn(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] arr = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] += nums[i];
        }

        int skip = 0;
        int take = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + arr[i];
        }

        return Math.max(skip, take);
    }

    public static void main(String[] args) {
        DeleteEarn de = new DeleteEarn();
        int[] nums = { 2, 2, 3, 3, 3, 4 };
        System.out.println(de.deleteAndEarn(nums));
    }
}