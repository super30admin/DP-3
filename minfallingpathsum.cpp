class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int n = matrix.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));

        for(int i = 0 ;i< n;i++){
            dp[0][i] = matrix[0][i];
        }

        for(int i = 1;i <n ;i++){
            for(int j = 0;j < n; j++){
                if(j==0){//first column
                    dp[i][j] = matrix[i][j] + min(dp[i-1][j] , dp[i - 1][j + 1]);
                    //minimum of element right below and element in next column and below row
                }
                else if(j == n-1){//last column
                    dp[i][j] = matrix[i][j] + min(dp[i-1][j] , dp[i-1][j-1]);
                    //minimum of element right below and element in previous column and below row
                }
                else{
                    dp[i][j] = matrix[i][j] + min(dp[i-1][j-1] ,min(dp[i-1][j],dp[i-1][j+1]));
                    //minimum of element right below,element in previous column and below row and element in next column and below row
                }
                }
            }
        }

        int minValue = INT_MAX;
        for(int i = 0;i<n;i++){
            minValue = min(minValue,dp[n-1][i]);//compare all values in the last column and return min value
        }
        
        return minValue;
    }
};