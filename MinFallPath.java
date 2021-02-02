// Time Complexity :O(n*2)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//This is problem is similar to the house paint problem 


class MinFallPath {
    public int minFallingPathSum(int[][] A) {
        if(A==null ||A.length==0 || A[0].length==0){
            return -1;
        }
        int n=A.length;
        int m = A[0].length;
        
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(j==0){
                    A[i][j]+=Math.min(A[i-1][j],A[i-1][j+1]);
                }else if(j==m-1){
                    A[i][j]+=Math.min(A[i-1][j-1],A[i-1][j]);
                }else{
                    A[i][j]+=Math.min(A[i-1][j-1],Math.min(A[i-1][j],A[i-1][j+1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i:A[n-1]){
            if(i<min){
                min = i;
            }
        }
        return min;
        
    }
}
