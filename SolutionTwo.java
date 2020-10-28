// Time Complexity : O(n)
// Space Complexity : O(m) where m is the max size of the array
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : yes some problems while dry run,I couldnt come up with solution in time so I checked solution

class SolutionTwo {
    public int minFallingPathSum(int[][] A) {

        int n=A.length;

        for(int i=n-2;i>=0;i--)
        {
            for(int j=0;j<A[0].length;j++)
            {
                int min=A[i+1][j];

                if(j>0)
                    min=Math.min(min,A[i+1][j-1]);


                if(j+1<n)
                    min=Math.min(min,A[i+1][j+1]);

                A[i][j]=A[i][j]+min;


            }

        }

        int ans=Integer.MAX_VALUE;
        //last row contains min element pick from that
        for(int num:A[0])
            ans=Math.min(ans,num);

        return ans;

    }
}


