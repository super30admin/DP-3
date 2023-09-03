// Time Complexity : O(n*m)
// Space Complexity : O(n*m) for dp array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// using 2d matrix dp array

class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        dp[0] = matrix[0];

        //top down approach. Copied first row as it is to dp array
        // now in next row calculate the minimum sum for each element
        //i.e in column j for i th row
        for(int i =1; i< n; i++) {
            for(int j =0; j<m; j++) {
                int sum =0;
                int min = 0;
                if(j!=0 && j!=m-1){ 
                    //In the middle elements take minimum from previous row all elements in dp array (which holds min sum)
                    min = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1]));
                    sum = matrix[i][j] + min;
                    dp[i][j] = sum;
                } else if(j == 0) {
                    min = Math.min(dp[i-1][j], dp[i-1][j+1]);
                    sum = matrix[i][j] + min;
                    dp[i][j] = sum;
                } else if(j==m-1) {
                    min = Math.min(dp[i-1][j-1], dp[i-1][j]);
                    sum = matrix[i][j] + min;
                    dp[i][j] = sum;
                }
            }
        }

       
        int out = Integer.MAX_VALUE;
        for(int i = 0; i<dp[m-1].length; i++) {
            if(dp[m-1][i]<out) out = dp[m-1][i];
        }

        return out;
    }
}

// using 1d array for dp, this saves space 
// but this solution doesnt scale well for  more than 3*3 matrix
class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int[] dp = new int[m];
        dp = matrix[0];

        for(int i =1; i< n; i++) {
            int elemJ = 0; int elemJminusone = 0; int elemJplusone = 0;
            for(int j =0; j<m; j++) {
                int sum =0;
                int min = 0;
                if(j!=0 && j!=m-1){
                    min = Math.min(dp[j-1], Math.min(dp[j], dp[j+1]));
                    sum = matrix[i][j] + min;
                    elemJ = sum;
                    System.out.println("elemJ: "+elemJ);
                } else if(j == 0) {
                    min = Math.min(dp[j], dp[j+1]);
                    sum = matrix[i][j] + min;
                    elemJminusone = sum;
                    System.out.println("elemJminusone: "+elemJminusone);
                } else if(j==m-1) {
                    min = Math.min(dp[j-1], dp[j]);
                    sum = matrix[i][j] + min;
                    elemJplusone = sum;
                    System.out.println("elemJplusone: "+elemJplusone);
                }
            }
            dp[0] = elemJminusone;
            dp[1] = elemJ;
            dp[m-1] = elemJplusone;
            System.out.println(Arrays.toString(dp));
        }

        int out = Integer.MAX_VALUE;
        for(int i = 0; i<dp.length; i++) {
            if(dp[i]<out) out = dp[i];
        }

        return out;
    }
}