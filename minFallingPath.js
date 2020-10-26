// Time Complexity : O(n*m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



var minFallingPathSum = function(A) {


    let MAX = Number.MAX_SAFE_INTEGER;
    let n = A.length
    let dp = new Array(n + 1);
    for(let i = 0; i < dp.length; i++){
        dp[i] = new Array(n+1).fill(0);
        dp[0][i] = MAX;
    }    

    for(let i = 1; i < n; i++){
        for(let j = 1; j <= n; j++){
            let min = MAX;
            for(let k = j - 1; k < j  + 2 && j <= n; k++){
                min = Math.min(dp[i - 1][k], min)
            }
            dp[i][j] = min + A[i- 1][j - 1]
        }
    }
    return Math.min(...dp[n]);
};
