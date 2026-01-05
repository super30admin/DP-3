// In this problem, we need to find the minimum sum of a falling path while parsing through a matrix. We are using bottom up dp approach to solve it here. 
// We maintain a 1D array to store the minimum sum at each position of the current row. We iterate through each row and update the dp array based on the values from the previous row. And return the min value of the dp array. 
// Time complexity is O(n^2) and space complexity is O(n) where n is the number of rows or columns in the matrix

class Solution {
    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        val n = matrix.size
        var result = Int.MAX_VALUE
        val dp = IntArray(n)

        for(i in 0..n-1) {
            dp[i] = matrix[0][i]
        }

        for(i in 1..n-1) {
            var elementOnTop = dp[0]
            for(j in 0..n-1) {
                val temp = dp[j];
                if(j == 0 ) {
                    dp[j] = matrix[i][j] + Math.min(dp[j], dp[j+1]);
                } else if(j == n - 1){
                    dp[j] = matrix[i][j] + Math.min(elementOnTop, dp[j]);
                }
                else {
                    dp[j] = matrix[i][j] + Math.min((Math.min(elementOnTop, dp[j])), dp[j + 1]);
                }
                elementOnTop = temp;
            }
        }
        for(i in 0..n-1) {
            result = Math.min(result, dp[i])
        }

        return result
    }
}
