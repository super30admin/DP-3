// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// We start filling from the bottom, by copying over the last row of the matrix into our dp array
// Then for eahc cell, we can fill the value by checking the min values between its neighbors (down, down right and down left)
// The final answer will be the min element in the dp array after we go over all the rows

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int m = matrix.size(); int n = matrix[0].size();

        vector<int> dp(n);
        for(int j=0; j<n; j++) {
            dp[j] = matrix[m-1][j];
        }

        for(int i=m-2; i>=0; i--) {
            vector<int> temp = dp;
            for(int j=n-1; j>=0; j--) {
                if(j == 0) {
                    dp[j] = matrix[i][j] + min(temp[j], temp[j+1]); // min(down, down right)
                } else if(j == n-1) {
                    dp[j] = matrix[i][j] + min(temp[j], temp[j-1]); // min(down, down left)
                } else {
                    dp[j] = matrix[i][j] + min(temp[j], min(temp[j-1], temp[j+1])); // min(down, down left, down right)
                } 
            }
        }

        return *min_element(dp.begin(), dp.end());
    }
};