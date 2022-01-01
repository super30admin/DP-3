public class MinFallingPathSum {
    int [][] memo;
    public int minFallingPathSum(int[][] matrix) {
   
        memo = new int [matrix.length][matrix[0].length];
   
        int result=Integer.MAX_VALUE;
        int minResult=Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++){
           result= helper(matrix,0,i);
            minResult = Math.min(minResult,result);
        }
        
        return minResult;
    }
    
    public int helper(int [][]matrix, int row, int col){
        
         
           if(row==matrix.length){
               return 0;
           }
        
          if(memo[row][col]!=0){
               return memo[row][col];
           }
        
        
            int r1=Integer.MAX_VALUE,r2=Integer.MAX_VALUE,r3=Integer.MAX_VALUE;
            int minAns=0;
             if( col-1>=0)
            r1=helper(matrix,row+1,col-1)+matrix[row][col];
        
          
            r2=helper(matrix,row+1,col)+matrix[row][col];
        
             if(col+1<matrix[0].length)
            r3=helper(matrix,row+1,col+1)+matrix[row][col];
        
            minAns= Math.min(r1, Math.min(r2,r3));
     
        memo[row][col]=minAns;
        return minAns;
    }
}
