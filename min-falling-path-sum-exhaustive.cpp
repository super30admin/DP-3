// Time Complexity : O(n^3)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>
  
using namespace std; 

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int sum = INT_MAX;
        for(int i = 0; i < matrix[0].size(); i++){
            sum = min(sum, helper(matrix, 0, i));
        }
        return sum;
    }
    int helper(vector<vector<int>>& matrix, int i, int j){
        int left = INT_MAX;
        int mid = INT_MAX;
        int right = INT_MAX;
        //base
        if(i == matrix[0].size() - 1) return matrix[i][j];

        //logic
        if(j == 0){
            mid = helper(matrix, i + 1, j);
            right = helper(matrix, i + 1, j + 1);
        }
        else if(j == matrix[0].size() - 1){
            left = helper(matrix, i + 1, j - 1);
            mid = helper(matrix, i + 1, j);
        }
        else{
            left = helper(matrix, i + 1, j - 1);
            mid = helper(matrix, i + 1, j);
            right = helper(matrix, i + 1, j + 1);
        }
        return(matrix[i][j] + min(min(left, mid), right));
    }
};