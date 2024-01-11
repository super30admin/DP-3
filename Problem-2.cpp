// Time Complexity : O(N)

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: First solved it using recursion, the did tabulation
// to avoid TLE and avoid using stack space for dp.

// 931. Minimum Falling Path Sum

#include <bits/stdc++.h>
using namespace std;


class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        if(matrix.size() == NULL) return 0;
        int n = matrix.size();
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                if(j==0){
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j+1],matrix[i+1][j]);
                }
                else if(j==n-1){
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j],matrix[i+1][j-1]);
                }
                else{
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j],min(matrix[i+1][j-1],matrix[i+1][j+1]));
                }
            }
        }
        int minVal = INT_MAX;
        for(int j = 0;j<n;j++){
            minVal = min(minVal,matrix[0][j]);
        }
        return minVal;
    }
};