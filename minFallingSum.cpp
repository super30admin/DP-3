/* ##################################################################### Recusrive Solution  ##################################################################### */

class Solution {
    unordered_map<int, int> memo;
public:
    int helper(vector<vector<int>>& matrix, int i, int j)
    {
        if (i >= matrix.size() || j >= matrix[0].size()) {
            return 0;
        }

        int idx = (i * matrix[0].size()) + j; //Memoization
        if (memo.find(idx) != memo.end()) {
            return memo[idx];
        } 

        int sum1 = INT_MAX, sum2 = INT_MAX, sum3 = INT_MAX;

        sum1 = matrix[i][j] + helper(matrix, i + 1, j);

        if (j > 0) {
            sum2 = matrix[i][j] + helper(matrix, i + 1, j - 1);
        }

        if (j < matrix[0].size() - 1) {
            sum3 = matrix[i][j] + helper(matrix, i + 1, j + 1);
        }

        memo[idx] = min(sum1, min(sum2, sum3));
        return memo[idx];
    }
    int minFallingPathSum(vector<vector<int>>& matrix) 
    {
        int minSum = INT_MAX;
        for (int i = 0; i < matrix[0].size(); i++) {
            int sum = helper(matrix, 0, i);
            if (sum < minSum) {
                minSum = sum;
            }
        }

        return minSum;
    }
};

/* ##################################################################### Iterative DP Solution  ##################################################################### */

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) 
    {
        int n = matrix.size(), m = matrix[0].size();
        vector<int> dp(m), tempDP(m);

        for (int j = 0; j < m; j++) {
            dp[j] = matrix[n - 1][j];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                int min1 = dp[j];
                int min2 = (j > 0) ? dp[j - 1] : INT_MAX;
                int min3 = (j < m - 1) ? dp[j + 1] : INT_MAX;

                tempDP[j] = matrix[i][j] + min({min1, min2, min3}); 
            }
            dp = tempDP;
        }

        return *min_element(dp.begin(), dp.end());
    }
};
