
// Time Complexity : O(m*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes

// we add matrix value to the minimum that we get from other row

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        for(int i=1;i<matrix.size();i++)
        {
            for(int j=0; j<matrix[0].size();j++)
            {
                if(j==0)
                {
                    matrix[i][j] = min(matrix[i-1][j],matrix[i-1][j+1]) + matrix[i][j];
                }
                else if(j== matrix[0].size()-1)
                {
                    matrix[i][j] = min(matrix[i-1][j],matrix[i-1][j-1]) + matrix[i][j];
                }
                else
                {
                    matrix[i][j] = min(matrix[i-1][j-1],min(matrix[i-1][j],matrix[i-1][j+1])) + matrix[i][j];
                }
            }
        }
        int ans = INT_MAX;
        for(int i=0;i<matrix[0].size();i++)
        {
            ans = min(ans,matrix[matrix.size()-1][i]);
        }
        return ans;
    }
};