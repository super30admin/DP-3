
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null)
            return 0;
        for(int i=matrix.length-2;i>=0;i--){
            for(int j=0;j<matrix[0].length;j++){
                if(j==0){
                    matrix[i][j]+=Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                }else if(j==matrix[0].length-1){
                    matrix[i][j]+=Math.min(matrix[i+1][j],matrix[i+1][j-1]); 
                }else{
                    matrix[i][j]+=Math.min(matrix[i+1][j],Math.min(matrix[i+1][j-1],matrix[i+1][j+1])); 
                }
            }
        }
        int result = matrix[0][0];
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]<result)
                result = matrix[0][i];
        }
        return result;
    }
}