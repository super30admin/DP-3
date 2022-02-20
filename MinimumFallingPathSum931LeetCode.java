//time complexity : O(row*column) row that are present in matrix array
//space complexity : O(columns) //columns that are present in matrix array
//I don't face any problems
//runs successfully on leetcode

public class MinimumFallingPathSum931LeetCode {

    //Bottom Up approach
    public int minFallingPathSum(int[][] matrix) {

        int[] prev= matrix[0];                              //assign the first row to previous

        for(int i=1; i<matrix.length; i++){
            int[] current = new int[matrix[0].length];          //creating current array
            //print(prev);
            for(int j=0; j<matrix[0].length; j++){

                if(j == 0){                                     //check if the column is on left edge
                    current[j] = matrix[i][j] + Math.min(prev[j], prev[j+1]);
                }
                else if(j == matrix[0].length-1){               //check if the column is on right edge
                    current[j] = matrix[i][j] + Math.min(prev[j], prev[j-1]);
                }
                else{                                           //column is in between both edges
                    current[j] = matrix[i][j] + Math.min(prev[j], Math.min(prev[j-1], prev[j+1]));
                }
                //print(current);
            }
            prev = current;

        }

        int minimumSum = Integer.MAX_VALUE;

        for(int i=0; i<prev.length; i++){
            minimumSum = Math.min(minimumSum, prev[i]);         //finding the minimum value from prev array
        }

        return minimumSum;                              //returning the minimum value

    }

//     private void print(int[] prev){
//         for(int i=0; i<prev.length; i++){
//             System.out.println(prev[i]);
//         }
//         System.out.println("---------");
//     }


//     //Top Down Approach

//     int[][] dp;

//     public int minFallingPathSum(int[][] matrix) {

//         int minimumSum = Integer.MAX_VALUE;
//         dp = new int[matrix.length][matrix[0].length];

//         for(int i=0; i<dp.length; i++){
//             for(int j=0; j<dp[0].length; j++){
//                 dp[i][j] = Integer.MAX_VALUE;
//             }
//         }

//         for(int i=0; i<matrix[0].length; i++){
//             int temp = getMinimumSum(matrix, 0, i);
//             minimumSum = Math.min(temp, minimumSum);
//         }
//         return minimumSum;

//     }

//     private int getMinimumSum(int [][] matrix, int row, int column){


//         if(row == matrix.length){
//             return 0;
//         }

//         int lowerLeft = Integer.MAX_VALUE;
//         int lowerRight = Integer.MAX_VALUE;

//         if(dp[row][column] != Integer.MAX_VALUE){
//             return dp[row][column];
//         }

//         if(column - 1 >= 0 ){
//             lowerLeft =  getMinimumSum(matrix, row+1, column-1);
//         }

//         if(column + 1 < matrix[0].length){
//             lowerRight = getMinimumSum(matrix, row+1, column+1);
//         }

//         int lower =  getMinimumSum(matrix, row+1, column);

//         return dp[row][column] = matrix[row][column] + Math.min(lower, Math.min(lowerRight, lowerLeft));
//     }

}
