// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution1 {
    public int deleteAndEarn(int[] nums) {

        // Null checks
        if (nums == null || nums.length == 0)
            return 0;

        // Create a simplified array from 0 to max + 1, which will store sum of points
        // grouped by points;
        // where max is the maximum value in given nums

        // 1. Find max
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // 2. Create simplified array
        int[] arr = new int[max + 1];
        for (int num : nums) {
            arr[num] += num;
        }

        // 3. Following Skip and Take pattern from House Robber on the above simplified
        // array
        int skip = 0, take = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + arr[i];
        }

        return Math.max(skip, take);

    }
}
