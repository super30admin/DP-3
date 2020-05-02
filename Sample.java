// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//Delete and Earn
//Time o(n+m) -- m is the max element // n is the length of the array
//Space o(1) as the taken array size is less than the i/p array.

class Solution {
    public int deleteAndEarn(int[] nums) {
        //edge case
        if(nums == null || nums.length == 0)
            return 0;
        //find max to intialize the size of new array
        int max=0;
        for(int num: nums){
            max = Math.max(max,num);
        }
        //index 1 element should have neighbouring index 0 as 0, that's y max + 1;
        int[] arr = new int[max+1];
        for(int num:nums){
            arr[num]= arr[num] + num;
        }
        
        // now its's similar to robbing a place problem
        int notRob = arr[0], rob = arr[0];
        
        for(int i=1;i<arr.length;i++){
            int temp = notRob;
            notRob = Math.max(rob,notRob);
            rob = arr[i] + temp;
        }
        return Math.max(rob,notRob);
    }
}

//Minimum path sum
//Similar problem to paint house
//Time complexity o(mn)
//space o(1)
class Solution {
    public int minFallingPathSum(int[][] A) 
    {
        if(A == null || A.length == 0)
            return 0;
        int m = A.length, n = A[0].length;
        
        for(int i=1;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(j==0)
                {
                    A[i][j] = A[i][j] + Math.min(A[i-1][j],A[i-1][j+1]);
                }
                else if(j == n-1){
                    A[i][j] = A[i][j] + Math.min(A[i-1][j],A[i-1][j-1]);
                }
                else{
                    A[i][j] = A[i][j] + Math.min(A[i-1][j],Math.min(A[i-1][j-1],A[i-1][j+1]));
                }
            }
        }
        int minSum =A[m-1][0];
        for(int i=1;i<n;i++){
            minSum = Math.min(minSum,A[m-1][i]);
        }
        return minSum;
    }
}