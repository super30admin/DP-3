/*
 * Time : O(n*m) n=row m = col
 * Space: O(1)
 * 
 * 
 * */


public class Problem2 {
	  public static int minFallingPathSum(int[][] A) {
	        if(A==null || A.length==0)
	            return 0;
	        
	        for(int i=1;i<A.length;i++){
	            for(int j=0;j<A[0].length;j++){
	                if(j==0){
	                    A[i][j] += Math.min(A[i-1][j],A[i-1][j+1]);
	                }else if(j==A.length-1)
	                {
	                      A[i][j]+=Math.min(A[i-1][j],A[i-1][j-1]);
	                }else{
	                      A[i][j]+=Math.min(A[i-1][j],Math.min(A[i-1][j+1],A[i-1][j-1]));
	                }
	                
	            }
	        }
	        int min=Integer.MAX_VALUE;
	    for(int j=0;j<A[0].length;j++){
	        min= Math.min(A[A.length-1][j],min);
	    }
	        
	        return min;
	}
	  
	  public static void main(String args[]) {
		  int[][] arr = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		  int res=minFallingPathSum(arr);
		  System.out.println(res);
	  }
}
