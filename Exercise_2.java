class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for(int i=1; i<n; ++i){
            for(int j=0; j<n; ++j){
                int dl = j==0 ? Integer.MAX_VALUE : matrix[i-1][j-1];
                int up = matrix[i-1][j];
                int dr = j==n-1 ? Integer.MAX_VALUE : matrix[i-1][j+1];
                
                matrix[i][j] += Math.min(dl,Math.min(up, dr));
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j<n; ++j){
            ans = Math.min(ans, matrix[n-1][j]);
        }
        return ans;
    }
}
//tc=O(n^2)
//sc=O(1)
