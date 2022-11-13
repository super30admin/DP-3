// Time Complexity : O(n^2) where n is the size of the nxn matrix
// Space Complexity : O(1) we are changing the input matrix
// Did this code successfully run on Leetcode : Yes

/*
Bottom up appraoch, we add the min of the 2 choices we have in the corners, and the min of all 3 options for all mid elements 
*/

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int m=matrix.size();
        if(m == 0 )
            return 0;
        for(int i=m-2; i>=0; i--)
            for(int j=0; j<m; j++){
                //edge case
                //first row of elements
                if(j==0)
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1]);
                //last row of elements
                else if(j==matrix[0].size()-1)
                    matrix[i][j] += min(matrix[i+1][j-1], matrix[i+1][j]);
                //all middle elements
                else
                    matrix[i][j] += min(matrix[i+1][j-1], min(matrix[i+1][j], matrix[i+1][j+1]));
            }
            //another loop over the first row to get the min
            int result = INT_MAX;
            for(int i=0; i<m; i++){
                result = min(matrix[0][i], result);
            }
            return result;
    }
};