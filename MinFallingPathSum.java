// Time Complexity : O(N*N) N = length of A
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class MinFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        int N = A.length;
        // We need to find the min of A[i+1][j-1], A[i+1][c], A[i+1][j+1]
        for(int i = N-2; i >= 0; i--){
            for(int j = 0; j < N; j++){
                int best = A[i+1][j];
                if(j > 0)
                    best = Math.min(best,A[i+1][j-1]);
                if(j+1 < N) // when it is starting column
                    best = Math.min(best, A[i+1][j+1]);
                A[i][j] += best;
            }
        }
        int ans = Integer.MAX_VALUE;
        // taking min of 1st row
        for(int x: A[0])
            ans = Math.min(ans,x);
        return ans;
    }
}