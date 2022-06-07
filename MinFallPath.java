/*
This approach uses a bottom up DP method to solve the problem. It does this by calculating the minimum
falling path sum for each element at each level starting from the bottom most level. It successively 
computes this sum as it reaches the top, where the minimum of all the top elements is taken to produce the
final minimum sum.

Problems with this approach: The approach is proper, but it gives runtime error on leetcode. The issue is 
index out of bounds at line 39, but when I compile it in a regular java compiler everything seems to work
fine.

Did this run on leetcode: No


*/
class Solution {
    //Time Complexity = O(n^2)
    //Space Complexity = O(1)
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        
        if(matrix == null || n == 0)
            return 0;
        
        if(n == 1)
            return matrix[0][0];
        //We start computing from the penultimate level
        for(int i = n-2; i >= 0; i--)
        {
            for(int j = 0; j < n; j++)
            {   //Edge case at left boundary
                if(j == 0)
                    matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                //Edge case at right boundary    
                if(j == n-1)
                    matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                
                else
                    matrix[i][j] += Math.min(matrix[i+1][j], Math.min(matrix[i+1][j+1], matrix[i+1][j-1]));
            }
        }
        
        int minimum = 999999;
        //Calculating minimum of all the topmost elements
        for(int i = 1; i < n; i++)
        {   
            int mini = Math.min(matrix[0][i-1], matrix[0][i]);
            if(mini < minimum)
                minimum = mini;
        }
        
        return minimum;
    }
}