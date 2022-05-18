//time complexity:O(n*n)
//space complexity:O(n*n)
public class MinFallingPathSum {
    public int findMin(int[][] matrix){
        int n= matrix.length;
        int[][] dp = new int[n][n];
        for(int i =0; i<n;i++){
            dp[0][i]=matrix[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                //case1
                if(j==0) dp[i][j]= matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j+1]);
                //case2
                else if(j==n-1) dp[i][j] = matrix[i][j]+ Math.min(dp[i-1][j],dp[i-1][j-1]);
                //case3
                else dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1],dp[i-1][j+1]));
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(min>dp[n-1][i]) min=dp[n-1][i];
        }
        return min;
    }
    public static void main(String args[]){
        MinFallingPathSum obj = new MinFallingPathSum();
        System.out.println(obj.findMin(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
}
