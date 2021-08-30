// Time Complexity : O(n x m) n number of rows, number of col
// Space Complexity : O(n x m)
// Did this code successfully run on Leetcode : Yes

var minFallingPathSum = function (matrix) {
    if (!matrix || matrix.length === 0) return -1;
    var dp = new Array(matrix.length);
    for (let i = 0; i < dp.length; i++) {
        dp[i] = new Array(matrix.length);
    }

    for (let i = 0; i < matrix.length; i++) {
        dp[0][i] = matrix[0][i];
    }

    for (let i = 1; i < matrix.length; i++) {
        for (let j = 0; j < matrix.length; j++) {
            if (j == 0) dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
            else if (j == matrix.length - 1) dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
            else dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j + 1], dp[i - 1][j - 1]));

        }
    }

    let min = Infinity;

    for (let i = 0; i < matrix.length; i++) {
        if (min > dp[matrix.length - 1][i]) min = dp[matrix.length - 1][i];

    }

    return min;

};