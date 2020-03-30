/**
 * Time Complexity - O(n*m)
 * Space Complexity - O(1) - Inplace
 * This code ran on leetcode
 */

class Solution {
    public int minFallingPathSum(int[][] A) {

        if(A == null){
            return 0;
        }

        int n = A.length;
        int m = A[0].length;

        for(int i=1; i< n;i++){
            for(int j=0; j<m;j++){
                if(j==0){

                    A[i][j] += Math.min(A[i-1][j],A[i-1][j+1]);

                }else if(j==m-1){
                    A[i][j] += Math.min(A[i-1][j-1],A[i-1][j]);

                }else{
                    A[i][j] += Math.min(A[i-1][j-1], Math.min(A[i-1][j], A[i-1][j+1]));
                }
            }
        }
        int min = 101;
        for(int i=0; i<m;i++){
            if(A[n-1][i] < min){
                min = A[n-1][i];
            }
        }
        return min;
    }
}