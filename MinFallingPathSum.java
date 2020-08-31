// Time Complexity : O(n*2)
// Space Complexity : O(1), manipulating input array, no extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing specific

//looping through the matrix, from index 1 as we dont have anything prior for index 0 to compare with
//each value in the matrix can be dealt with the value by atmost 1 column.
//for the 1st and law column, they have only 2 columns to deal with, remaining middle columns have 3 columns
//return the minimum of the elements from the last row.



class Solution {
    public int minFallingPathSum(int[][] A) {
        if(A==null|| A.length==0||A[0].length==0) return 0;        
        for (int i=1;i<A.length;i++){
            for(int j=0;j<A.length;j++){
                if(j==0){
                    A[i][j]+=Math.min(A[i-1][j],A[i-1][j+1]);
                }
                else if(j==A.length-1){
                    A[i][j]+=Math.min(A[i-1][j],A[i-1][j-1]);
                }
                else{
                  A[i][j]+=Math.min(A[i-1][j-1],Math.min(A[i-1][j],A[i-1][j+1]));  
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int nums:A[A.length-1]){
            if(nums<min){
                min=nums;
            }
        }
        return min;
    }
}