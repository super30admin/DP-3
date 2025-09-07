// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
    Integer[] memo;
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        // Find max in nums
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // create array where arr[i] is total available from chosing i
        int[] arr = new int[max + 1];
        for (int num : nums) {
            arr[num] += num;
        }

        this.memo = new Integer[max + 1];
        return helper(arr, 0);
    }

    private int helper(int[] arr, int i) {
        if (i >= arr.length) return 0;

        //check memo[i] is not null, if not return it
        if (memo[i] != null) return memo[i];

        //opt 1, skip index
        int case0 = helper(arr, i + 1);

        //opt 2, take index but skip i+1, going right to i +2
        int case1 = arr[i] + helper(arr, i + 2);

        memo[i] = Math.max(case0, case1);
        return memo[i];
    }
}
