//Problem : Minimum Falling Path Sum
// Time Complexity : O(n*m), n stands for number of rows while m stands for number of columns
// Space Complexity : O(1), not using extra space, modifying existing input
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution24 {
    
    public int minFallingPathSum(int[][] A) {
        
        if(A==null || A.length==0){
            return 0;
        }
        
        //Bottom Up
        
        int globalMin =Integer.MAX_VALUE;
        
        for(int i=A.length-2;i>=0;i--){
            for(int j=0;j<A[0].length;j++){
                
                if(j==0){
                    A[i][j] = A[i][j]+Math.min(A[i+1][j],A[i+1][j+1]);
                }else if(j==A[0].length-1){
                    A[i][j] = A[i][j]+Math.min(A[i+1][j],A[i+1][j-1]);
                }else{//j not on extreme nds
                    A[i][j] = A[i][j]+Math.min(A[i+1][j],Math.min(A[i+1][j-1],A[i+1][j+1]));
                }
                
            }
        }
        
        for(int j=0;j<A[0].length;j++){
            globalMin = Math.min(globalMin,A[0][j]);
        }
        
        return globalMin;
        
        
    }
}

//TopDown
//TC:O(n*m)=> n stands for number of rows while m stands for number of columns
//SC:O(n*m)=> n stands for number of rows while m stands for number of columns 
/*
class Solution {
    private int globalMin;
    private Integer[][] dp;
    public int minFallingPathSum(int[][] A) {
        
        if(A==null || A.length==0){
            return 0;
        }
        globalMin = Integer.MAX_VALUE;
        
        int lastRow = A.length-1;
        int lastCol = A[0].length-1;
        
        dp = new Integer[lastRow+1][lastCol+1];
        
        for(int i=lastCol;i>=0;i--){
            globalMin = Math.min(globalMin,calcMinSum(A,lastRow,i));
        }
        
        return globalMin;
    }
    
    private int calcMinSum(int[][] A, int row, int col){
        
        //base
        if(row<0 || col<0 || col>=A[0].length){
            return Integer.MAX_VALUE;
        }
        
        if(dp[row][col]!=null){
            return dp[row][col];
        }
        
        if(row==0){
            return A[row][col];
        }
        
        //logic
        int case1 = calcMinSum(A,row-1,col);
        int case2 = calcMinSum(A,row-1,col-1);
        int case3 = calcMinSum(A,row-1,col+1);
        
        return dp[row][col]=A[row][col]+Math.min(case1,Math.min(case2,case3));   
        
    }
    
}
*/
