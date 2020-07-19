// There are two approaches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Approach 1: Brute force
// Time Complexity : O(3^n) ~ Please confirm
//      n: number of elements
// Space Complexity :O(n)
//     n: number of elements
class Problem2BruteForce {

    /** find min path */
    public int minFallingPathSum(int[][] A) {

        // base condition
        if(A==null || A.length==0)
           return 0;
        // find min of all paths
        int min = Integer.MAX_VALUE;
        for(int i=0; i<A[0].length; i++){
            // start point i
            int value = helper(A, 0, i, 0);
            if(value< min)
                min = value;
        }
        return min;
    }
    
    /**
     * helper function
     * @param nums array
     * @param row row index
     * @param col col index
     * @param sum calculated path
     * @return int
     */
    public int helper(int[][] nums, int row, int col, int sum){

        // if reached end of path
        if(row >= nums.length)
            return sum;
        
        // adding current path value to sum
        sum += nums[row][col];
        
        // three choices index by adding  => -1, 0, 1
        int choice1, choice3;
        choice1 = choice3 = Integer.MAX_VALUE;
        
        // handling index out of bound 
        if(col-1 >= 0 )
            choice1 = helper(nums, row+1,col-1, sum);
        
        if(col+1 < nums[row].length)
            choice3 = helper(nums, row+1,col+1, sum);

        // same col will be valid always    
        int choice2 = helper(nums, row+1, col, sum);
            
        // return min of all three choices
        return Math.min(choice1, Math.min(choice2, choice3));
    }
}

// Approach 2: Dynamic programming
// Time Complexity : O(n)
//      n: number of elements
//      O(n*3)= O(n) here 3 for searching in 2 elemenst
// Space Complexity :O(1)
//     Using the matrix itself
class Problem2DP1 {

    /** finding min path */
    public int minFallingPathSum(int[][] A) {
      
        // base condition
        if(A==null || A.length==0)
            return 0;
        
        // iterate
        for(int i=1; i<A.length;i++){
            
            for(int j=0; j<A[i].length;j++){
                
                // bound lower
                if(j==0)
                    A[i][j] += Math.min(A[i-1][j],A[i-1][j+1]);
                // bound upper
                else if(j==A[i].length-1)
                    A[i][j] += Math.min(A[i-1][j-1],A[i-1][j]);
                else 
                    A[i][j] += Math.min(A[i-1][j], Math.min(A[i-1][j-1],A[i-1][j+1]));     
            }
        }
        
        
        // find min of all paths
        int min = Integer.MAX_VALUE;
        
        for(int val: A[A.length-1])
            if(min > val)
                min = val;

        // return minimum
        return min;
        
    }
    
}
