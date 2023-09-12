                  // Delete And Earn

// Time Complexity : O(n) 
// Space Complexity : O(max+1) ... max = greatest integer in input array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int deleteAndEarn(int[] nums) {
        // frequency of each element

        int max = 0;

        for(int num : nums)
            max = Math.max(max, num);

        int[] arr = new int[max+1];

        for(int num : nums)
            arr[num] += num;
        
        int choose = 0;
        int notChoose = 0;

        for(int i=1;i<arr.length;i++){
            int temp = notChoose;
            notChoose = Math.max(choose, notChoose);
            choose = temp + arr[i];
        }
        return Math.max(choose, notChoose);
    }
}

                  // Minimum Path Falling Sum

// Time Complexity : O(n^2) .. n = dimension of sqaure matrix 
// Space Complexity : O(1) .. if allowed to modify input array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
 
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int add = 0;
                if(j == 0)
                    add = Math.min(matrix[i-1][j], matrix[i-1][j+1]);
                else if(j == matrix[0].length-1)
                    add = Math.min(matrix[i-1][j], matrix[i-1][j-1]);
                else add = Math.min(matrix[i-1][j], Math.min(matrix[i-1][j-1], matrix[i-1][j+1]));

                matrix[i][j] += add;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++){
            min = Math.min(min, matrix[matrix.length-1][i]);
        }
        return min;
    }
}
