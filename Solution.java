//Recursive Brute Force Solution

// Time Complexity : 3 * n^3 // please check 
//Space Complexity : doubt
//Did this code successfully run on Leetcode : Yes but Time limit exceeded when submitted- 36 / 46 test cases passed.


// Similar to Paint house problem, but here we have any square matrix hence consider a for loop with column starting from 0 till A.length -1 
// we start from the 0 row and example column is 0 then path can only move directly below that is same column and column + 1 similarly
//column is between 0 and A.length -1 then path can  move 3 ways directly below that is same column, column + 1 adn column -1
// we then take a min of all the recursive cases and return min value

class Solution {
    public int minFallingPathSum(int[][] A) {
        // edge case 
        if(A.length == 0 || A == null) return 0;
        
        int minFall = Integer.MAX_VALUE; 
        
        for (int column = 0 ; column < A.length ; column ++){
        
          minFall = Math.min(minFall, helper(A, 0, 0, column ));
        }
        return minFall;
        
    }
    
    private int helper(int[] [] A, int min , int row, int column){
        
        //base 
        
        if(row >= A.length) return min;
        
        
        // logic 
        
        int case1 = Integer.MAX_VALUE; 
        
        // edge test case 
         if(column==0 && column==A.length-1){
            return Math.min(case1,A[row][column]);
        }
        
            if(column == 0){
               case1 =  Math.min(helper(A, min + A[row][0] , row + 1, column),
                helper(A, min + A[row][1] , row + 1, column + 1));
            }
        
            else if(column == A.length -1 ){
                case1 =  Math.min(helper(A, min + A[row][column - 1] , row + 1, column -1 ),
                helper(A, min + A[row][column] , row + 1, column));
            }
  
            else {
                case1 =  Math.min(helper(A, min + A[row][column - 1] , row + 1, column -1 ),
                                  Math.min(helper(A, min + A[row][column + 1] , row + 1, column + 1),
                                    helper(A, min + A[row][column] , row + 1, column)));
            }
        
            return case1;
    }
}