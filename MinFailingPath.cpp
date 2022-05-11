// Time Complexity : (row x col)
// Space Complexity : (row x col)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO


class Solution {
public:
    vector<vector<int>> dir = {{1,-1},{1,0},{1,1}};
    int helper(vector<vector<int>>& matrix, int r, int c, vector<vector<int>> &dp) {
        if(r == matrix.size()-1) {
            return matrix[r][c];
        }
        if(dp[r][c] != -1) {
            return dp[r][c];
        }
        int ans = INT_MAX;
        for(auto d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];
            if(nr >= 0 && nc >= 0 && nr < matrix.size() && nc < matrix[0].size()) {
                ans = min(ans, helper(matrix, nr, nc, dp));
            }
        }
        return dp[r][c] = matrix[r][c] + ans;
    }
    int minFallingPathSum(vector<vector<int>>& matrix) {
        vector<vector<int>> dp(matrix.size(), vector<int>(matrix[0].size(), -1));
        int ans = INT_MAX;
        for(int i=0;i<matrix[0].size();i++) {
            ans = min(ans, helper(matrix, 0, i, dp));
        }
        return ans;
    }
};