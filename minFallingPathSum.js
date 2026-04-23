/**
 * @param {number[][]} matrix
 * @return {number}
 * Intuition:
For each cell, the minimum path sum to reach it depends only on the three possible cells from the previous row: top, top-left, and top-right.
We keep a dp array that stores the minimum falling path sums for the previous row, and build the current row using those values.
By updating row by row, we avoid extra 2D space and finally return the minimum value from the last row.
T.C: O(m*n)
S.C: O(m)
 */
var minFallingPathSum = function (matrix) {
    let n = matrix.length;
    let m = matrix[0].length;
    let dp = [...matrix[0]];
    for (let i = 1; i < n; i++) {
        let newDp = new Array(m).fill(0);
        for (let j = 0; j < m; j++) {
            let minAbove = dp[j];
            if (j > 0) {
                minAbove = Math.min(minAbove, dp[j - 1]);
            }
            if (j < m - 1) {
                minAbove = Math.min(minAbove, dp[j + 1]);
            }

            newDp[j] = matrix[i][j] + minAbove;
        }
        dp = newDp;
    }
    return Math.min(...dp)
};