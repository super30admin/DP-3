// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        int arr[]=new int[max+1];
        for(int i=0;i<nums.length;i++){
            arr[nums[i]]=arr[nums[i]]+nums[i];
        }
        int skip=0;
        int take=arr[0];
        for(int i=1;i<arr.length;i++){
            int temp=skip;
            skip=Math.max(skip,take);
            take=temp+arr[i];
        }
        return Math.max(take,skip);
        
    }
}




// Time Complexity :O(mn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :nope


// Your code here along with comments explaining your approach

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        for(int i=matrix.length-2;i>=0;i--){
            for(int j=0;j<matrix[0].length;j++){
                if(j==0){
                    matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                }
                else if(j==matrix[0].length-1){
                     matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][j],matrix[i+1][j-1]);
                    
                }
                else{
                    matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][j],Math.min(matrix[i+1][j-1],matrix[i+1][j+1]));
                    
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            min=Math.min(matrix[0][i],min);
        }
        return min;
    }
}