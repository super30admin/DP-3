# DP-3

## Problem1: (https://leetcode.com/problems/delete-and-earn/)
// Time Complexity : O(N) or O(M)  - whichever is bigger , where N = number of elements in array, M = maximum number in array 
// Space Complexity : O(M), space used for freq array  
// Did this code successfully run on Leetcode :Yes 
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {

    public int deleteAndEarn(int[] nums) {
        int temp =0;
        int skip=0, take =0;
        int max=0;
         for(int i=0; i< nums.length; i++)
         {
             max = Math.max(max, nums[i]);
         }
        int[] freq = new int[max +1];
        for(int i=0; i< nums.length; i++)
        {
            freq[nums[i]]= freq[nums[i]] +nums[i];
            
        }
        
        for(int i=1; i< freq.length; i++)
        {
            temp = skip;
            skip =Math.max(skip, take);
            take = temp + freq[i]; 
        }
        
        return Math.max(skip, take); 
    }
    
    
    /* public int deleteAndEarn(int[] nums) {
         if(nums == null) return 0;
         int max =0;
            for(int i=0; i< nums.length; i++)
             {
                 max = Math.max(max, nums[i]);
             }
            int[] freq = new int[max +1];
            for(int i=0; i< nums.length; i++)
            {
                freq[nums[i]]= freq[nums[i]] +nums[i];

            }
             return delAndEarn(0,0,freq);
     }
    
    //exhaustive recursive approach for delete and earn 
    private int delAndEarn(int index, int profits, int[] freq)
    {
        //base
        if(index >= freq.length) return profits;
        //logic 
        int earnAdjacents = delAndEarn(index+1 , profits, freq);
            
        int earnThis = delAndEarn(index+2, profits +freq[index] , freq);
        
        return Math.max(earnAdjacents, earnThis);
    }*/
    
}


## Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)
// Time Complexity :O(M*N) - M*N are the dimensions of the matrix
// Space Complexity : O(1) - in place calculations, no additional space used  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your 
class Solution {
   /* public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for(int j=0; j< matrix[0].length; j++)
        {
            min= Math.min(min, minFallingPathSum(0,j,0,matrix));
        }
        
        return min;
    } */
     
    
   /*  private int minFallingPathSum(int row, int col, int cost, int[][] matrix)
    {
        //base
        if( row >= matrix.length  ) return cost;
         
         if( col < 0 || col >= matrix[0].length) return Integer.MAX_VALUE;
        
        
        //logic 
       
         int case1 =  minFallingPathSum(row+1, col-1, cost + matrix[row][col], matrix);                  
       
         int case2 =  minFallingPathSum(row+1, col+1, cost + matrix[row][col], matrix);  
        
         int case3 =  minFallingPathSum(row+1, col, cost + matrix[row][col], matrix);  
        
        return Math.min(case1, Math.min(case2, case3));
            
        
    }
    */
public int minFallingPathSum(int[][] matrix) {
        for(int i = matrix.length -2; i>=0; i--)
        {
           
            for(int j=0; j< matrix.length; j++)
            {
                int min =Integer.MAX_VALUE;
                if( 0 <= j-1)
                  min = Math.min(min, matrix[i+1][j-1]);
            
                  min = Math.min(min, matrix[i+1][j]);
                
                if(j+1 < matrix.length)
                  min = Math.min(min, matrix[i+1][j+1]);
                
                
                matrix[i][j]= matrix[i][j] + min;
                
            }
            
        }
        int result = Integer.MAX_VALUE;
        for(int j=0; j< matrix[0].length ; j++)
        {
            result = Math.min(result, matrix[0][j]);
        }
            
        return result;
        
    }
}