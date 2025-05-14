// Time Complexity: O(n + k), where
//   - n is the size of nums[]
//   - k is the maximum number in nums[] (since we iterate up to max value)
// Space Complexity: O(k), for the arr[] used to accumulate earnings
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        // Find the max value to size the array
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // Transform to House Robber format: arr[i] = total value of choosing i
        int[] arr = new int[max + 1];
        for (int num : nums) {
            arr[num] += num;
        }

        // Apply House Robber DP on the transformed array
        int prev = arr[0]; // dp[i - 2]
        int curr = Math.max(arr[0], arr[1]); // dp[i - 1]

        for (int i = 2; i <= max; i++) {
            int temp = curr;
            curr = Math.max(curr, arr[i] + prev); // dp[i] = max(skip, take)
            prev = temp;
        }

        return curr;
    }
}
// Time Complexity: O(n^2), where n is the number of rows/columns in the matrix
//   - We process every element in the matrix once
// Space Complexity: O(1)
//   - We update the matrix in-place with no extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        // Start from the second-last row and move upward
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int down = matrix[i + 1][j];
                int leftDiag = (j > 0) ? matrix[i + 1][j - 1] : Integer.MAX_VALUE;
                int rightDiag = (j < n - 1) ? matrix[i + 1][j + 1] : Integer.MAX_VALUE;

                // Update current cell with minimum sum path from below
                matrix[i][j] += Math.min(down, Math.min(leftDiag, rightDiag));
            }
        }

        // Final result is the minimum in the top row
        int minPathSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minPathSum = Math.min(minPathSum, matrix[0][j]);
        }

        return minPathSum;
    }
}
