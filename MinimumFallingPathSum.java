class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n];
        //initalise dp with bottom row of matrix
        for(int col = 0 ; col<n ; col++){
            dp[col] = matrix[m-1][col];
        }
        //fill dp matrix from last butone row to first row(top wards)
        for(int i = m-2 ; i >=0 ; i--){
             int[] temp = new int[n];  // Declare temp once per row : We are filling the current row’s column values using the previous row’s values stored in dp, and storing the new current row’s values in temp.


            for(int j = 0 ; j <n ; j++){
                //initally
                int left = Integer.MAX_VALUE;
                int down = dp[j];
                int right = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    left = dp[j - 1];
                }
                if (j + 1 < n) {
                    right = dp[j + 1];
                }
                int minval= Math.min(left , Math.min(down , right));
                temp[j] = matrix[i][j] + minval;  // Assign to temp[j]
               
            }
            dp = temp;
        }
        //now return minimum in first row
         int minSum = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            minSum = Math.min(minSum, dp[col]);
        }
        
        return minSum;

    }
}


// class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         int[][] dp = new int[m][n];
//         //set bottom row
//         for(int col = 0 ; col<n ; col++){
//             dp[m-1][col] = matrix[m-1][col];
//         }
//         //fill dp matrix from last butone row to first row(top wards)
//         for(int i = m-2 ; i >=0 ; i--){
//             for(int j = 0 ; j <n ; j++){
//                 //initally
//                 int left = Integer.MAX_VALUE;
//                 int down = dp[i + 1][j];
//                 int right = Integer.MAX_VALUE;
//                 if (j - 1 >= 0) {
//                     left = dp[i + 1][j - 1];
//                 }
//                 if (j + 1 < n) {
//                     right = dp[i + 1][j + 1];
//                 }
//                 int minval = Math.min(left , Math.min(down , right));
//                 dp[i][j] = matrix[i][j] +minval;
//             }
//         }
//         //now return minimum in first row
//          int minSum = Integer.MAX_VALUE;
//         for (int col = 0; col < n; col++) {
//             minSum = Math.min(minSum, dp[0][col]);
//         }
        
//         return minSum;

//     }
// }