//Time complexity: O(n*n)
//Space complexity: O(1)

//Approach: idea is to start with a second last row and keep chosing minimum value form one row below it. then onwards keep going until first row.
//in the end calculate minimum between all the column values.

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int m=matrix.size();
        int n=matrix[0].size();

        for(int i=n-2; i>=0; --i)
        {
            for(int j=0;j<n;j++)
            {
                if(j==0)
                {
                    matrix[i][j]=matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j+1]);
                }
                else if(j==n-1)
                {
                    matrix[i][j]=matrix[i][j]+ min(matrix[i+1][j],matrix[i+1][j-1]);
                }
                else
                {
                    matrix[i][j]=matrix[i][j]+min(min(matrix[i+1][j],matrix[i+1][j+1]), matrix[i+1][j-1]);
                }
            }
        }
        int min_=INT_MAX;
        for(int i=0;i<n;++i)
        {
            min_=min(min_, matrix[0][i]);
        }
        return min_;
    }
};