package s30.dp.dp3;

public class MinFallingPath {


    //DP
    //TC: O(n^2);
    //SC: O(1);
    public int minFallingPathSumDP(int[][] matrix) {

        int n  = matrix.length;

        for(int i =1; i < n ; i++){

            for(int j =0; j < n; j++){

                int up = matrix[i-1][j];

                int upLeft = j == 0? Integer.MAX_VALUE :  matrix[i-1][j-1];

                int upRight = j == n-1 ? Integer.MAX_VALUE :matrix[i-1][j+1];


                matrix[i][j] += Math.min(up,
                        Math.min(upLeft, upRight)
                );
            }
        }

        int min = Integer.MAX_VALUE;

        for(int j =0; j < n; j++){
            min = Math.min(min, matrix[n-1][j]);
        }

        return min;

    }

    // Memoization
    // TC: (n * n) no.of unique sub problems.
    //SC: O(n^2) for the dp array.
    private int[][] matrix;
    private int[][] dp;
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        dp = new int[n][n];
        this.matrix = matrix;

        int min = Integer.MAX_VALUE;
        for(int i=0; i < n ; i++ ){
            min = Math.min(min, minfallingPathSum(0,i));
        }

        return min;
    }


    private int minfallingPathSum(int r, int c){

        //base
        if(r == matrix.length) return 0;

        if(dp[r][c] == 0){
            int down = matrix[r][c] + minfallingPathSum(r + 1, c + 0);

            int leftDown =  c!= 0 ? matrix[r][c] + minfallingPathSum(r + 1, c -1) : Integer.MAX_VALUE;

            int rightDown =  c != matrix.length-1? matrix[r][c] + minfallingPathSum(r + 1, c + 1) : Integer.MAX_VALUE;

            dp[r][c] = Math.min(down,
                    Math.min( leftDown, rightDown )
            );
        }


        return dp[r][c];

    }
    public static void main(String[] args) {

    }
}
