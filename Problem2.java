// Time Complexity : O(M*N) , M=length of array , N=length of each row
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// start from the second row
// find the minimum costs for each element chosen for previous step (difference of at most one) and add to the current chosen element
// do it for all the possible combinations 
// at the end we will get the costs of all the paths. select the minimum value path

class Solution {
    public int minFallingPathSum(int[][] A) {
        if(A.length == 0 || A == null){
            return 0;
        }
        
        for(int i =1;i<A.length;i++){
            for(int j = 0;j<A[i].length;j++){
                
                if(j == 0){
                    A[i][j] += Math.min(A[i-1][j],A[i-1][j+1]);
                }else if(j == A[i].length -1){
                    A[i][j] += Math.min(A[i-1][j],A[i-1][j-1]);
                }else{
                    A[i][j] += Math.min(A[i-1][j], Math.min(A[i-1][j-1],A[i-1][j+1]));
                }
            }
        }
        
        int min =Integer.MAX_VALUE;
        
        for(int j = 0;j<A.length;j++){
            min = Math.min(min,A[A.length -1][j]);
        }
        
        return min;
    }
}