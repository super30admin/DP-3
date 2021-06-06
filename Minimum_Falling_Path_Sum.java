// Time COmplexity -  O(N)
//Space Complexity - O(1)


class Solution {
    public int minFallingPathSum(int[][] matrix) {

        //edge case
        if(matrix == null || matrix.length == 0) return 0;

        int n = matrix.length;


        //compare last 2 rows with previous and calculate the minimum and overwrite the array

        for(int i = 1; i < n; i++) {

            for(int j = 0; j < n; j++) {

                if(j == 0) {

                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j],matrix[i-1][j+1]);

                }
                else if(j == n-1) {

                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j],matrix[i-1][j-1]);

                }
                else {

                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j],Math.min(matrix[i-1][j-1],matrix[i-1][j+1]));

                }

            }
        }


        //Calculate the minimum value by comparing values from the last row and return
        int minimumValue = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {

            minimumValue = Math.min(minimumValue, matrix[n-1][i]);

        }

        return minimumValue;



    }
}