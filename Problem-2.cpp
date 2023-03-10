931. Minimum Falling Path Sum

TC O(N^2)
SC O(N)

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        vector<int> dp(matrix.size() + 1, 0);
        for (int row = matrix.size() - 1; row >= 0; row--) {
            vector<int> currentRow(matrix.size() + 1, 0);
            for (int col = 0; col < matrix.size(); col++) {
                if (col == 0) {
                    currentRow[col] =
                        min(dp[col], dp[col + 1]) + matrix[row][col];
                } else if (col == matrix.size() - 1) {
                    currentRow[col] =
                        min(dp[col], dp[col - 1]) + matrix[row][col];
                } else {
                    currentRow[col] =
                        min(dp[col], min(dp[col + 1], dp[col - 1])) +
                        matrix[row][col];
                }
            }
            dp = currentRow;
        }
        int minFallingSum = INT_MAX;
        for (int startCol = 0; startCol < matrix.size(); startCol++) {
            minFallingSum = min(minFallingSum, dp[startCol]);
        }
        return minFallingSum;
    }
};
