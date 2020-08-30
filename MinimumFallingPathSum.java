// Time Complexity : o(n2)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approachclass Solution {
    public int minFallingPathSum(int[][] A) {
        
        if(A.length == 0 || A[0].length == 0){
            return 0;
        }
        
        for(int i=1;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                
                if(j==0){
                    A[i][j]+=Math.min(A[i-1][j],A[i-1][j+1]);
                }else if(j==A[0].length-1){
                    A[i][j]+=Math.min(A[i-1][j-1],A[i-1][j]);
                }else{
                    A[i][j]+=Math.min(A[i-1][j],Math.min(A[i-1][j+1],A[i-1][j-1]));
                }
            }
        }
        int min= Integer.MAX_VALUE;
        for(int num : A[A.length-1]){
            if(num<min){
               min=num; 
            }
        }
        return min;
    }
    
}