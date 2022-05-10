// Time Complexity : O(M*N) //brute force approach
// Space Complexity : O(M*N) + dp array extra
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * @param {number[][]} matrix
 * @return {number}
 */
var minFallingPathSum = function(A) {
   let row = A.length;
    let col = A[0].length;
    let dp = [];
   for(var i=0;i<row;i++)
    {
     dp.push([]);
     for(var j=0;j<col;j++)
     {
           dp[i][j]=A[i][j];
     }
    }
    for(let i=1;i<row;i++)
    {
     for(let j = 0;j<col;j++)
     {
        if(j>0 && j<row-1){
            dp[i][j] = Math.min(dp[i-1][j-1]+A[i][j],dp[i-1][j]+A[i][j]);
            dp[i][j] = Math.min(dp[i-1][j+1]+A[i][j],dp[i][j]);
        }
        else if(j==0){
            dp[i][j] = Math.min(dp[i-1][j+1]+A[i][j],dp[i-1][j]+A[i][j]);
        }
        else if(j == row-1){
            dp[i][j] =Math.min(dp[i-1][j-1]+A[i][j],dp[i-1][j]+A[i][j]);
        }
     }
    }
    var min = Infinity;
    for(let last=0;last<col;last++)
    {
        min = Math.min(dp[row-1][last],min);
    }
    return min;  
};