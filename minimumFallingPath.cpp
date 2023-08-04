class Solution {
public:
    
    int solve(int i, int j, vector<vector<int>>& matrix, vector<vector<int>>& dp){
        int  m =matrix[0].size();
        if(j<0 || j>m-1) return 1e9;
        if(i==0) return matrix[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        
        int st = matrix[i][j] + solve(i-1,j,matrix,dp);
        int ld = matrix[i][j] + solve(i-1,j+1,matrix,dp);
        int rd = matrix[i][j] + solve(i-1,j-1,matrix,dp);
        
        return dp[i][j] = min(st,min(ld,rd));
    }
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int n = matrix.size();
        int m = matrix[0].size();
        vector<vector<int>> dp(n,vector<int>(m,-1));
        int ans=1e9;
        for(int j=0;j<m;j++){
            ans=min(ans,solve(n-1,j,matrix,dp));
        }
        return ans;
    }
};