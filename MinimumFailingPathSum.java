class Solution {
    public int minFallingPathSum(int[][] A) {
        if(A==null || A.length == 0){
            return 0;
        }
        int r = A.length;
        int c = A[0].length;
        int min = Integer.MAX_VALUE;
        for(int i=1;i<r;i++){
          for(int j=0;j<c;j++){
            if(j==0){
                A[i][j] = A[i][j] + Math.min(A[i-1][j],A[i-1][j+1]);
            }else if(j==c-1){
                A[i][j] = A[i][j] + Math.min(A[i-1][j],A[i-1][j-1]);
            }else{
                A[i][j] = A[i][j] + Math.min(A[i-1][j+1],Math.min(A[i-1][j],A[i-1][j-1]));
            }
          }      
        }
        for(int j=0;j<c;j++){
            min = Math.min(min,A[r-1][j]);
        }
        return min;
    }
}