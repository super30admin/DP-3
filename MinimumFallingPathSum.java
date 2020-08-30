//Time Complexity: O(n2)
//Space Complexity: O(1)
public class MinimumFallingPathSum {
    public static int minFallingPathSum(int[][] A) {
        int min = Integer.MAX_VALUE;
        for(int i=1; i<A.length; i++){
            for(int j=0; j<A.length; j++){
                //if index 0 we check the 0 and 1 index
                if(j == 0){
                    A[i][j] += Math.min(A[i-1][j],A[i-1][j+1]);
                }
                //if index length-1 we check the length -1 and length-2 index
                else if(j == A.length-1){
                    A[i][j] += Math.min(A[i-1][j],A[i-1][j-1]);
                }
                //else we check the else previous and after the current index and the same index itself
                else{
                    A[i][j] += Math.min(A[i-1][j-1],Math.min(A[i-1][j],A[i-1][j+1]));
                }
            }
        }
        for(int x:A[A.length-1])
            if(min > x)
                min = x;
        return min;
    }
    public static void main(String[] args) {
        int[][] path = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(minFallingPathSum(path));
    }
}