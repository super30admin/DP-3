// Time Complexity : O(n^2)
// Space Complexity : O(1) no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Minimum Falling Path Sum

#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

class Solution {
    public:
    int minFallingPathSum(vector<vector<int>>& matrix){
        if(matrix.empty())
            return 0;

        int n = matrix.size();
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j == 0){
                    matrix[i][j] = matrix[i][j] + std::min(matrix[i-1][j], matrix[i-1][j+1]);
                } else if(j == n -1){
                    matrix[i][j] = matrix[i][j] + std::min(matrix[i-1][j], matrix[i-1][j-1]);
                } else {
                    matrix[i][j] = matrix[i][j] + std::min(matrix[i-1][j-1], std::min(matrix[i-1][j], matrix[i-1][j+1]));
                }
            }
        }
        int min = INT_MAX;
        for(int i = 0; i < n; i++){
            min = std::min(min, matrix[n-1][i]);
        }
        return min;
    }
};