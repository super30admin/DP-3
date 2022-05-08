//TC = O(n*n)
//SC = O(1)
class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int n = matrix.size();
        if(n == 0) return 0; //Matrix is empty
        
        for(int i=n-2;i>=0;i--){
            for(int j=n-1;j>=0;j--)
            {
                if(j==0){//left most element
                    matrix[i][j] += std::min(matrix[i+1][j],matrix[i+1][j+1]);
                }else if(j==n-1){ //right most element
                    matrix[i][j] += std::min(matrix[i+1][j-1],matrix[i+1][j]);
                }else{//other elements
                    matrix[i][j] += std::min(matrix[i+1][j-1], std::min(matrix[i+1][j],matrix[i+1][j+1]));
                }
            }
        }
        int result =10001;
        for(int i=0;i<n;i++)
            result = std::min(result,matrix[0][i]);
        return result;
    }
}; 
