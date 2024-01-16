// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// Idea here is to calculate the min sum in each scenario as value at that location
// plus min of the previous row connected elements. 

#include <vector>

class Solution {
public:
    int minFallingPathSum(std::vector<std::vector<int>>& matrix) {
        int n = matrix.size();
        std::vector<std::vector<int>> dp(n, std::vector<int>(n, 0));
        
        for(int j = 0; j < n; j++)
        {
            dp[0][j] = matrix[0][j];
        }

        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(j == 0 ) // left most column
                {
                    dp[i][j] = matrix[i][j] + std::min(dp[i-1][j], dp[i-1][j+1]);
                }
                else if(j == n-1) // last col
                {
                    dp[i][j] = matrix[i][j] + std::min(dp[i-1][j], dp[i-1][j-1]);
                }
                else // all other columns
                {
                    dp[i][j] = matrix[i][j] + std::min(dp[i-1][j], std::min(dp[i-1][j-1], dp[i-1][j+1]));
                }
            }
        }

        int minValue = INT32_MAX;
        for(int i = 0; i < n; i++)
        {
            minValue = std::min(minValue, dp[n-1][i]);
        }
        return minValue;
    }
};