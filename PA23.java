Time complexity : O(n^2)
Space Complexity: O(1) 

class Solution {
    public int minFallingPathSum(int[][] A) {
       
        int msum=Integer.MAX_VALUE;
        if(A.length ==1){
            for(int j=0;j<A[0].length;j++){
                msum = Math.min(msum, A[0][j]);
            }
            return msum;
        }
        
        for(int i=1;i<A.length;i++){
           
            for(int j=0;j<A[0].length;j++){

                if(j==0 || j== A[0].length-1 ){
                    if(j==0){
                         A[i][j]= A[i][j] + Math.min(A[i-1][j],A[i-1][j+1]);
                    }
                    
                    else{
                        A[i][j]= A[i][j] + Math.min(A[i-1][j],A[i-1][j-1]);
                    }
                    
                }
                else{
                    A[i][j]= A[i][j] + Math.min(A[i-1][j-1],Math.min(A[i-1][j],A[i-1][j+1]));
                }
                
                    if(i==A.length-1){
                        msum= Math.min(msum,A[i][j]);
                    }
            }
        }
        return msum;
    }
}