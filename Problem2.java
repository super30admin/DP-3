// Time Complexity : O (mn)
// Space Complexity : O (1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

public class Problem2{
    public int minFallingPathSum(int[][] matrix) {
        
        int m=matrix.length;
        int n=matrix[0].length;
        

	// Traverse from bottom up and select the next rows minimum applicable values 		//for the current row
        for(int i=m-2;i>=0;i--)
        {
            for(int j=0;j<n;j++)
            {
                if(j==0)
                    matrix[i][j]+=Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                else if(j==n-1)
                    matrix[i][j]+=Math.min(matrix[i+1][j],matrix[i+1][j-1]);
                else
                    matrix[i][j]+=Math.min(matrix[i+1][j],Math.min(matrix[i+1][j-1],matrix[i+1][j+1]));
                
            }
        }
        

	// Finally select the minumum of the first row

        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            min=Math.min(min,matrix[0][i]);
        }
        
        return min;
    }
}