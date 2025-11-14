/*
 Approach: Delete and Earn (Top-down with memoization)
 - Transform: Build an array `array` where array[val] = total points obtainable by taking all occurrences of val (i.e., sum of val * count(val)).
 - Reduce to House Robber problem: choosing value `v` earns array[v] but forbids choosing v-1 and v+1.
 - Use recursion + memoization to compute the maximum points starting from index 0.

 Time Complexity: O(N + M) where N = nums.length (to build `array`) and M = max(nums) (to compute memoized results). Essentially O(N + M).
 Space Complexity: O(M) for the auxiliary arrays (`array` and `memo`) and recursion stack (O(M) worst-case).
 LeetCode: https://leetcode.com/problems/delete-and-earn/ (Problem 740)
*/

public class DeleteAndEarn {

    Integer[] memo;

    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int n : nums) {
            max = Math.max(max, n);
        }
        int[] array = new int[max + 1];
        for (int n : nums) {
            array[n] += n;
        }
        memo = new Integer[max + 1];

        return helper(array, 0);
    }

    private int helper(int[] arr, int idx) {
        //base
        if (idx >= arr.length) return 0;

        if (memo[idx] != null) return memo[idx];
        //logic
        int notChose = helper(arr, idx + 1);
        int chose = arr[idx] + helper(arr, idx + 2);
        return memo[idx] = Math.max(notChose, chose);
    }


    public static void main(String[] args) {
    }
}
