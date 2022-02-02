// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// problem 1
TC = O( n * Max(n,maximum element of array))
SC = O(Maximum element of array)

class Solution {
    public int deleteAndEarn(int[] nums) {
    
        if ( nums == null || nums.length == 0 ) return 0;
        int max = Integer.MIN_VALUE;
        for(int i : nums)
        {
            max = Math.max(max,i);
        }
        
        int[] dp = new int[max + 1];
        
        for(int i : nums)
        {
            dp[i] = i + dp[i];
        }
                int skip = 0, take = dp[0];

        for ( int i = 1; i <  max + 1; i++)
        {
            int temp = skip;
            skip = Math.max(skip,take);
            take = temp + dp[i];
        }
       
        return Math.max(skip,take);
    }
}

//Problem 2 

//T.C O(n)
//S.C O(1)

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i = m-2; i>=0; i--)
        {
            for (int j=0; j< n ; j++)
            {
                if (j ==0 )
                {
                    matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                    
                }
                else if ( j == n - 1)
                {
                    matrix[i][j]=matrix[i][j]+Math.min(matrix[i + 1][j],matrix[i + 1][j - 1]);

                    
                }
                else
                {
                    matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][j],Math.min(matrix[i+1][j-1],matrix[i+1][j+1]));

                }
            }
        }
       
    int min = Integer.MAX_VALUE;

         for ( int i=0; i<n; i++)
             
    {
            min = Math.min(min,matrix[0][i])    ;    
             // System.out.println(matrix[0][i]);
    }
       
    return min;
    }
       
    
}