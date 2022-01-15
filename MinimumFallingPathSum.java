// DP Approach
// Form a matrix to store probalble summation solutions from the denominations.
// Check for number of probable solutions by adding the number of previous coins used plus the Denomination before the same case occured 
// Fill the matrix and the last value will give you the no of ways denominations could be used to get to the solution.

// Time Complexity O(m^2) 
// Space Complexity O(m)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        
        int[] prev = new int[n];
        Arrays.setAll(prev, i -> matrix[0][i]);
        
        for(int i = 1; i < n; i++) {
            int[] curr = new int[n]; 
            int[] row = matrix[i];
            
            for(int c = 0; c < row.length; c++) {
                int left = c > 0 ? prev[c-1] : Integer.MAX_VALUE;
                int right = c < n-1 ? prev[c+1] : Integer.MAX_VALUE;
                curr[c] = row[c] + Math.min(prev[c], Math.min(left, right));
            }
            
            prev = curr;
        }
        
        return Arrays.stream(prev).min().getAsInt();
    }
}