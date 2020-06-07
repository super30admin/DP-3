/*
    Minimum Falling Path Sum 
    Time complexity :  N * (3^N) N is the size of Array
    space complexity :  O(N) 

    Is Worked on leetcode : No time limit excedded
    Recursive Solution Approach :

    we can start with any column from first row, and then generate the tree based on the condition that
    in the next row we can only chose the column that are at most one index away from the previous
    , so we have three choice maximum for next row and we will generate recursive tree
    using similar approach. and when we resolve recursion we will choose the minimum value. 
    but in the first row we have  N number of choice to start with so we will continue this with every column as starting point
    then generate the tree and finally select the minimum of all in the first row.

*/
public class MinimumFalling_path_sum {
    

    int n ;
    public int minFallingPathSum(int[][] A) {
        // System.out.print("A "+A.length);
        // System.out.print("A[0]"+A[0].length);
        n = A.length ;
        if ( A == null || n == 0 ){
            return -1;
        }
        
        int min_val = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
    
        for(int i =0;i < n ;i++){
            int sub_ans = get_falling_path_sum(0,i,A);
            System.out.println("previous ans "+ans);
            System.out.println("sub_ans "+sub_ans);
            
            ans = Math.min(ans, sub_ans);
            System.out.println("new ans "+ans);
        }
        return ans;
    }
    
    public int get_falling_path_sum(int row, int col, int[] [] A){
        // System.out.println("A[0] lenth "+A[0].length );
        
        if (col == n || col < 0){
            return Integer.MAX_VALUE;
        }
        
        if (row == n -1 ){
            return A[row][col];
            
        }
        return A[row][col] + Math.min(
                                      get_falling_path_sum(row+1,col,A), 
                                      Math.min(
                                                get_falling_path_sum(row+1,col-1,A),
                                                get_falling_path_sum(row+1,col+1,A)
                                               )
                                     );
    }


    /*
      Dp Solution  
      Time Complexity  : O(N^2)  N is the size of Array but still it will be fast because 
      we have input size is maximum 100 , so at most 100*100 =10000 operation whch is fast based on
      current hardware and CPU
      Space Complexity :O(N^2)
      is worked on Leetcode : YES

    
    */

    public int minFallingPathSum_DP(int[][] A) {
        int n = A.length;
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[A.length][A.length];
        for(int i=0;i<n;i++){

            dp[0][i] = A[0][i];
            // if(n ==1){
            //     ans = Math.min(ans, dp[0][i]);
            // }
        }
        
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
//                 same column check
                int temp = dp[i-1][j];
//                 check left column
                if(j!=0){
                    temp = Math.min( temp, dp[i-1][j-1]);
                }
//                 check right column
                if(j!= n-1){
                    temp = Math.min(temp, dp[i-1][j+1]);
                }
                dp[i][j] = temp + A[i][j];
            }
        }
//         check the min of last column
        for(int i=0;i<n;i++){
            // get min of last row and compare with current min 

            ans = Math.min( ans,dp[n-1][i]);
        }
        
        return ans;   
    }
}