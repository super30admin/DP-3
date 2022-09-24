// Time Complexity : O(mn) where m is rows and n is cols
// Space Complexity : O(mn) where m is rows and n is cols
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)
// Your code here along with comments explaining your approach

/**
 * @param {number[][]} matrix
 * @return {number}
 */
var minFallingPathSum = function (matrix) {
    // If matrix is null or empty, return 0
    if (matrix === null || matrix.length === 0) {
        return 0;
    }
    // Creste a dp of size same as matrix
    let dp = new Array(matrix.length);
    for (let i = 0; i < dp.length; i++) {
        dp[i] = new Array(matrix[0].length);
    }
    // Fill the last row same as matrix
    for (let j = 0; j < dp[0].length; j++) {
        dp[dp.length - 1][j] = matrix[dp.length - 1][j];
    }

    // String from second last row, the value of each dp index will be value at matrix index + Minimum of next falling locations
    for (let i = dp.length - 2; i >= 0; i--) {
        for (let j = 0; j < dp[0].length; j++) {
            if (j === 0) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            } else if (j === dp[0].length - 1) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j - 1]);
            } else {
                dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], Math.min(dp[i + 1][j + 1], dp[i + 1][j - 1]));
            }
        }
    }
    // Find minimum in the 1st row and return
    let min = dp[0][0];
    for (let j = 1; j < dp[0].length; j++) {
        min = Math.min(min, dp[0][j]);
    }
    return min;
};