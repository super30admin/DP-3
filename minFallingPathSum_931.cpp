// Time Complexity : O(MN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        if(matrix.empty() || matrix.size() == 0){
            return 0;
        }
        for(int i=matrix.size()-2; i>=0; i--){
            for(int j=matrix[0].size()-1; j>=0; j--){
                if(j==0)
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1]);
                    
                else if(j == matrix.size()-1)
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1]);
                else
                    matrix[i][j] += min(matrix[i+1][j+1], min(matrix[i+1][j], matrix[i+1][j-1]));
            }
        }
        int m = INT_MAX;
        for(int i=0; i<matrix.size(); i++){
                m = min(m, matrix[0][i]);
        }
        return m;
    }
};
