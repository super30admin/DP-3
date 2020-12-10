// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : YES

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& A) {
        int n = A.size();
        vector<vector<int>> dp(n, vector<int>(n));
        for(int i=0;i<n;i++){
            dp[0][i]=A[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    dp[i][j]=A[i][j]+min(dp[i-1][j],dp[i-1][j+1]);
                }
                else if(j==n-1){
                    dp[i][j]=A[i][j]+min(dp[i-1][j], dp[i-1][j-1]);
                }
                else{
                    dp[i][j] = A[i][j]+min(dp[i-1][j], min(dp[i-1][j+1],dp[i-1][j-1]));
                }
            }
        }
        int mini = INT_MAX;
        for(int i=0;i<n;i++){
            if(mini>dp[n-1][i]){
                mini = dp[n-1][i];
            }
        }
        return mini;
    }
};
