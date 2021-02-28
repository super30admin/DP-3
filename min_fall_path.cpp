//TC: O(n*n) where n*n is the matrix dimension
//SC: O(1) since no additional space is being used. 


class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        
        for(int i=matrix.size()-2; i>=0; i--){
            
            for(int j=0; j<matrix[0].size(); j++){
                if(j == 0){
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1]);
                } 
                else if(j==matrix[0].size()-1){
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1]);
                } 
                else {
               matrix[i][j] += min(min(matrix[i+1][j], matrix[i+1][j+1]), matrix[i+1][j-1]);
                }
            }
            
        }
        
        int low = INT_MAX ;
        for(int i=0; i<matrix[0].size(); i++){
            if(matrix[0][i] < low)
                low = matrix[0][i];
        }
        
        return low;
        
    }
};