//Time Complexity : O(n^2)
//Space Complexity : O(n^2)
#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        if (matrix.size() == 1) {
            return matrix[0][0];
        }
        int n = matrix.size();
        vector<vector<int>> dp(matrix); 
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int mini = dp[i + 1][j];
                if (j > 0) {
                    mini = min(mini, dp[i + 1][j - 1]);
                }
                if (j < n - 1) {
                    mini = min(mini, dp[i + 1][j + 1]);
                }
                dp[i][j] += mini;
            }
        }

        int ans = INT_MAX;
        for (int x : dp[0]) {
            ans = min(ans,x);
        }
        return ans;
    }
};