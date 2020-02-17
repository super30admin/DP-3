//Time Complexity: O(n^2)
//Space Complexity: O(1)

//Leet Code: Yes


class Solution {
    public int minFallingPathSum(int[][] A) {
        if(A == null || A.length == 0) return 0;
        int n = A.length;
        
        //Mutating the given square array 
        for (int i =1; i<n;i++){
            for (int j =0;j<n;j++ ){
                //if its a first column or last column-min of pre 2 elements in the above row
                if(j==0){
                    A[i][j]+=Math.min(A[i-1][j],A[i-1][j+1]);
                }
                if(j==n-1){
                    A[i][j]+=Math.min(A[i-1][j],A[i-1][j-1]);
                }else {
                    A[i][j]+=Math.min(A[i-1][j],Math.min(A[i-1][j],A[i-1][j+1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i =0;i<n-1;i++){
            min = Math.min(min,A[n-1][i]);
        }
        return min;
    }
}