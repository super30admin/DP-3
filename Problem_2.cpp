/*
 ? Problem: Minimum Falling Path Sum
 * Time Complexity : O(n x n)
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

#include <vector>

class Solution {
public:
    int minFallingPathSum(std::vector<std::vector<int>>& matrix) {
        int n = matrix.size();

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    matrix[i][j] = matrix[i][j] + std::min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                } else if (j == n - 1) {
                    matrix[i][j] = matrix[i][j] + std::min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                } else {
                    matrix[i][j] = matrix[i][j] + std::min(matrix[i + 1][j], std::min(matrix[i + 1][j - 1], matrix[i + 1][j + 1]));
                }
            }
        }

        // Minimum value in the first row
        return *min_element(matrix[0].begin(), matrix[0].end());
    }
};