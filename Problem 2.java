//The approach here is similar to house paint problem , Iam choosing the minimum number from one row above and adding the min to current index
//The minimum in above row has to be chosen only with j-1,j and j+1 values. 
//Time complexity-O(n^2) Space complexity- O(1)


class Solution {
    public int minFallingPathSum(int[][] A) {
         int n= A.length;
            for(int i=1;i<n;i++)
            {
                for(int j=0;j<n;j++)
                 {
                int best = A[i-1][j];
                if (j > 0)
                    best = Math.min(best, A[i-1][j-1]);
                if (j+1 < n)
                    best = Math.min(best, A[i-1][j+1]);
                
                    A[i][j] += best;
                }
            }
        int ans = Integer.MAX_VALUE;
        for (int x: A[n-1])
            ans = Math.min(ans, x);
        return ans;
         
    }

    }
