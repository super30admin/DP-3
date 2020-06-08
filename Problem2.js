//Minimum Falling Path Sum (LC 931)

// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Similar to paint house but slight tweak

//Using DP compare previous values and calculate min value
/**
 * @param {number[][]} A
 * @return {number}
 */
var minFallingPathSum = function(A) {
    if(A.length === 0 || A === null){
        return 0;
    }
    let m = A.length;
    let n = A[0].length;
    let dp = new Array(A.length);
    for(let k = 0; k < A.length; k++){
        dp[k] = new Array(A.length).fill(0)
    }
    for(let i=0; i<n;i++){
        dp[0][i] = A[0][i];
    }
    for(let i=1;i<m;i++){
        for(let j=0;j<n;j++){
            if(j===0){
                dp[i][j]=A[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
            } else if(j=== n-1){
                dp[i][j]=A[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
            }else{
                dp[i][j]=A[i][j] + Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]),dp[i-1][j+1]);
            }
        }
    }
    let min = Infinity;
    for(let i=0;i<n;i++){
        min = Math.min(dp[m-1][i], min);
    }
    return min;
};