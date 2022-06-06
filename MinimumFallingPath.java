public class MinimumFallingPath {

    //Time Complexity-O(mn)
    //Space Complexity-O(n)
    public int minFallingPathSum(int[][] matrix) {

        if(matrix==null || matrix.length==0){

        }
        int n=matrix.length;
        int[]dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=matrix[n-1][i];
        }

        for(int i=n-2;i>=0;i--){
            int[]curr=new int[n];
            for(int j=0;j<n;j++){
                if(j==0){
                    curr[j]=matrix[i][j]+Math.min(dp[j],dp[j+1]);
                }else if(j==n-1){
                    curr[j]=matrix[i][j]+Math.min(dp[j],dp[j-1]);
                }else{
                    curr[j]=matrix[i][j]+Math.min(dp[j],Math.min(dp[j+1],dp[j-1]));
                }
            }
            dp=curr;
        }
        int min=Integer.MAX_VALUE;
        for(int num:dp){
            min=Math.min(min,num);
        }

        return min;
    }
}
