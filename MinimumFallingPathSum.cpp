//Time Complexity -O(n*n)
//Space Complexity - O(1)
class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        for(int i=matrix.size()-2;i>=0;i--){
            for(int j=0;j<matrix.size();j++){
                    if(j-1>=0&&j+1<matrix.size()){
                        matrix[i][j]=min(matrix[i+1][j-1],min(matrix[i+1][j],matrix[i+1][j+1]))+matrix[i][j];
                    }
                    else if(j-1<0&&j+1<matrix.size()){
                        matrix[i][j]=min(matrix[i+1][j],matrix[i+1][j+1])+matrix[i][j];
                    }
                    else if(j-1>=0&&j+1>=matrix.size()){
                        matrix[i][j]=min(matrix[i+1][j],matrix[i+1][j-1])+matrix[i][j];
                    }
                    else{
                        matrix[i][j]=matrix[i+1][j]+matrix[i][j];
                    }
            }
        }
        int ans=INT_MAX;
        for(int i=0;i<matrix.size();i++){
            ans=min(matrix[0][i],ans);
        }
        return ans;
    }
};