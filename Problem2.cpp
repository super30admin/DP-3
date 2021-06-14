//Time Complexity : O(M*N)
//Space Complexity : O(N) extra space for new vector
class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<int>> dp(matrix);
        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = dp[i-1][j]+matrix[i][j];
                if(j>0)
                    dp[i][j] = min(dp[i][j],dp[i-1][j-1]+matrix[i][j]);
                if(j<n-1)
                    dp[i][j] = min(dp[i][j],dp[i-1][j+1]+matrix[i][j]);
            }
        }
        return *min_element(dp[m-1].begin(),dp[m-1].end());
    }
};