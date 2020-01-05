package Day10;

public class MinFallingPath {
    public int minFallingPathSum(int[][] A) {

        int min = Integer.MAX_VALUE;
        int n = A[0].length;

        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++){
            dp[0][i] = A[0][i];
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<n; j++){
                if(j==0){
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                }
                else if(j == n-1){
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
                }
                else{
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i-1][j+1]));
                }


            }
        }

        for(int i=0; i<n; i++){
            if(dp[n-1][i] < min){
                min = dp[n-1][i];
            }
        }
        return min;
    }

    public static void main(String args[]){
        MinFallingPath obj = new MinFallingPath();

        int A[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

        System.out.println("The minimum cost of falling paths: "+obj.minFallingPathSum(A));
    }
}
