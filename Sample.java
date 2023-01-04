//Problem(1): Delete and earn

// Time Complexity :O(n) + o(max(n))
// Space Complexity : o(max(n))
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        //check if array is null
        if(nums == null || nums.length == 0) return 0;
        //determine maximum element from array for determining length of arr
        int max = nums[0];
        for(int num:nums){
            max = Math.max(max, num);
        }
        //create arr for storing weightage of every element 
        int [] arr = new int[max + 1];
        for(int num:nums){
            arr[num] += num;
        }
        //house robber pattern
        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);
        for(int i = 2; i<arr.length; i++){
            int temp = curr;
            curr = Math.max(curr, arr[i] + prev);
            prev = temp;
        } return curr;
    }
}

//Problem(2): Minimum falling path sum

// Time Complexity :O(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        //traverse through all elements except 1st row
        //calculate min element from above row and store it to the element
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j == 0){
                    matrix[i][j] += Math.min(matrix[i-1][j], matrix[i-1][j+1]);
                }else if(j == n-1){
                    matrix[i][j] += Math.min(matrix[i-1][j], matrix[i-1][j-1]);
                }else{
                    matrix[i][j] += Math.min(matrix[i-1][j], Math.min(matrix[i-1][j+1], matrix[i-1][j-1]));
                }
            }
        } for(int i = 0; i < n; i++){
            //compare all elements of the last row and store minimum element in min
            min = Math.min(min, matrix[n-1][i]);
        }
        return min;
    }
}