time complexity: O(m*n)
space complexity: O(1)

class Solution { //using dp to find the minimum path 
    public int minFallingPathSum(int[][] matrix) {
      for (int i = 1; i < matrix.length ; i++)
            helper(matrix, i);
        
        int min = matrix[matrix.length-1][0];
        
        for (int i = 1; i < matrix[0].length ; i++)
            min = Math.min(min, matrix[matrix.length-1][i]);
        
        return min;
    }
    
    
    private void helper(int[][] matrix, int index) {
        
        for (int i = 0 ; i < matrix[0].length ; i++) {
            int n1 = 100000;
            int n2 = matrix[index-1][i] + matrix[index][i];
            int n3 = 100000;
            
            if (i>0)
                n1 = matrix[index-1][i-1] + matrix[index][i];
            if (i<matrix[0].length-1)
                n3 = matrix[index-1][i+1] + matrix[index][i];
            
            matrix[index][i] = Math.min(n1, Math.min(n2, n3));
        }
        
    }
}