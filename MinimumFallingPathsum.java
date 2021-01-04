class Solution {
    public int minFallingPathSum(int[][] A) {
        for(int i=A.length-2; i>=0; i--){
            for(int j=0; j<A[0].length; j++){
                if(j==0)
                    A[i][j] = Math.min(A[i+1][j], A[i+1][j+1])+A[i][j];
                else if(j==A[0].length-1)
                    A[i][j] = Math.min(A[i+1][j], A[i+1][j-1])+A[i][j];
                else
                    A[i][j] = Math.min(A[i+1][j], Math.min(A[i+1][j-1], A[i+1][j+1]))+A[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<A[0].length;i++){
            if(min>A[0][i])
                min = A[0][i];
        }
        return min;
    }
}

//Time complexity : O(m*n) m -number of rows in input and n is the number of columns
//Space complexity : O(1)
