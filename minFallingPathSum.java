class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //Tc: O(n*n). Sc: O(1)
        if(matrix.length == 0 || matrix == null) return 0;

        int len = matrix.length;

        for(int i = len-2; i >=0 ; i--)
        {
            for(int j = 0 ; j < len; j++)
            {
                if(j == 0)
                {
                    matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }

                else if(j == len-1)
                {
                    matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                }

                else 
                {
                    matrix[i][j] += Math.min(matrix[i+1][j-1],Math.min(matrix[i+1][j], matrix[i+1][j+1]));
                }
            }  
        }

        int min = Integer.MAX_VALUE;
        for(int k = 0; k < len; k++)
        {
            min = Math.min(min, matrix[0][k]);
        }

        return min;
    }
}

//Exhaustive Approach
        /*
        //Tc: O(3^n) Sc: O(n)
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int n = matrix.length;
        int minSum = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            minSum = Math.min(minSum, helper(matrix, 0, col));
        }

        return minSum;
    }

    private int helper(int[][] matrix, int row, int col) {
 
        if (row == matrix.length - 1) {
            return matrix[row][col];
        }

        int currentSum = matrix[row][col];

        int leftSum = col > 0 ? helper(matrix, row + 1, col - 1) : Integer.MAX_VALUE;
        int straightSum = helper(matrix, row + 1, col);
        int rightSum = col < matrix[0].length - 1 ? helper(matrix, row + 1, col + 1) : Integer.MAX_VALUE;

        return currentSum + Math.min(leftSum, Math.min(straightSum, rightSum));
    }
}
        */
