
//Time complexity of this function: O(n2) 
//Space Complexity of this function: O(1) 

//Did this code successfully run on Leetcode : no
//Any problem you faced while coding this: no

//this is bottom up approach so I want to know  top down appraoch which I learnt in the session.
	import java.io.*; 
	  
	class MinPathFalling { 
	
	  
	// Function to return minimum path falling sum 
	static int minFallingPathSum(int A[][]) 
	{ 
		 int n = A.length; 
	    // R = Row and C = Column 
	    // We begin from second last and column 0
	   
	    for (int R = n - 2; R >= 0; --R) { 
	        for (int C = 0; C < n; ++C) { 
	  
	            // best = min(A[R+1][C-1], A[R+1][C], A[R+1][C+1]) 
	        	//cosider best element is next row and current column element 
	            int best = A[R + 1][C]; 
	            //if column index is greater than 0 then consider min element from best and next row ,earlier column.
	            if (C > 0) 
	                best = Math.min(best, A[R + 1][C - 1]); 
	            //this condition is valid till second last column so in this condition we will also compare best from earlier check with next row and next column element.
	            if (C + 1 < n) 
	                best = Math.min(best, A[R + 1][C + 1]); 
	            //add element which is best means minimum element from next row to current value.
	            A[R][C] = A[R][C] + best; 
	        } 
	    } 
	  
	    //iterate on first row and take min value from first row
	    int ans = Integer.MAX_VALUE; 
	    for (int i = 0; i < n; ++i) 
	        ans = Math.min(ans, A[0][i]); 
	    return ans; 
	} 
	  
	// Driver program 
	public static void main (String[] args) { 
	            int A[][] = { { 1, 2, 3,6 }, 
	                    { 4, 5, 6 ,1}, 
	                    { 7, 8, 9 ,0} ,
	                    { 1, 4, 3 ,0}}; 
	  
	    // function to print required answer 
	    System.out.println( minFallingPathSum(A)); 
	    } 
	}

