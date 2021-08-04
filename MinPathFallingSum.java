
// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nope


// Your code here along with comments explaining your approach
/*Approach
1) as we can see, during exhaustive search, we found out that the min can be found by using repeating sub problems
2) these repeating subproblems can be cached by mutating the same array itself, thus we can start from 2nd row and cache the minimum results in the array. 
thus we do this by going all the way down till the last row 

then we iterate on last row and get the solution by calculating min value

*/





class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        if(matrix.length==0 || matrix==null)
        {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i=1;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(j==0)
                {
                    matrix[i][j]+= Math.min(matrix[i-1][j],matrix[i-1][j+1]);
                }
                else if(j==n-1)
                {
                    matrix[i][j]+= Math.min(matrix[i-1][j],matrix[i-1][j-1]);
                }
                else
                {
                    matrix[i][j]+= Math.min(matrix[i-1][j],Math.min(matrix[i-1][j-1],matrix[i-1][j+1]));
                }
                
            }
        }
        
        
        int totalSum=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            totalSum = Math.min(totalSum,matrix[m-1][i]);
        }
        
        
        return totalSum;
        
    }
}