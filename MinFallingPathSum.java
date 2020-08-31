// Time Complexity : O(R*C) R - no of rows, C - no of columns
// Space Complexity : O(1) - updating existing array
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this :  no

//We will start from row 1 and subsequently calculate the min sum in all the rows below. 
//For any element, the utmost column difference can be 1. 
//The minimum value from previous row - same col or prev col or next col is added to cur element. 
//A new matrix is generated with combinations of falling sum. The min Sum is obtained from last row. 


public class MinFallingPathSum{

    public static int minFallingPathSum(int[][] A) {
        if( A == null || A.length == 0) return 0;
         /* 1 2 3
            4 5 6
            7 8 9 */
         int min = Integer.MAX_VALUE;
         
         for(int i = 1; i < A.length; i++){
             for(int j = 0; j < A[0].length; j++){
                 if(j == 0){
                     A[i][j] += Math.min(A[i-1][j], A[i-1][j+1]);
                 }else if(j == A[0].length-1){
                     A[i][j] += Math.min(A[i-1][j], A[i-1][j-1]);
                 }else{
                     A[i][j] += Math.min(Math.min(A[i-1][j-1], A[i-1][j+1]), A[i-1][j]);
                 }
             }
         }
         
         for( int j = 0; j < A[0].length; j++){
             min = Math.min( A[A.length-1][j], min);
         }
         return min;
     }

     public static void main(String[] args){
         int[][] A = {{-1,-2,-3,-4},
                      {-5,-6,-7,-8}};

        System.out.println(minFallingPathSum(A));
     }
}



