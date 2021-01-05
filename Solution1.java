// Time Complexity : O(n2)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int minFallingPathSum(int[][] A) {
        int l = A.length;
        for (int r = l-2; r>=0; --r)
        {
            for (int c =0; c<l; ++c)
            {
                int min = A[r+1][c];
                if(c > 0)
                    min = Math.min(min, A[r+1][c-1]);
                if(c+1 < l)
                    min = Math.min(min, A[r+1][c+1]);
                
                A[r][c] += min;
            }
        }
        int val = Integer.MAX_VALUE;
        for(int i: A[0])
            val = Math.min(val, i);
        
        return val;
    }
}