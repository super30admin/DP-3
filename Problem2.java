//Minimum Sum Falling Path
//Space complexity : o(1)
//Time Complexity : o(m+n)
public class Problem2 {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix==null || matrix.length==0){return 0;}
        int row= matrix.length-1;
        int col= matrix[0].length;
        
        for(int i=row-1;i>=0;i--){
            for(int j=0;j<col;j++){
             
                if(j==0){
                  matrix[i][j]+=Math.min(matrix[i+1][j],matrix[i+1][j+1]);  
                }else if(j==col-1){
                     matrix[i][j]+=Math.min(matrix[i+1][j],matrix[i+1][j-1]);  
                }else{
                    matrix[i][j]+=Math.min(matrix[i+1][j],Math.min(matrix[i+1][j+1],matrix[i+1][j-1]));
                }
   
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<col;i++){
           min=Math.min(min,matrix[0][i]);
        }
        
        return min;
    }
}
