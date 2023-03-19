class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int n = matrix.size();
        int min = INT_MAX;
        for(int i =n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                if(j==0){
                matrix[i][j] = matrix[i][j]+std::min(matrix[i+1][j],matrix[i+1][j+1]);
                }
                else if(j==n-1){
                matrix[i][j] = matrix[i][j]+std::min(matrix[i+1][j],matrix[i+1][j-1]);
                }
                else{
                matrix[i][j] = matrix[i][j]+std::min(matrix[i+1][j],std::min(matrix[i+1][j-1],matrix[i+1][j+1]));
                }
            }
        }
        for(int i=0;i<n;i++){
              if(matrix[0][i]<min){
                        min = matrix[0][i];
                    }
        }
    return min;
    }
};