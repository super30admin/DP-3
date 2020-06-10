//Top down dp approach
class Solution {
    public int minFallingPathSum(int[][] A) {
       int m = A.length;
        int n = A[0].length;
     
        for(int i = 1;i<m;i++){
            for(int j= 0;j<n;j++){
              if(j==0)
                  A[i][j] += Math.min(A[i-1][j],A[i-1][j+1]);
               else if(j== m-1)
                   A[i][j] += Math.min(A[i-1][j-1],A[i-1][j]);
               else
                A[i][j] += Math.min(A[i-1][j-1],Math.min(A[i-1][j],A[i-1][j+1]));
            }}      
               
        int minResult = Integer.MAX_VALUE;
        for(int num : A[m-1])
            minResult =  Math.min(minResult,num);  // A[0] contains results
            return minResult;
       
    }
}

/*
Time Complexity = O(mxn) visited every element in the matrix
Space Complexity = O(1) same space used
*/