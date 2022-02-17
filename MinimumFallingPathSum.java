/*
Time Complexity: O(n*m)
Space Complexity: O(n)
Run on Leetcode: yes
Difficulties: no

Approach:

 */
public class MinimumFallingPathSum {
    public static int minimumFallingPathSum(int[][] matrix){
        int n = matrix.length;
        // Square matrix
        if(n == 1){
            return matrix[0][0];
        }
        int [][] outMatrix = new int[n][n];
        for(int i = 0; i<n; i++){
            outMatrix[0][i] = matrix[0][i];
        }

        for(int i = 1; i<n; i++){
            for(int j = 0; j<n; j++){
                if(j == 0){
                    outMatrix[i][j] = matrix[i][j]+ Math.min(outMatrix[i-1][j], outMatrix[i-1][j+1]);
                }else if(j == n-1){
                    outMatrix[i][j] = matrix[i][j]+ Math.min(outMatrix[i-1][j], outMatrix[i-1][j-1]);
                }else{
                    outMatrix[i][j] = matrix[i][j]+ Math.min(outMatrix[i-1][j-1], Math.min(outMatrix[i-1][j], outMatrix[i-1][j+1]));
                }
            }
        }
        int result = outMatrix[n-1][0];
        for(int i = 1; i<n; i++ ){
            if(result> outMatrix[n-1][i]){
                result  = outMatrix[n-1][i];
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println("Minimum Falling Path sum: "+ minimumFallingPathSum(matrix));
    }
}
