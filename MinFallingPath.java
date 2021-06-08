//Time Complexity: O(n^2)
//Space Complexity: O(1)
// Leetcode: #931

class Solution {
    
   /* public int minFallingPathSum(int[][] matrix) {
        helper();
    }
    
    helper(int[][] matrix, int row, int col, int sum)
    {
        
        //case1: choose col-1
        
        //case2: choose col
        
        //case3: choose col+1
        
    }*/
    
    // similar to paint house problem
       public int minFallingPathSum(int[][] matrix) {
       
           int n=matrix.length;
           
           if(n==1)
               return matrix[0][0];
           
           
           //[[2,1,3],
           // [6,5,4],
           // [7,8,9]]
          // start from last row=> In the above example start from 7. if 7 is picked then we can add min(6,5,4) from the above row to 7 to form the falling sum.
           // similarly in 2nd row if 6 is picked then, we can add min(2,1,3) from 1st row to 6 to form the falling sum.
           // Now write the algorithm from top row.
           for(int i=1;i<n;i++)
           {
              
               for(int j=0;j<n;j++)
               {
                   if(j==0)
                   {
                       matrix[i][j]+=Math.min(matrix[i-1][j], matrix[i-1][j+1]);
                   }
                   else if( j==n-1)
                   {
                        matrix[i][j]+=Math.min(matrix[i-1][j-1], matrix[i-1][j]);
                   }
                   else
                   {
                         matrix[i][j]+=Math.min(matrix[i-1][j-1],Math.min(matrix[i-1][j], matrix[i-1][j+1]));
                   }
               }
           }
           
           int res=matrix[n-1][0];
           for(int j=1;j<n;j++)
           {
               res=Math.min(res,matrix[n-1][j]);
           }
           
           return res;
    }
    
}