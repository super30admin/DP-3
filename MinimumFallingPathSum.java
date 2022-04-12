// Time Complexity : O(N^2)
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
/*

    This problem is similar to paint house problem. 
    Since there are more than 3 columns over here, code needs to be written accordingly.


*/



public class MinimumFallingPathSum
{
    public static int minFallingPathSum(int[][] matrix) {
        
        if(matrix == null || matrix.length==0)
        {
            return 0;
        }

        for(int i  = matrix.length-2;i>=0;i--)
        {
            for(int j = 0;j<matrix[0].length;j++)
            {
                if(j==0)
                {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }
                else if(j==matrix[0].length-1)
                {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                }
                else
                {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], Math.min(matrix[i+1][j-1], matrix[i+1][j+1]));
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i =0;i<matrix[0].length;i++)
        {
            if(matrix[0][i]<min)
            {
                min = matrix[0][i];
            }
        }

        return min;
    }

    public static void main(String args[])
    {
        int matrix[][] = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(matrix));
    }
}