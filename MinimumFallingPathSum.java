/**


Bottom up DP approach
TC - O(m*n) where m is the number of rows and n is the number of cols.
SC - O(n) where n is the number of cols.



 [2,1,3],
 [6,5,4],
 [7,8,9]
 
 bottom up approach is more effective here. 
 
 [2,1,3]
 [7,6,5]
 [13,13,14]

// 7 1 3

8, 7, 

//   -19 57
//   -40 -5

-59,17

-59,-24



TC - O(m*n) where m is the number of rows and n is the number of cols.
SC - O(m*n) and it can be reduced to O(n).

  dp[0] = Math.min(matrix[i][0] + dp[0], matrix[i][0] + dp[1])
  dp[1] = Math.min(matrix[i][1] + dp[0], matrix[i][1] + dp[1], matrix[i][1] + dp[2])
  dp[2] = Math.min(matrix[i][2] + dp[1], matrx[])

**/
class Solution {
    
    public int minFallingPathSum(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int prev[] = matrix[0];
        int result = Integer.MAX_VALUE;
        int count = 0;
        
        for(int m[] : matrix)
        {
            
            if (count == 0)
            {
                count++;
                continue;
            }
            
            int curr[] = new int[m.length];

            for(int i=0; i<m.length; i++)
            {  
                
                int pathOption1 = prev[i] + m[i];
                int pathOption2 = Integer.MAX_VALUE;
                int pathOption3 = Integer.MAX_VALUE;
                
                if (i-1 >= 0)
                {
                    pathOption2 = prev[i-1] + m[i];
                }
                
                if (i+1 < m.length)
                {
                    pathOption3 = prev[i+1] + m[i];
                }
                
                int min = pathOption1;
                
                if (pathOption2 != Integer.MAX_VALUE)
                {
                    min = Math.min(min, pathOption2);
                }
                
                if (pathOption3 != Integer.MAX_VALUE)
                {
                    min = Math.min(min, pathOption3);
                }
                
                curr[i] = min;
            }
            
            prev = curr;
        }
        
        for (int k : prev)
        {
            result = Math.min(result, k);
        }

        return result;
    }
}