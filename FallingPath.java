// Time Complexity :O(nxm)
// Space Complexity :O(nxm)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class FallingPath {
    int ans = 101;
   public int minFallingPathSum(int[][] A) {
      
       int memo[][] = new int[A.length][A[0].length];
       for(int C = 0;C <A[0].length;C++)
       {
           ans= Math.min(ans,helper(A,0,C,memo));
       }
       return ans;
       
   }
   
   private int helper(int[][] A,int R, int C,int[][] memo)
   {
       if(R<0 || C<0 || R>A.length-1 || C>A[0].length-1)
           return 101;
       
       if(R == A.length -1 )
           return A[R][C];
       
       if(memo[R][C]!=0) return memo[R][C];
    
      
       int left =  helper(A,R+1,C-1,memo);
      int middle = helper(A,R+1,C,memo);
      int  right = helper(A,R+1,C+1,memo);
      memo[R][C] = Math.min(left , Math.min(middle  ,right)) + A[R][C];

      return memo[R][C];
       
   }
}

