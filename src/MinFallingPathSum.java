// Time Complexity : o(n^2) n = size of square matrix
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

/**
 * variation of paint the house problem
 * https://leetcode.com/problems/minimum-falling-path-sum/submissions/
 * Given a square array of integers A, we want the minimum sum of a falling path through A.

A falling path starts at any element in the first row, and chooses one element from each row.  The next row's choice must be in a column that is different from the previous row's column by at most one.

 

Example 1:

Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: 12
Explanation: 
The possible falling paths are:
[1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
[2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
[3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
The falling path with the smallest sum is [1,4,7], so the answer is 12.

 

Note:

1 <= A.length == A[0].length <= 100
-100 <= A[i][j] <= 100

 *
 */
public class MinFallingPathSum {

public int minFallingPathSum(int[][] A) {
        
        //commented block needed for recursive bruteForce
        /*
        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<A[0].length;i++) {
            int res = bruteForce(A,0,0,i);
            if(res < min)
                min = res;
        }
         return min;
         
         */
        
        return dpSolution(A);
    }
    
    private int dpSolution(int[][] costs) {
        if(costs ==null || costs.length ==0) return 0;
        
        int m = costs.length, n = costs[0].length;
        
        for(int i=1; i<m; i++) {
            for(int j=0; j<n; j++) {
                int case1 = Integer.MAX_VALUE;
                int case2 = Integer.MAX_VALUE;
                int case3 = Integer.MAX_VALUE;
                
                /**
                 * we can select current column j , means fall on current column j from
                 * previous row j-1, j, j+1 columns, since we have j-1 and j+1 we need to have
                 * index bound check, get minimum from previous columns, j-1,j,j+1
                 */
                int col = j-1;
          
                if(col >=0) {
                    case1 = costs[i-1][col];
                }
                
                col = j;
                case2 = costs[i-1][col];
                
                col = j+1;
                if(col < n)
                    case3 = costs[i-1][col];
                
                costs[i][j]+=Math.min(case1, Math.min(case2, case3));
            }
        }
        
        /**
         * get min from the last row
         */
        int min = Integer.MAX_VALUE;
        for(int j=0; j<n;j++){
            if(costs[m-1][j] < min)
                min = costs[m-1][j];
        }
        
        return min;
    }
    
    private static int bruteForce(int[][] costs, int row, int min, int prevColumn) {
		// base
		// if all houses are covered, we reached the end
		if(row == costs.length) return min;
		
		//logic
       
        int case1 = Integer.MAX_VALUE;
        int case2 = Integer.MAX_VALUE;
        int case3 = Integer.MAX_VALUE;
    
        
        //case1
        int col = prevColumn - 1;
        
        if(col>=0)
            case1 = bruteForce(costs, row+1, min + costs[row][col], col);
        
        //case2
        col = prevColumn;
        case2 = bruteForce(costs, row+1, min + costs[row][col], col);
        
        
        //case3
        col = prevColumn + 1;
        
        if(col < costs[0].length)
               case3 =  bruteForce(costs, row+1, min + costs[row][col], col);
		
		return Math.min(case1,Math.min(case2,case3));
	}
}
