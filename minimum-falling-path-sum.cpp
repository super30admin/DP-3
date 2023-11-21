/*Start from the second-to-last row and, for each element, add the minimum falling path sum from the row below.
At each element, choose the minimum value from the three adjacent elements in the row below.
Update the current element with the sum and continue the process.
Finally, find the minimum value in the first row, which represents the minimum falling path sum.

Time Complexity: O(N^2), where N is the size of the matrix.
Two nested loops iterate through each element of the matrix.
Space Complexity: O(1), as the changes are made directly to the input matrix without using additional space.*/
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
         for (int row = matrix.size() - 2; row >= 0; row--) {
            for (int col = 0; col < matrix.size(); col++) {
                int best = matrix[row + 1][col];
                if (col > 0)
                    best = min(best, matrix[row + 1][col - 1]);
                if (col + 1 < matrix.size())
                    best = min(best, matrix[row + 1][col + 1]);
                matrix[row][col] += best;
            }
        }
        return *min_element(matrix[0].begin(), matrix[0].end());
    }
};