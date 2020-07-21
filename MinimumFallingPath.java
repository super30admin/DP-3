//Time Complexity : O(n*n) total size of matrix A
//Space Complexity : O(1)
/*Approach
-First row will reamin the same
-For further rows we are checking column and deciding what minimum value we can add from above row
-if col is leftmost we just have to see the value above it and right of it in above row
-if  col is rightmost we just have have to see value above it and left of it in above row
-if not then we can go either side of column and check in the same column as well in above row
-we just have to return the min value from last row
 */
public class MinimumFallingPath {
    public static int minFallingPathSum(int[][] A) { 
        if(A == null || A.length == 0) return 0;
        for(int i = 1; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                if(j==0){
                    A[i][j] += Math.min(A[i-1][j],A[i-1][j+1]);
                }
                else if(j == A[i].length-1){
                    A[i][j] += Math.min(A[i-1][j],A[i-1][j-1]);
                }
                else{
                    A[i][j] += Math.min(A[i-1][j],Math.min(A[i-1][j-1],A[i-1][j+1]));
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < A.length;i++){
            if(A[A.length -1][i] < result) result = A[A.length - 1][i];
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println(minFallingPathSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));   
        System.out.println(minFallingPathSum(new int[][]{{1,4,5},{8,5,6},{7,8,1}}));        
     
    }
}