class Solution {


    public int minFallingPathSum(int[][] A) {
        int size = A.length;
        int min = Integer.MAX_VALUE;
        for(int i=1;i<size;i++){
            for(int j=0;j<size;j++){
                if(j==0){
                    A[i][0] += Math.min(A[i-1][0],A[i-1][1]);
                }
                else if(j==size-1){
                    A[i][size-1] += Math.min(A[i-1][size-1],A[i-1][size-2]);
                }
                else{
                    A[i][j] += Math.min(Math.min(A[i-1][j-1],A[i-1][j]),A[i-1][j+1]);
                }
            }

        }

        for(int k=0;k<size;k++){
             min = Math.min(min,A[size-1][k]);
        }

        return min;
    }

}