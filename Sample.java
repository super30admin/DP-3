//Delete and Earn
//Time Complexity : O(n)+O(max(n))
//Space Complexity : O(max(n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num : nums){
            max = Math.max(max,num);
        }
        int[] arr = new int[max+1];
        for(int num : nums){
            arr[num] +=num;
        }
        int choose = arr[0];
        int notchoose = arr[1];
        for(int i=2; i<arr.length; i++){
            int temp = choose;
            choose = Math.max(choose,notchoose);
            notchoose=temp+arr[i];
        } 
        return Math.max(choose,notchoose);
    }
}

//Minimum Falling Path Sum
// Your code here along with comments explaining your approach
//Time Complexity : O(m*n)+O(m)
//Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution1 {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]);
                } else if (j == n - 1) {
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]);
                } else {
                    matrix[i][j] += Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][j - 1], matrix[i - 1][j + 1]));
                }
            }
        }
        for (int j = 0; j < m; j++) {
            res = Math.min(res, matrix[m - 1][j]);
        }
        return res;
    }
}