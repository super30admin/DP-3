
// Solution - 1

// TimeComplexity: O(n²)
// SpaceComplexity: O(n)
// Explanation: I solve it from the bottom row upward. I keep a prev array that stores the minimum path sums from the row below. 
// For each cell, I add its value to the minimum of the three possible downward moves (down, down-left, down-right). After processing a row, I move upward. 
// Finally, I return the minimum value in the top row.
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] prev = matrix[n-1].clone();
        
        for(int i=n-2; i>=0; i--){
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                int down = prev[j];
                int left = (j > 0) ? prev[j - 1] : Integer.MAX_VALUE;
                int right = (j < n - 1) ? prev[j + 1] : Integer.MAX_VALUE;
                
                curr[j] = matrix[i][j] + Math.min(down, Math.min(left, right));
            }
            
            prev = curr; // move upward  
        }
        int min = Integer.MAX_VALUE;

        for (int val : prev) {
            min = Math.min(min, val);
        }
        return min;
        
    }
}


// Solution - 2

// TimeComplexity: O(n²)
// SpaceComplexity: O(1)
// Explanation: Here I modify the matrix directly. Starting from the second-last row, 
// I update each cell by adding the minimum of the three possible cells from the row below. 
// At the end, the first row contains the minimum falling path sums, and I return the minimum among them.

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        for(int i=m-2; i>=0; i--){
            for(int j=0; j<m; j++) {
                int down = matrix[i+1][j];

                int left = (j > 0) 
                        ? matrix[i+1][j-1] 
                        : Integer.MAX_VALUE;

                int right = (j < m-1) 
                            ? matrix[i+1][j+1] 
                            : Integer.MAX_VALUE;

                matrix[i][j] += Math.min(down, Math.min(left, right));
            }   
        }
        int min = Integer.MAX_VALUE;

        for(int i=0; i<m; i++) {
            min = Math.min(min, matrix[0][i]);

        }
        return min;
        
    }
}

// Solution - 3

// TimeComplexity: O(n²)
// SpaceComplexity: O(n²)
// Explanation: I use recursion starting from each column in the first row. From each cell, I recursively explore the three possible downward directions. 
// I store results in dp[r][c] to avoid recomputation, so each cell is solved once.

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        Integer[][] dp = new Integer[m][m];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            min = Math.min(min, helper(matrix, 0, i, m, dp));
        }
        return min;
        
    }

    private int helper(int[][] mat, int r, int c, int m, Integer[][] dp) {
        if(r<0 || c<0 || r>=m || c>=m) return Integer.MAX_VALUE - 10000;
        if(r==m-1) return mat[r][c];
        if(dp[r][c] !=null) return dp[r][c];

        int case1= mat[r][c] + helper(mat, r+1, c-1, m, dp);
        int case2= mat[r][c] + helper(mat, r+1, c, m, dp);
        int case3= mat[r][c] + helper(mat, r+1, c+1, m, dp);
        int min = Math.min(case1, Math.min(case2,case3));
        dp[r][c] = min;
        return min;
    }
}


// Solution - 4

// TimeComplexity: O(3^n)
// SpaceComplexity: O(n)
// Explanation: Here I recursively explore all possible downward paths without memoization. 
// This leads to repeated recomputation of the same subproblems and exponential time complexity.

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            min = Math.min(min, helper(matrix, 0, i, m));
        }
        return min;
        
    }

    private int helper(int[][] mat, int r, int c, int m) {
        if(r<0 || c<0 || r>=m || c>=m) return 101;
        if(r==m-1) return mat[r][c];

        int case1= mat[r][c] + helper(mat, r+1, c-1, m);
        int case2= mat[r][c] + helper(mat, r+1, c, m);
        int case3= mat[r][c] + helper(mat, r+1, c+1, m);
        return Math.min(case1, Math.min(case2,case3));
    }
}
