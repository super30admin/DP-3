// Time Complexity: O(N*M)Where N is no. of rows in matrix and M is the no. of colums in matrix
// Space Complexity: O(N*M) Where N is no. of rows in matrix and M is the no. of colums in matrix
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        if(matrix.size()==0)return 0;
        int rows = matrix.size();
        int cols = matrix[0].size();
        int t[rows][cols];
        for(int i = 0; i < cols;i++)t[0][i]=matrix[0][i];
        
        for(int i = 1; i < rows;i++){
            for(int j = 0; j < cols;j++){
                if(j==0)t[i][j] = matrix[i][j] + min(t[i-1][0],t[i-1][1]);
                else if(j==cols-1)t[i][j] = matrix[i][j] + min(t[i-1][j],t[i-1][j-1]);
                else t[i][j] = matrix[i][j] + min_three(t[i-1][j],t[i-1][j-1],t[i-1][j+1]);                
            }
        }
        int min = INT_MAX;
        for(int i = 0; i < cols;i++){
            if(t[rows-1][i]<min)min = t[rows-1][i];
        }
        return min;
        
    }
    
    int min_three(int a,int b,int c){
        return min(min(a,b),c);
    }
};