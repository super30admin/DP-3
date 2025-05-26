// Time Complexity O(m*n)
// Space Complexity O(n)
class Solution {
    int minimum(const vector<int>& vec, int j) {
        int n = vec.size();
        int minz = INT_MAX;
        if (j < 0 || j >= n) {
            return minz;
        }
        minz = min(minz, vec[j]);
        if (j-1 >= 0) {
            minz = min(minz, vec[j-1]);
        }
        if (j+1 < n) {
            minz = min(minz, vec[j+1]);
        }
        return minz;
    }

public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        vector<int> memo(n, 0);
        for (int j = 0; j < n; j++) {
            memo[j] = matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            vector<int> copy = memo;
            for (int j = 0; j < n; j++) {
                memo[j] = matrix[i][j] + minimum(copy, j);
            }
        }

        return *min_element(memo.begin(), memo.end());
    }
};