class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }

        int n = matrix.length;
        System.out.println("length" +n);
        
        for(int i = n-2; i >= 0 ; i--){
            for(int j=0; j < n ; j++){
                if(j == 0){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }else if(j == n-1){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                }else{
                  matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j+1], (Math.min(matrix[i+1][j], matrix[i+1][j-1])));
                }

            }
        }

        int min = Integer.MAX_VALUE;
        

        for(int i=0 ; i<n; i++){
            min = Math.min(matrix[0][i], min);
        }


        return min;
        
    }

        public static void main(String[] args) {
        Solution solution = new Solution();

        // Sample 2D matrix
        int[][] matrix = {
            {2, 1, 3},
            {6, 5, 4},
            {7, 8, 9}
        };

        int minSum = solution.minFallingPathSum(matrix);

        System.out.println("Minimum falling path sum: " + minSum);
    }
}