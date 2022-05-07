class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int temp;
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<matrix[0].length;j++){
                if(j==0) temp=Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                
                else if(j==matrix[0].length-1) temp=Math.min(matrix[i+1][j],matrix[i+1][j-1]);
                
                else  temp=Math.min(matrix[i+1][j],Math.min(matrix[i+1][j+1],matrix[i+1][j-1]));
                
                matrix[i][j]=matrix[i][j]+temp;
            }
        }
        Arrays.sort(matrix[0]);
        return matrix[0][0];
    }
}