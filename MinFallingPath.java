// TC - O(n^2)
// SC - O(1) since we are updating the same matrix

// We solve this problem with paint house pattern. 
// We assume that array is mutable and hence we update the same array to reduce space complexity
class MinFallingPath {
    public int minFallingPathSum(int[][] matrix) {

        if(matrix == null || matrix.length==0){
            return 0;
        }

        int n = matrix.length;

        // Iterating through matrix in reverse rder starting from second last element
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<n; j++){

                // first element in column
                if(j==0){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j] , matrix[i+1][j+1]);
                }
                // last element in column
                else if(j==n-1){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j] , matrix[i+1][j-1]);
                }
                // middle element in column
                else{
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j] , Math.min(matrix[i+1][j-1] , matrix[i+1][j+1]));
                }
                
            }
        }

        int min = Integer.MAX_VALUE;

        // interatin over first row to find min value
        for(int j=0; j<n; j++){
            min = Math.min(min, matrix[0][j]);
        }

        return min;

    }
}