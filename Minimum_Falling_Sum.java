package MinimumFallingSum;
//@Time Complexity - O(M) where M is number of rows, amd we are not considering n as it constant
//@Space Complexity - O(N)

public class Minimum_Falling_Sum {
	 public int minFallingPathSum(int[][] A) { 
	        
		// Base case if given array is null        
		        if(A == null || A.length == 0)
		        {
		            return 0;
		        }
		  int min = Integer.MAX_VALUE; // Intiating the min counter with Maximum integer value
		  int m = A.length; // Number of rows
		  int n = A[0].length;  //Number of columns         
		                                             
		      for(int i = 1; i< m ; i++)
		      {
		          for(int j = 0; j<n ; j++)
		          {
		              if(j==0) // If its the first column
		              {
		                  A[i][j] = A[i][j] + Math.min(A[i-1][j],A[i-1][j+1]);
		              }
		              
		              else if (j==n-1)//If its the last column
		              {
		                  A[i][j] = A[i][j] + Math.min(A[i-1][j],A[i-1][j-1]);
		              }
		              
		              else
		                  A[i][j] = A[i][j] + Math.min(Math.min(A[i-1][j],A[i-1][j-1]), A[i-1][j+1]);
		                  
		          }
		      }
		   //Now we'll loop over last row to select the minimum sum value                                          
		        for (int j = 0; j<n ; j++)
		        {
		            if(min>A[m-1][j])
		            {
		                min = A[m-1][j];
		            }
		        }
		                                             
		                                             
		       return min;
		        
		    }
	
	

	public static void main(String[] args) {
		
		int[][] arr = {{1,2,3}, {4,5,6},{7,8,9}};
		
		Minimum_Falling_Sum obj = new Minimum_Falling_Sum();
		int min = obj.minFallingPathSum(arr);
		System.out.println("The minimum falling sum for the given inpur is : "+min);
		
		// TODO Auto-generated method stub

	}

}
