// Time Complexity : O(N^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


class Solution {
    public int minFallingPathSum(int[][] A) {
        if(A == null || A.length == 0)
            return 0;
        int n = A.length;
        for (int i = n-2; i >=0; i--){
            for (int j =0; j < n; j++){
                int temp = A[i+1][j];
                if (j > 0)
                    temp = Math.min(temp, A[i+1][j-1]);
                if (j+1 < n)
                    temp = Math.min(temp, A[i+1][j+1]);
                A[i][j] = A[i][j] + temp;
            }
        }
        
        int result = Integer.MAX_VALUE;
        for (int x: A[0])
            result = Math.min(result, x);
        return result;
    }
}