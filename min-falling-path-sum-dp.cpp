// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>
  
using namespace std; 

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int r = matrix[0].size();
        int c = matrix.size();
        vector<int> dp = matrix[r - 1];
        for(int i = r - 2; i >= 0; i--){
            vector<int> temp = dp; 
            for(int j = 0; j < c; j++){
                if(j == 0){
                    dp[j] = matrix[i][j] + min(temp[j], temp[j + 1]);
                }
                else if(j == c - 1){
                    dp[j] = matrix[i][j] + min(temp[j - 1], temp[j]);
                }
                else{
                    dp[j] = matrix[i][j] + min(min(temp[j], temp[j + 1]), temp[j - 1]);
                }
            }
        }
        int minimum = INT_MAX;
        for(int i = 0; i < c; i++){
            if(minimum > dp[i]){
                minimum = dp[i];
            }
        }
        return (minimum);
    }
};