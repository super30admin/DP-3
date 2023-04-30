// Time Complexity :O(matrix.size())
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Approach is similar to paint house problem


class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {

        int m=matrix.size();
        int n=matrix[0].size();

        for(int i=m-2;i>=0;i--)
        {
            for(int j=0;j<n;j++)
            {
                if(j==0)
                matrix[i][j]= matrix[i][j]+min(matrix[i+1][j+1],matrix[i+1][j]);
                else if(j==n-1)

                matrix[i][j]=matrix[i][j]+min(matrix[i+1][j-1],matrix[i+1][j]);
                else
                matrix[i][j]=matrix[i][j]+min(matrix[i+1][j+1],min(matrix[i+1][j-1],matrix[i+1][j]));
            }
        }
        int ans=INT_MAX;
        for(int i=0;i<n;i++)
        {
            ans=min(ans,matrix[0][i]);
        }
        return ans;

    }
};