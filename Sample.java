// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        
       int max=0;
       for(int num:nums)
       {
           max=Math.max(max,num); //calculate the maximum number
       }
        
        int[] arr = new int[max+1]; //create an array of the max size
        
        for(int i=0; i<nums.length; i++)
        {
            int index= nums[i]; //calculate the total number of value at its index i.e value 2 at index 2
            arr[index]= arr[index]+ nums[i]; 
        }
        
        int skip=0; 
        int take=arr[0];
        
        for(int i=0; i<arr.length;i++)
        {
            int temp=skip; //store the skip into a temp variable
            skip=Math.max(skip,take); //if we skip the number, then new skip will be the max of previous skip and take
            take=arr[i]+temp; //if we are taking that number, then take will be previous skip plus that number
        }
        
        return(Math.max(skip,take)); //return max of skip and take
        
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix==null || matrix.length==0) return -1; 
        int n=matrix.length;
        
        for(int i=1; i<n; i++) 
        {
            for(int j=0; j<n;j++)
            {
                if(j==0)
                {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j] , matrix[i-1][j+1]); //if the element is the left most element, then the min would be the element above and diagonal to it
                }
                else if(j == n-1)
                {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j], matrix[i-1][j-1]); //if the element is the right most element, then the min would be the element above and diagonal to it
                }
                else
                {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j], Math.min(matrix[i-1][j+1], matrix[i-1][j-1])); //if the element is the middle element, then the min would be the element above and both the diagonals to it
                }
            }
        }
        
        int min= Integer.MAX_VALUE;
        
        for(int i=0; i< n; i++)
        {
            min= Math.min(min, matrix[n-1][i]); //calculate the min element from the last row
        }
        
        return min; 
    }
}