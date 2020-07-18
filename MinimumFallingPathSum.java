/**
 * Time Complexity: O(n^2) where n = length of A
 * Space Complexity: O(1)
 */
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        int n = A.length;
        for (int i = n-2; i >= 0; --i) {
            for (int j = 0; j < n; ++j) {
                int best = A[i+1][j];
                if (j > 0)
                    best = Math.min(best, A[i+1][j-1]);
                if (j+1 < n)
                    best = Math.min(best, A[i+1][j+1]);
                A[i][j] += best;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int x: A[0])
            ans = Math.min(ans, x);
        return ans;
    }

    public static void main(String args[]){
        MinimumFallingPathSum obj = new MinimumFallingPathSum();
        int[][] myArr = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("min = "+obj.minFallingPathSum(myArr));

    }
}