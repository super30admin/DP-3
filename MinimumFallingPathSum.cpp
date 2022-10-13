// Approach - Bottom up DP and modifying the given matrix.
// Time Complexity - O(n^2)
// Space Complexity - O(1)
// It runs on Leetcode
// Problems Faced - No!

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int answer = INT_MAX;
        int m = matrix.size();
        int n = matrix[0].size();
        
        for(int i = m-2; i >= 0; i--){
            for(int j = 0; j < n; j++){
                if(j == 0)
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j+1]);
                else if(j == n-1)
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j-1]);
                else
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], min(matrix[i+1][j-1], matrix[i+1][j+1]));
            }
        }
        for(int i = 0; i < n; i++){
            if(matrix[0][i] < answer)
                answer = matrix[0][i];
        }
        return answer;
    }
};