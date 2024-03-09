// Time Complexity : O(n * m)
//                   ...  n is number of rows in matrix
//                   ...  m is number of columns in matrix
// Space Complexity : O(n * m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Letcode : https://github.com/parag290/DP-3
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
A falling path starts at any element in the first row and chooses the element in the next row 
that is either directly below or diagonally left/right. Specifically, 
the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
*/

/*
This problem is similar to paint house problem with unknown number of paints.

Given matrix is : 
_____________
| 2 | 1 | 3 |
-------------
| 6 | 5 | 4 |
-------------
| 7 | 8 | 9 |
-------------

New dp matrix can be contructed as below - 
____________________
| X | 2 | 1 | 3 | X |        Where X is infinity or MAX_INT in our case
--------------------
| X | 6 | 5 | 4 | X |
--------------------
| X | 7 | 8 | 9 | X |
--------------------
First row is copied from nums to dp as it is.
At location 6, sum can be minimum of (6 + X) or (6 + 2) or (6 + 1)
Two extra columns are added to handle out of bound scenarion when we access dp[i][j-1] and dp[i][j+1]

Answer will be minumum of last row of dp matrix.
*/


#include <climits>
class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int size = matrix.size();
        int rowSize = matrix[0].size();

        vector<vector<int>>dp(size, vector<int>(rowSize+2, INT_MAX));
        for(int i = 0; i<rowSize; i++){
            dp[0][i+1] = matrix[0][i];
        }        

        for(int i =1; i<size; i++){
            for(int j=1; j<=rowSize; j++){
                dp[i][j] = matrix[i][j-1] + min(dp[i-1][j-1], min(dp[i-1][j], dp[i-1][j+1]));
             }
        }
        int minVal = INT_MAX;
        for(int j=1; j<=rowSize; j++){
            minVal = min(minVal, dp[size-1][j]);
        }
        return minVal;
    }
};