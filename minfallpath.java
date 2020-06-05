// Time Complexity :O(n^2) as the input is a square of integers A with n rows and n columns
// Space Complexity :O(1) as there is no Auxiliary space
// Did this code successfully run on Leetcode :yes 
class Solution {
    public int minFallingPathSum(int[][] A) {
        int n=A.length;
        int m=A[0].length;
        int min=Integer.MAX_VALUE;
     for(int i=1;i<n;i++)
     {
         for(int j=0;j<m;j++)
         {
             if(j==0)
                 A[i][j]+=Math.min(A[i-1][j],A[i-1][j+1]); // first column can only compare value with its right side column
             
             else if(j==m-1)
                 A[i][j]+=Math.min(A[i-1][j],A[i-1][j-1]); // last column can only compare value with its left side column
             
             else
                 A[i][j]+=Math.min(A[i-1][j-1],Math.min(A[i-1][j],A[i-1][j+1]));
     
         }
         
     }
        
     
    for(int j=0;j<m;j++)
    {
        min=Math.min(A[n-1][j],min);// surfing through the entire last row and finding out the minimum
    }
        
        
    
      return min;  
    }
}