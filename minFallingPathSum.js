// Time Complexity : O(n^2) where n is length of matrix
// Space Complexity : O(n^2) where n is length of matrix
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

/**
 * @param {number[][]} matrix
 * @return {number}
 */
var minFallingPathSum = function(matrix) {
    let n = matrix.length;
    let dp = [new Array(n)];
    dp[0] = matrix[0];
    for(let i=1; i<n; i++) {
        for(let j=0; j<n; j++) {
            if(!dp[i]) {
                dp[i] = new Array(n);
            }
            dp[i][j] = dp[i-1][j];
            if(j - 1 >= 0) dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
            if(j + 1 < n) dp[i][j] = Math.min(dp[i][j], dp[i-1][j+1]);
            dp[i][j] += matrix[i][j]; 
        }
    }
    
    let res = Infinity;
    for (let j = 0; j < n; j++) {
        res = Math.min(res, dp[n-1][j]);
    }
    return res;
};