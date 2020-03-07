//o(n^2) time and space
//passed all leetcode cases
//used dp

class Solution {
    public int minFallingPathSum(int[][] A) {
        int m = A.length;
        int n= A[0].length;
        int min = Integer.MAX_VALUE;
        int[][] grid = new int [m][n];
        for(int i=0;i<n;i++){
            grid[0][i] = A[0][i];
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    grid[i][j] = A[i][j]+Math.min(grid[i-1][0],grid[i-1][1]);
                }
                else if(j==n-1){
                    grid[i][j] = A[i][j]+Math.min(grid[i-1][n-2],grid[i-1][n-1]);
                }else {
                    grid[i][j] = A[i][j] + Math.min(grid[i-1][j-1],Math.min(grid[i-1][j],grid[i-1][j+1]));
                }

            }
        }
        for(int i=0;i<n;i++){
            if(min>grid[n-1][i]){
                min = grid[n-1][i];
            }
        }
        return min;

    }
}