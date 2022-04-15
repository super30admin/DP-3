// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//https://leetcode.com/problems/minimum-falling-path-sum/submissions/

public int MinFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.Length == 0)
            return 0;
        
        int min = Int32.MaxValue;
        for(int i = matrix.Length - 2; i >= 0; i--)
        {
            for(int j = 0; j < matrix[0].Length; j++)
            {
                int currentMin = matrix[i+1][j];
                if(j > 0)
                    currentMin = Math.Min(currentMin, matrix[i+1][j-1]);
                if(j < matrix[0].Length - 1)
                    currentMin = Math.Min(currentMin, matrix[i+1][j+1]);
                matrix[i][j] += currentMin;
            }
        }
        
        for(int j = 0; j < matrix[0].Length; j++)
        {
            min = Math.Min(min, matrix[0][j]);
        }
        
        return min;
    }