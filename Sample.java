// Time Complexity : O(n+max(n))
// Space Complexity : O(max(n)+max(n)) = O(max(n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int max = Integer.MIN_VALUE; // to find max value from the nums array
      for(int i=0; i<nums.length; i++)
      {
         max = Math.max(nums[i], max); // finding the max value from the array
      }
        int value[]  = new int[max+1]; // creating the preprocessing array of size max+1 to include 0
       
        for(int num: nums)
        {
            value[num] = value[num] + num; // calculate earning at each index(number itself) given by sum of times the index value occured in the array
        }
        
        int dp[][] = new int[max+1][2]; // dp matrix that has the max value and two options for each: choose or not choose
        int n=dp.length;
        
        dp[0][0]=0; // fill initial row as 0
        dp[0][1]=0;
        
        for(int i=1; i<n; i++)
        {   //not choosing
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]); // max value from previous row i.e we are ot choosing the current value hence we can consider the max out of the previous value(for choosing and not choosing)
            //choosing
            dp[i][1] = dp[i-1][0] + value[i]; //if choosing then take the value from not choosing the previous value and add the value of choosing the current one
        }
        
        return Math.max(dp[n-1][0], dp[n-1][1]); // returning max from the last row which has two cases of choosing and not choosing the last value
    }
        
        
        
        
    }
}

// Time Complexity :O(n+max(n))
// Space Complexity : O(max(n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int max = Integer.MIN_VALUE;
      for(int i=0; i<nums.length; i++)
      {
         max = Math.max(nums[i], max);
      }
        int value[]  = new int[max+1];
       
        for(int num: nums)
        {
            value[num] = value[num] + num;
        }
        
        int prev_skip =0;
        int prev_take =0;
        
        for(int i=0; i<value.length;i++)
        {
            int temp = prev_skip; // storing prev value when not choosed
            prev_skip = Math.max(prev_skip, prev_take); // when not choosing current value we have to take max from the prev skip and take
            prev_take = temp + value[i]; // when choosing add prev value when prev skipped and add current value
            
        }
        
        return Math.max(prev_skip, prev_take);
        
        
        
    }
}

// Time Complexity : O(column* 2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Time Limit Exceeded


// Your code here along with comments explaining your approach

class Solution {
    public int minFallingPathSum(int[][] A) {
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < A[0].length; i++)
        {
           min = Math.min(min, helper(A, 0 , i, A[0][i])); // calling helper function for each column in first row
        }
        return min;
    }
    
    private int helper(int[][] A, int row, int column, int sum)
    {
        //base
        if(row >= A.length-1 ) // no column check as we want to traverse all rows for a path and then return sum
            return sum; // when rows finish we return the found sum on the path
        
        int case1 = Integer.MAX_VALUE; // to compare initially
        int case2 = Integer.MAX_VALUE;
        int case3 = Integer.MAX_VALUE;
        
        //logic
        // choosing
       
         case1 = helper(A, row+1 , column, sum + A[row+1][column]); // when chossing the column below
        if(column >=1 && column < A[0].length-1)
         case2 = helper(A, row+1 , column+1, sum + A[row+1][column+1]); // when chossing the column one more than the current column
        if(column >=1 && column < A[0].length-1)
         case3 = helper(A, row+1 , column-1, sum + A[row+1][column-1]); // when chossing the column one less than the current column
        
        return Math.min(case1, Math.min(case2,case3)); // to compare the sums returned by the paths
        
    }
}

// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Solution {
    public int minFallingPathSum(int[][] A) {
        if(A == null || A.length==0)
            return 0;
        int n = A.length;
        int m = A[0].length;
        for(int i=1; i<n;i++) // traversing and updating the given matrix
        {
            for(int j=0; j<m; j++)
            {
                int min = A[i-1][j]; // initializing and assigning the value of above column and above row as min
                if(j>0)
                {
                    min = Math.min(min, A[i-1][j-1]); // checking the found min with column one less than current column in above row
                }
                if(j<A.length-1)
                {
                    min = Math.min(min, A[i-1][j+1]); // checking the found min with column one more than current column in above row
                }
                
                A[i][j] += min; // updating the current value with found minimum
         
            }
        }
        
       int val = Integer.MAX_VALUE;
        for(int x : A[n-1])
        {
            val = Math.min(val, x); // traversing the last row and returning the minimum
        }
        return val;
    }      
}