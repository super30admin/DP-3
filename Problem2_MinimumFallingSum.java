// Time Complexity : O(n*n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    //Recursive Solution
    /*
    public int minFallingPathSum(int[][] matrix) {
        
       if(matrix.length==0 || matrix==null)
           return 0;
        if(matrix.length==1)
            return matrix[0][0];
        
        int minPath = Integer.MAX_VALUE;
        for (int col = 0; col < matrix[0].length; col++) {
            minPath = Math.min(minPath, recurse(matrix, matrix.length-1, col));
        }
        return minPath;
}
 private int recurse(int[][] matrix,int row,int col)
 {
     if (row == 0) {
            return matrix[row][col];
        }
        
        // default value
        int res = Integer.MAX_VALUE;
        
        // path from top left
        if (col > 0) {
            res = Math.min(res, recurse(matrix, row - 1, col - 1));
        }
        
        // path from top
        res = Math.min(res, recurse(matrix, row - 1, col));
        
        // path from top right
        if (col < matrix[0].length - 1) {
            res = Math.min(res, recurse(matrix, row - 1, col + 1));
        }
        
        return res + matrix[row][col];
    }
    */
 
    // DP Approach
     public int minFallingPathSum(int[][] matrix) {
         
         if(matrix.length==0 || matrix==null)
             return 0;
        if(matrix.length==1)
            return matrix[0][0];
        
       for(int i=matrix.length-2;i>=0;i--)
       {
           for(int j=0;j<matrix[i].length;j++)
           {
               if(j==0)
               {
                   matrix[i][j]+=Math.min(matrix[i+1][j],matrix[i+1][j+1]); 
               }
               if(j==matrix[i].length-1)
            	   matrix[i][j]+=Math.min(matrix[i+1][j],matrix[i+1][j-1]); 
               else
               {
            	   if(j>0 && j<matrix[i].length-1)
                   matrix[i][j]+=Math.min(matrix[i+1][j-1],Math.min(matrix[i+1][j],matrix[i+1][j+1]));
            		   
               }
              
           }
       }
       
       int minValue=Integer.MAX_VALUE;
       
       for(int i=0;i<matrix[0].length;i++)
       {
           minValue=Math.min(minValue,matrix[0][i]);
       }
       
       return minValue;
   }
}
