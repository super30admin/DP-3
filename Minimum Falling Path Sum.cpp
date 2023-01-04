// TC = O(n)
// SC = O(1)

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        // null
        if(matrix.size() == 0) return 0;
        int n = matrix.size();
        // bottom up DP startig from the 2nd last row
        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j < n ; j++) {
                // 1st & last col has 2 choices below
                if(j == 0) matrix[i][j] += min(matrix[i + 1][j],matrix[i + 1][j + 1]);
                else if (j == n - 1) matrix[i][j] += min(matrix[i + 1][j - 1],matrix[i + 1][j]);
                // else has 3 choices
                else  matrix[i][j] += min(matrix[i + 1][j - 1], min(matrix[i + 1][j], matrix[i + 1][j + 1]));
            }
        }
        // finding & returning min from the 1st row
        int minVal = INT_MAX;
        for(int j = 0; j <n; j++) 
            minVal = min(minVal, matrix[0][j]);
        return minVal;
    }

};