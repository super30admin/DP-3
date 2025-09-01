// Problem - Minimum falling path sum
//  Time Complexity : O(n*n)
//  Space Complexity : O(n*n)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We take a 2D matrix and store the results of the first row
// 2. Now we go the next row and check for valid cases and calculate the min
// from all three cases
// 3. At last we calculate minimum from the last row values and return it

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int minFallingPathSum(vector<vector<int>> &matrix) {
    int n = (int)matrix.size();
    vector<vector<int>> dp(n + 1, vector<int>(n + 1, INT_MAX));
    for (int j = 0; j < n; j++) {
      dp[0][j] = matrix[0][j];
    }

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int diagL = INT_MAX;
        int diagR = INT_MAX;
        if (j - 1 >= 0) {
          diagL = dp[i - 1][j - 1];
        }
        if (j + 1 < n) {
          diagR = dp[i - 1][j + 1];
        }
        int calc = min({dp[i - 1][j], diagL, diagR});
        dp[i][j] = matrix[i][j] + calc;
      }
    }

    int mini = INT_MAX;
    for (int i = 0; i < n; i++) {
      mini = min(dp[n - 1][i], mini);
    }
    return mini;
  }
};
