class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {

        int m = matrix.size();
        int n = matrix[0].size();
            int mini = INT_MAX;
        int dp[m+1][n+1];
        for(int i = 0;i<=n;i++){
            dp[m][i] = 0;
        }

        for(int i=m-1;i >= 0;i--){
            for(int j=0;j<n;j++){

                
                if(j==0){

                    dp[i][j] = matrix[i][j]+min(dp[i+1][j],dp[i+1][j+1]);
                }
                else if(j == (n-1)) {
                    dp[i][j] = matrix[i][j]+min(dp[i+1][j],dp[i+1][j-1]);
                }else{
                     dp[i][j] = matrix[i][j]+min(dp[i+1][j+1], min(dp[i+1][j-1],dp[i+1][j])); 
                }
            }
        }

     for(int i = 0;i<n;i++){
            if(dp[0][i]<mini){
            mini = dp[0][i];
        }  
     }

        return mini;
    }
};