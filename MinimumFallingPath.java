   // Time Complexity  : o(m*n)
   //  Space Complexity  : o(1)
public class MinimumFallingPath {

	 public static void main(String args[]) {
         int A[][]= new int[][] {{1,2,3},{4,5,6},{7,8,9}};
         System.out.println(minCost(A));
     }


 public static int minCost(int A[][]) {

     if(A==null || A.length == 0 || A[0].length == 0)
         return 0;

     for(int i=1;i<A.length;i++){
         for(int j=0;j<A[0].length;j++){

             if(j == 0){
                 A[i][j] += Math.min(A[i-1][j],A[i-1][j+1]);
             }else if(j == A[0].length-1){
                 A[i][j] += Math.min(A[i-1][j],A[i-1][j-1]);
             }else{
                 A[i][j] += Math.min(A[i-1][j-1],Math.min(A[i-1][j],A[i-1][j+1]));
             }
         }
     }
     int min = Integer.MAX_VALUE;
     for(int num : A[A.length-1]){
         if(num < min)
             min = num;
     }
     return min;
 }
} 