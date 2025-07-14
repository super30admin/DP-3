// Time Complexity : O(n^2) -> since we used two nested loops 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
// I start from the second-last row and move upwards.
// For each element, I calculate the minimum path by checking the three allowed positions from the row below (straight down, left-diagonal, and right-diagonal).
// At the end, the first row contains the minimum falling path sums starting from each column, and I return the smallest among them.



public class MinFallingPathSum {
    public int solve(int[][] matrix){
        if(matrix==null || matrix.length==0){
            return 0;
        }
        int n = matrix.length;
        int min = Integer.MAX_VALUE;

        for(int i = n-2; i>=0; i--){
            for(int j = 0; j<n; j++){
                if(j==0){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j+1]);

                }
                else if(j==n-1){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j-1], matrix[i+1][j]);

                }
                else{
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j-1], Math.min(matrix[i+1][j], matrix[i+1][j+1]));

                }

            }
        }
        for(int j = 0; j<n; j++){
            min = Math.min(min, matrix[0][j]);
        }
        return min;
    }
    public static void main(String[]args){
        MinFallingPathSum ob = new MinFallingPathSum();
        int[][] matrix = {
            {2,1,3},{6,5,4},{7,8,9}
        };
        int[][] matrix2 = {
            {-19,57}, {-40, -5}
        };
        System.out.println("Min Falling Path Sum is : "+ob.solve(matrix));
        System.out.println("Min Falling Path Sum is : "+ob.solve(matrix2));
    
        

    }
    
}
