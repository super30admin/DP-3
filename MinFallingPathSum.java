public class MinFallingPathSum {


        public int minFallingPathSum(int[][] matrix) {

            if(matrix == null || matrix.length == 0) return 0;

            int n = matrix.length;

            // iterate from last but row to the top
            for(int i =  n-2; i >= 0; i--){ //O(n*n)

                for(int j =0; j < n; j++){

                    // first column
                    if(j == 0){
                        matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                    }
                    // last column
                    else if(j == n-1){
                        matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                    }

                    // middle columns
                    else{
                        matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],
                                Math.min(matrix[i+1][j-1], matrix[i+1][j+1]));
                    }
                }
            }

            // minimum of top row
            int min = Integer.MAX_VALUE;

            for(int j =0; j < n; j++){

                min = Math.min(min, matrix[0][j]);

            }
            return min;
        }

    /*
    Time Complexity: O(n^2) - two for loops
    Space Complexity: O(1) - no extra space or auxiliary data structure
    */
    public static void main(String[] args){

        MinFallingPathSum object = new MinFallingPathSum();

        int[][] matrixGiven = {{2,1,3},{6,5,4}, {7,8,9}};

        int MinimumSum = object.minFallingPathSum(matrixGiven);

        System.out.println("Minimum Falling Path Sum is " + MinimumSum);
    }
}
