/*
 * #931. Minimum Falling Path Sum
 * 
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

 

Constraints:

1 <= A.length == A[0].length <= 100
-100 <= A[i][j] <= 100

 */

/*
 * Time Complexity: O (N^2) -> Two for loops
 * 
 * Space Complexity: O (1) -> Not using any extra space
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.DP3;

public class FallingMinimum {
	
public int minFallingPathSum(int[][] A) {
        
		// Base condition
		// If 2D array is null or length of row or column is 0, then return 0
        if(A == null || A.length == 0 || A[0].length == 0){
            return 0;
        }
        
        /*
         * A = [ [1,2,3],
         * 		 [4,5,6],
         * 		 [7,8,9]
         * 				]
         * 
         * Start with the 2nd row(index=1), so that we have values from previous row to compute path
         * Start with 1st column(index=0)
         * We have three conditions:
         * 	- When 'j' is at the beginning -> valid columns for previous row would be j = 0 and j = j+1 (column difference should be atmost 1, i.e; -1(left), 0(same column), and 1(right) according to problem description)
         * 	- When 'j' is at the end -> valid columns for previous row would be j = A[0].length-1 and j = j-1
         * 	- When 'j' is in the middle -> valid columns for previous row would be j = middle index, j = middle - 1; j = middle + 1
         * 
         * For each of the three conditions, compute the minimum values at each row 
         * 	- by adding minimum of previous row possible path elements to current 'j'th element
         * 
         * When all the minimum values are computed at the last row
         * 	- take the last row from array, traverse through the values and return the minimum from them
         * 	- that element will be the minimum falling path value, our output
         * 
         */
        for(int i =1; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                if(j == 0){
                    A[i][j] += Math.min(A[i-1][j], A[i-1][j+1]);
                }
                else if(j == A[0].length-1){
                    A[i][j] += Math.min(A[i-1][j], A[i-1][j-1]);
                }
                else{
                    A[i][j] += Math.min(A[i-1][j-1], Math.min(A[i-1][j], A[i-1][j+1]));
                }
            }
        }
        
        /*
         * Get the minimum falling path (sum of elements in the min path) from last row of 2D array
         */
        int min = Integer.MAX_VALUE; // Initialize the value of min
        
        // Get the last row and traverse through all elements by using 'num' pointer to get minimum value
        for(int num : A[A.length-1]){ 
            if(num < min){
                min = num;
            }
        }
        
        return min; // return the minimum path value
        
    }

}
