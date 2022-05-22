class Solution {
    int rows=0, cols=0;
    int[][] matrix;
    int[][] dp;
    
    public int minFallingPathSum(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        this.matrix = matrix;
        dp = new int[rows][cols];
        for(int r=0; r<rows; r++){
            Arrays.fill(dp[r], -1);
        }
        
        int minPath = Integer.MAX_VALUE;
        for(int c=0; c<cols; c++){
            minPath = Math.min(minPath, explore(rows-1, c));
        }
        return minPath;
    }
    
    private int explore(int r, int c){
        if(r==0){
            if(c<cols && c>= 0) return matrix[0][c];
            else return Integer.MAX_VALUE;
        }
        if(c<0 || c>= cols) return Integer.MAX_VALUE;
        if(dp[r][c] != -1) return dp[r][c];
        int up = explore(r-1, c);
        int left = explore(r-1, c-1);
        int right = explore(r-1, c+1);
        
        int path = Math.min(left, right);
        path = Math.min(path, up);
        return dp[r][c] = path+matrix[r][c];
    }
}
