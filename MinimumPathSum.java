import java.util.*;

//Time Complexity : O(r*c) r=row,c=col
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public int minFallingPathSum(int[][] A) {
        if(A ==null || A.length==0) return 0;

        for(int i=1;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(j==0){

                    A[i][j] +=  Math.min(A[i-1][j], A[i-1][j+1]);

                }else if(j==A[0].length-1){

                    A[i][j]+=   Math.min(A[i-1][j],A[i-1][j-1]);

                }else{

                    A[i][j] += Math.min(
                                    Math.min( A[i-1][j-1], A[i-1][j] ),
                                    A[i-1][j+1]);
                }
            }
        }
        int min=Integer.MAX_VALUE;

        for(int j=0;j<A[0].length;j++){
            min=Math.min(min, A[A.length-1][j]);
        }
        return min;
    }
}
