// Time Complexity : O(n*m) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes


// Your code here along with comments explaining your approach
/* Bottom up approach by mutating i/p array.
 * Start from second last element and go upwards. 
 * For every element we have three choices to select from :- element at left and right diagonal; element below the current element. 
 * Select the choice which gives minimum value.
 * Return the minimum from first row..
 */


class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
       // Bottom up approach by mutating i/p array
       // TC - O(n*m) 
       // SC - O(1) Original i/p array updated.
        int m = matrix[0].size();
        int n = matrix.size();
        
        for (int i = n - 2; i >= 0; i--)
        {
            for (int j = 0; j < m ; j++)
            {
                if (j == 0)
                {
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j+1]);
                }
                else if (j == m - 1)
                {
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j-1]);
                }
                else
                {
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], min(matrix[i+1][j+1], matrix[i+1][j-1]));
                }
            }
        }
        
        return *min_element(matrix[0].begin(), matrix[0].end());
    }
};