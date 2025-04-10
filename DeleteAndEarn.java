// Time complexity:- O(n + m)
// Space complexity:- O(m), where m is the range of unique numbers in the array.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences
/**
 * Approach:
 * This problem is about maximizing the points by deleting numbers from an array while adhering to specific deletion rules.
 * I used a dynamic programming approach to solve the problem, where we store the maximum points possible for each number and its neighbors. 
 * First, I create an array 'arr' where each index represents the total points I can earn by choosing that number.
 * Then, I used dynamic programming to compute the maximum points by either including or excluding each number, ensuring I respect the rule of deleting neighbors.
 * I kept track of the previous and current maximum points using two variables to make the solution space-efficient.
 */
class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int max = Integer.MIN_VALUE;

        // Find the maximum value in nums
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        // Create the array to store the points for each number
        int[] arr = new int[max + 1];
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            arr[curr] += curr;
        }


        if (arr.length == 1) {
            return arr[0];
        }

        // Initialize dp values
        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);

        // Dynamic Programming iteration to calculate the maximum points
        for (int i = 2; i < arr.length; i++) {
            int temp = curr;
            curr = Math.max(curr, arr[i] + prev);
            prev = temp;
        }

        return curr;
    }
}
