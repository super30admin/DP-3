// Time Complexity : O(M * N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope.  Basically the same problem we did yesterday (Paint House)

/**
 * @param {number[][]} A
 * @return {number}
 */
var minFallingPathSum = function(A) {
    // Edge case
    if (A == null || A.length == 0) return 0;

    // Min will be what we return
    let min = Infinity;

    for (let i = 1; i < A.length; i++) {
        for (let j = 0; j < A[i].length; j++) {
            if (j == 0) {
                // If we are on the left side of the array
                A[i][j] += Math.min(A[i - 1][j], A[i - 1][j + 1]);
            } else if (j == A.length - 1) {
                // If we are on the right side of the array
                A[i][j] += Math.min(A[i - 1][j - 1], A[i - 1][j]);
            } else {
                // If we are in the middle of the array
                // If we are on the left side of the array
                A[i][j] += Math.min(A[i - 1][j - 1], A[i - 1][j], A[i - 1][j + 1]);
            }
        }
    }
    // Loop through our last row and take the minimum
    for (let i = 0; i < A[A.length - 1].length; i++) {
        if (A[A.length - 1][i] < min) min = A[A.length - 1][i];
    }
    return min;
};
