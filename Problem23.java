//Time Complexity: O(n^2)
//Space Complexity: O(1)
//Did it run on leetcode: Yes
//Problems faced any: No

public class Problem23 {
    public int minFallingPathSum(int[][] A) {
        if(A==null || A.length==0 || A[0].length==0){
            return 0;
        }
        int min=Integer.MAX_VALUE;


        for(int i=1; i<A.length; i++){
            for(int j=0; j<A[0].length; j++){
                if(j-1<0){
                    A[i][j] = A[i][j] + Math.min(A[i-1][j], A[i-1][j+1]);
                }
                else if(j+1>=A.length){
                    A[i][j] = A[i][j] + Math.min(A[i-1][j-1], A[i-1][j]);
                }
                else
                {
                    A[i][j] = A[i][j] + Math.min(A[i-1][j-1], Math.min(A[i-1][j], A[i-1][j+1]));
                }

            }
        }

        for(int j=0; j<A[0].length; j++){
            if(A[A.length-1][j]<min)
                min = A[A.length-1][j];
        }

        return min;

    }
}
