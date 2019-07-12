// Time Complexity : O(n^2) n is size of matrix
// Space Complexity : O(n^2) size of matrix 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MinFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        int[] dp =  new int[A[0].length];

        for(int i=0;i<A[0].length;i++)
            dp[i] = A[0][i];
        int[] tempDp = new int[A[0].length];

        for(int i=1;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                //3 cases - leftmost, rightmost , others
                if(j == 0)
                    tempDp[j] = A[i][j] + Math.min(dp[j], dp[j+1]);
                else if(j == A[0].length-1)
                    tempDp[j] = A[i][j] + Math.min(dp[j], dp[j-1]);
                else 
                    tempDp[j] = A[i][j] + Math.min(Math.min(dp[j-1],dp[j]), dp[j+1]);                
            }
            //dp = tempDp;
            // to prevent deep copy
            System.arraycopy(tempDp, 0, dp, 0, dp.length);
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<dp.length;i++){
            if(dp[i] < min)
                min = dp[i];
        }

        return min;   
    }
    public static void main(String[] args){
        System.out.println("Min Falling Path Sum");
        int[][] A = new int[][] {{10, -98, 44}, {-20, 65, 34}, {-100, -1, 74}};
        MinFallingPathSum obj = new MinFallingPathSum();
        System.out.println(obj.minFallingPathSum(A));
    }
}