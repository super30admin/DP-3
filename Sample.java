Time complexity: O(greatest element of array)
Space complexity: O(greatest element of array)

class Solution {
    public int deleteAndEarn(int[] nums) {
        
        //Edge case
        if(nums==null || nums.length==0)
            return 0;
        
        //Find max from the array
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        
        //Create dp array
        int[] dp = new int[max+1];
        
        //Putting all the elements at there place
        for(int n:nums){
            dp[n]+=n;
        }
        
        //Creating two new variables for each case sum
        int skip=0;
        int take=0;
        
        for(int n:dp){
            int temp=skip;
            skip= Math.max(skip,take);
            take=temp+n;
        }
        
        return Math.max(skip,take);
    }
}
-----------------------------------------------------------------------------------------------------------------------------
Time complexity: O(nm)
Space complexity: O(1)

class Solution {
    public int minFallingPathSum(int[][] A) {
        
        if(A.length==0 || A==null)
            return 0;
        
        int n=A.length;
        int m=A[0].length;
        int min=Integer.MAX_VALUE;
        
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                
                
                if(j==0)
                   A[i][j] = A[i][j] + Math.min(A[i-1][j],A[i-1][j+1]); 
            
                else if(j==m-1)
                   A[i][j] = A[i][j] + Math.min(A[i-1][j],A[i-1][j-1]);  
                
                else
                    A[i][j] = A[i][j] + Math.min(A[i-1][j],Math.min(A[i-1][j-1],A[i-1][j+1]));
            }
        }
        
      
        for(int j=0;j<m;j++){
            if(A[n-1][j]<min)
                min=A[n-1][j];
        }
        
        return min;
        
    }
}