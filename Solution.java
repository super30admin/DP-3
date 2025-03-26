//Homework solution brute force logic
//t(n) = n*3^n (worst case)
//space = o(n)
//time limit exceeds
//validating dp solution
//repeated recursive functions are present in solution trying for implementing DP


class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[] sum = new int[matrix.length];
        int min = Integer.MAX_VALUE;

        for(int j = 0; j< matrix.length; j++)
        {
            int sumx = 0;
            sum[j] = helper(matrix, 0, j, sumx);
            if(min > sum[j]) min = sum[j];

        }
        return min;

    }

    private int helper(int[][] matrix, int i, int j, int sum)
    {
        if(i >= matrix.length || j >= matrix.length){
            return sum;
        }

        if(j == 0)
        {
            int lSum = helper(matrix, i+1, j, sum+matrix[i][j]);
            int rSum = helper(matrix, i+1, j+1, sum+matrix[i][j]);
            return Math.min(lSum, rSum);

        }
        if(j == matrix.length-1)
        {
            int lSum = helper(matrix, i+1, j - 1, sum+matrix[i][j]);
            int rSum = helper(matrix, i+1, j, sum+matrix[i][j]);
            return Math.min(lSum, rSum);
        }
        int lSum = helper(matrix, i+1, j+1, sum+matrix[i][j]);
        int rSum = helper(matrix, i+1, j-1, sum+matrix[i][j]);
        int mSum = helper(matrix, i+1, j,  sum+matrix[i][j]);
        return Math.min(Math.min(lSum, rSum), Math.min(rSum, mSum));

    }
}

// DP solution = t(n) = n^2 and space is o(n)
class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int[][] resultMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            resultMatrix[i] = matrix[i].clone();
        }

        for(int i = matrix.length -2; i >=0 ; i--)
        {
            for(int j = 0; j < matrix.length; j++)
            {

                if(j == 0){
                    resultMatrix[i][j] += Math.min(resultMatrix[i+1][j],
                            resultMatrix[i+1][j+1]);
                }
                else if(j == matrix.length-1){
                    resultMatrix[i][j] += Math.min(resultMatrix[i+1][j],
                            resultMatrix[i+1][j-1]);
                }
                else{
                    System.out.println(i);
                    System.out.println(j);
                    resultMatrix[i][j] +=
                            Math.min(
                                    Math.min(resultMatrix[i+1][j],
                                            resultMatrix[i+1][j+1]),
                                    Math.min(resultMatrix[i+1][j],
                                            resultMatrix[i+1][j-1])
                            ) ;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < matrix.length; j++)
        {
            if(min > resultMatrix[0][j]) min = resultMatrix[0][j];

        }
        return min;

    }
}
