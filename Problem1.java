// Time Complexity : O(n) where n is the length of the input array
// Space Complexity : O(n) for the auxiliary array used to store the sum of points for each number
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem1 {
    public int deleteAndEarn(int[] nums) {
        // base case
        if (nums == null || nums.length == 0)
            return 0;
        // variables
        int max = Integer.MIN_VALUE;

        // pre-processing
        for (int num : nums) {
            max = Math.max(num, max);
        }

        // logic
        int[] arr = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] += nums[i];
        }

        int skip = 0, take = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + arr[i];
        }
        return Math.max(skip, take);
    }
}
