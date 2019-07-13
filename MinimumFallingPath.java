
//Time Complexity: O(n2) for the two for loops
//Speace Complexity : O(m*n) which the number of rows and cols
//LeetCode:Success
/*Details 
Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
Memory Usage: 34.4 MB, less than 99.94% of Java online submissions for House Robber.*/

//We are not cycling through the array: We just take first value and finding the minimum path using the colmns right below it or a differnece of max 1

//We use same concept as Paint houses - first take inital same values and keep finding the minimum of previous rows

class Solution {
    public int minFallingPathSum(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        
        int grid[][] = new int[rows][cols];
        
        for(int i = 0; i<cols ; i++)
        {
           grid[0][i] = A[0][i];            //The first row gets same value as A[0][col] - first intial value
        }
        
        for(int i = 1 ; i<rows ;i++ )
        {
            for(int j =0; j<cols ;j++)
            {
                if(j==0)
                {
                    grid[i][j] = A[i][j] + Math.min(grid[i-1][j],grid[i-1][j+1]); //edge case 1
                }
                
               else if(j==cols-1)
                {
                    grid[i][j] = A[i][j] + Math.min(grid[i-1][j],grid[i-1][j-1]); //edge case 2
                }
                else
                {
                    grid[i][j] = A[i][j] + Math.min(Math.min(grid[i-1][j],grid[i-1][j+1]),grid[i-1][j-1]);
                }
         }
            }
        
        // The minimum path sum is minimum of the last row in DP matrix
  int min = Integer.MAX_VALUE;
  for (int i = 0; i <cols; i++) {
    min = Math.min(min, grid[rows - 1][i]); 
  }
  return min;
    }
}
