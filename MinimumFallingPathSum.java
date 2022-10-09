
/**Dynamic Programming Solution: Over Exhaustive solution to store the calculations for repitative subtrees
    * Modify existing matrix to store the falling path sum  ==> If not allowed then create separate DP array[][] to store the falling sum
    1. Start from second last row
        1.1 for -> i = n-2; i>=0; i--
                for j = 0; j < n; j++
                    case1: for first column [0] --> No left (-1)
                        ==> only consider [row+1][j] and [row+1][j+1]
                    case2: for last column [n-1] --> No right (-1)
                        ==> only consider [row+1][j] and [row+1][j-1]
                    case3: Else all in between columns
                        ==>  consider [row+1][j], [row+1][j-1] and [row+1][j+1]
    2. return minimum from the first row as a result
 */

class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {  
       //Start from second last row
       int n = matrix.length; // rows and columns are same => n
       for(int i = n-2; i >=0; i--){
           for (int j = 0; j < n; j++){
               // case1: for first column [0] --> No left (-1)
               if(j == 0){
                    matrix[i][j] = matrix[i][j] + Integer.min(matrix[i+1][j], matrix[i+1][j+1]);  
               }
               //case2: for last column [n-1] --> No right (-1)
                else if(j == n-1){
                    matrix[i][j] = matrix[i][j] + Integer.min(matrix[i+1][j], matrix[i+1][j-1]);  
               }
                else{
                    matrix[i][j] = matrix[i][j] + Integer.min(matrix[i+1][j], Integer.min(matrix[i+1][j-1], matrix[i+1][j+1]));  
               }
            }
        }
        //return minimum from the first row as a result
        int minFallingSum = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            minFallingSum = Integer.min(minFallingSum, matrix[0][i]);
        }

        return minFallingSum;
    }
}

//Time complexity: O(n * n) //n= number of row and columns
//Space complexity: O(1) // Used same matrix