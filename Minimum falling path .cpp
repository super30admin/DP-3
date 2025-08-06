class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();

        vector<vector<int>> dp = matrix; // initalize the dp with matirx

        for(int i = m - 2; i >= 0; i--) { // use same paint house logic
            for(int j=0;j<n;j++)
            {
              int down = dp[i + 1][j];
              int leftDiag = (j > 0) ? dp[i + 1][j - 1] : INT_MAX;
              int rightDiag = (j < n - 1) ? dp[i + 1][j + 1] : INT_MAX;

              dp[i][j] += min({down, leftDiag, rightDiag});

            }
        }

         int minVal = dp[0][0]; //take minimum in first row
         for (int j = 1; j < dp[0].size(); j++) {
            if (dp[0][j] < minVal) {
                minVal = dp[0][j];
        }
     }
        return minVal;
        
    }
};