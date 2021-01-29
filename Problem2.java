// Time Complexity : O(MN) M is row, N is col
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this :N


// Your code here along with comments explaining your approach
class Solution {
    public int minFallingPathSum(int[][] A) {
        if(A.length==0 || A[0].length==0)
            return 0;

        for(int i=A.length-2;i>=0;i--){
            for(int j=0;j<A[0].length;j++){
                int min = A[i+1][j];
                if(j+1<A[0].length)
                    min = Math.min(min,A[i+1][j+1]);
                if(j>0)
                    min = Math.min(min,A[i+1][j-1]);
                A[i][j] += min;
            }
        }

        int result = Integer.MAX_VALUE;

        for(int i=0;i<A[0].length;i++){
            result = Math.min(result, A[0][i]);
        }

        return result;
    }
}