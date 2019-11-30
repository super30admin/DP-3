// Brute Force
// Time Complexity -
// Space Complexity -
// This Solution did not work on LeetCode and ended in Time Limit Exceeded Error


// Dynamic Programing using dp array
// Time Complexity - O(n^2)
// Space Complexity - O(n^2)
// This Solution worked on LeetCode

class Solution {
    public int minFallingPathSum(int[][] A) {
        int n = A.length;
        int[][] dp = A.clone();
        int min = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            for(int j =0;j<n;j++){
                if(j==0)
                    dp[i][j] = dp[i][j]+Math.min(dp[i-1][j],dp[i-1][j+1]);  // if it is first element of the row
                else if(j==n-1)
                    dp[i][j] = dp[i][j] + Math.min(dp[i-1][j],dp[i-1][j-1]); // if it is last element of the row
                else 
                    dp[i][j] = dp[i][j] + Math.min(Math.min(dp[i-1][j],     //others in between will have to consider j-1,j and j+1
                                        dp[i-1][j-1]),dp[i-1][j+1]);   
            }
        }
        for(int i=0;i<n;i++){
            min = Math.min(min,dp[n-1][i]);   // get the minimum of the last row to get the minimum sum path
        }
        return min;
    }
}


// Dynamic Programing using mutating the same array
// Time Complexity - O(n^2)
// Space Complexity - O(1)
// This Solution worked on LeetCode as well
class Solution {
    public int minFallingPathSum(int[][] A) {
        int n = A.length;
        int min = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            for(int j =0;j<n;j++){
                if(j==0)
                    A[i][j] = A[i][j]+Math.min(A[i-1][j],A[i-1][j+1]);
                else if(j==n-1)
                    A[i][j] = A[i][j] + Math.min(A[i-1][j],A[i-1][j-1]);
                else 
                    A[i][j] = A[i][j] + Math.min(Math.min(A[i-1][j],
                                        A[i-1][j-1]),A[i-1][j+1]);
            }
        }
        for(int i=0;i<n;i++){
            min = Math.min(min,A[n-1][i]);
        }
        return min;
    }
}
