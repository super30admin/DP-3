//Time Complexity = O(M*N)
//Space Complexity = O(M*N)               When the interviewer asks not to mutate the original matrix.
//                   O(1)                 When the interviewer allows you to mutate the original matrix.

class Solution {
public:
    int findmin(vector<vector<int>>& matrix)
    {
        int mini=INT_MAX;
        for(int i=0;i<matrix[0].size();i++)
            mini=min(mini,matrix[0][i]);
        return mini;
    }
    int minFallingPathSum(vector<vector<int>>& matrix) {
        if(matrix.size()>1)
        {
        int row = matrix.size();
        int col = matrix[0].size(),i,j;
        for(i=matrix.size()-2;i>=0;i--)
            for(j=0;j<col;j++)
            {
                if(j==0)
                    matrix[i][j] += min(matrix[i+1][j],matrix[i+1][j+1]);
                else if(j==col-1)
                    matrix[i][j] += min(matrix[i+1][j],matrix[i+1][j-1]);
                else
                    matrix[i][j] += min(matrix[i+1][j-1],min(matrix[i+1][j],matrix[i+1][j+1]));
            }
        }
        return findmin(matrix);
    }
};
