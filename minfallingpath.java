//Time complexity:O(n*n)
//Space complexity:O(1)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        for(int i=matrix.length-2;i>=0;i--){
            for(int j=0;j<matrix[0].length;j++){
                if(j==0){
                    matrix[i][j]+=Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                }
                else if(j==matrix[0].length-1){
                    matrix[i][j]+=Math.min(matrix[i+1][j],matrix[i+1][j-1]);
                }else{
                    matrix[i][j]+=Math.min(matrix[i+1][j+1],Math.min(matrix[i+1][j],matrix[i+1][j-1]));
                }
            }
        }
        int result=Integer.MAX_VALUE;
        
        for(int j=0;j<matrix[0].length;j++){
              result=Math.min(result,matrix[0][j]);  
        }
        return result;
    }
}