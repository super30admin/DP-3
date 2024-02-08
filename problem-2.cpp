// 931. Minimum Falling Path Sum
// Time Complexity : O(n*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    
Iterating through the matrix from the second last row to the first row. At each cell, it calculates the minimum falling 
path sum by considering the minimum value from the cell directly below and its adjacent cells. The final result is the 
minimum value from the first row, representing the minimum falling path sum starting from any cell in the first row and reaching the last row.

*/

int minFallingPathSum(vector<vector<int>>& matrix) {
    int n = matrix.size(), min = INT_MAX, k;
    for(int i = n-2; i >= 0; i--)
    {
        for(int j = 0; j < n; j++)
        {
            if(j==0)
                matrix[i][j] = matrix[i][j] +  (matrix[i+1][j] < matrix[i+1][j+1]?matrix[i+1][j]:matrix[i+1][j+1]);
            else if(j==n-1)
                matrix[i][j] = matrix[i][j] +  (matrix[i+1][j] < matrix[i+1][j-1]?matrix[i+1][j]:matrix[i+1][j-1]);
            else
            {
                k = (matrix[i+1][j] < matrix[i+1][j+1]?matrix[i+1][j]:matrix[i+1][j+1]);
                k = k < matrix[i+1][j-1] ? k : matrix[i+1][j-1];
                matrix[i][j] = matrix[i][j] + k;
            }
        }
    }
    for(int i = 0; i < n ; i++)
    {
        if(matrix[0][i] < min)
            min = matrix[0][i];
    }
    return min;
}

