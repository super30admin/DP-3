//Bottom up dp approach
class Solution {
    public int minFallingPathSum(int[][] A) {
       int m = A.length;
        int n = A[0].length;
        //int dp[][] = new int[m][n];
       
       
        for(int i = m-2;i>=0;i--){
            for(int j= 0;j<n;j++){
               
               //  minimum calculated by taking Math.min(A[i+1][j-1],Math.min(A[i+1][j],A[i+1][j+1])); for 1st case and last case out of bounds error
                int min = A[i+1][j];
              //for last column  
                if(j > 0)
                    min= Math.min(min,A[i+1][j-1]);
               
                 if(j+1 < n)
                      min= Math.min(min,A[i+1][j+1]);
               
                A[i][j] += min;
               
            }
        }
        int minResult = Integer.MAX_VALUE;
        for(int num : A[0])
            minResult =  Math.min(minResult,num);  // A[0] contains results
            return minResult;
       
    }
}

/*
Time Complexity = O(mxn) visited every element in the matrix
Space Complexity = O(1) same space used
*/