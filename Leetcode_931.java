//way1
//Exhaustive-- try in all possible ways
//TC: n*(3^n)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;

        int min=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            min=Math.min(min,helper(matrix,0,i));
        }

        return min;
        
    }

    private int helper(int[][] matrix, int i, int j){
        //base case
        if(i<0 || i==matrix.length) return 0;
        
        if(j<0 || j>=matrix[0].length) return Integer.MAX_VALUE; 


        //logic
        int case1=helper(matrix,i+1,j-1);

        int case2=helper(matrix,i+1,j);

        int case3=helper(matrix,i+1,j+1);


        return matrix[i][j]+(Math.min((case1),Math.min(case2,case3)));
               

    }
}

//way2
//Exhaustive-- try in all possible ways--time limit exceeded
//Memoization-- remembering prev values
//TC: O(n*n);SC:O(n*n)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;

        int min=Integer.MAX_VALUE;

        int[][] memo=new int[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],Integer.MAX_VALUE);
        }

        for(int i=0;i<n;i++){
            min=Math.min(min,helper(matrix,0,i,memo));
        }

        return min;
        
    }

    private int helper(int[][] matrix, int i, int j,int[][] memo){
        //base case
        if(i<0 || i==matrix.length) return 0;
        
        if(j<0 || j>=matrix[0].length) return Integer.MAX_VALUE; 

        if(memo[i][j]!=Integer.MAX_VALUE) return memo[i][j];


        //logic
        int case1=helper(matrix,i+1,j-1,memo);

        int case2=helper(matrix,i+1,j,memo);

        int case3=helper(matrix,i+1,j+1,memo);

        memo[i][j]=matrix[i][j]+(Math.min((case1),Math.min(case2,case3)));
        return memo[i][j];
               

    }
}

//way3
//Tabulation
//TC: O(n*n); SC: O(n*n)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;

        int[][] dp=new int[n][n];

        for(int i=0;i<n;i++){
            dp[0][i]=matrix[0][i];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                //case1
                int case1=Integer.MAX_VALUE;
                if(j-1>=0){
                    case1=matrix[i][j]+dp[i-1][j-1];
                }

                int case2=Integer.MAX_VALUE;
                case2=matrix[i][j]+dp[i-1][j];

                int case3=Integer.MAX_VALUE;
                if(j+1<matrix.length){
                    case3=matrix[i][j]+dp[i-1][j+1];
                }

                dp[i][j]=Math.min(case1,Math.min(case2,case3));
            }
        }

        int min=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            min=Math.min(min,dp[n-1][i]);
        }

        return min;

        
        
    }
}
