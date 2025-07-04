# DP-3
// Time Complexity : O(n)
// Space Complexity : O(max+1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
1. First we will find the highest element in the array and then we will make a points array to store the number of times that particular element is present in the array 
2. We will take two variables skip(representing that we are going to skip this element bcz we are suppose to skip i-1 and i+1) and take (representing that we are going to add the value of this element to our ans)
3. We will either return maximum of take or skip 
## Problem1: (https://leetcode.com/problems/delete-and-earn/)

class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] points = new int[max + 1];
        for (int num : nums) {
            points[num] += num;
        }

        int skip = 0;
        int take = 0;

        for (int i = 0; i <= max; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + points[i];
        }

        return Math.max(skip, take);
    }
}


## Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)
// Time Complexity : O(n*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
1. We will first try greedy approach but it fails to give us the correct ans and then we will go for exhaustive approach which will take the TC of 3^n which is a lot and then we observe that there are repetitive sub problems in the exhaustive approach and hence we can find the optimal solution using DP
2. We will run a loop from the second last row to the 0th row and modify the current value with the current value + min of((row+1, col-1),(row+1, col),(row+1, col+1))
3. We will run a second for loop in the 0th row of the matrix to return the min falling path sum

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int m = matrix.length;

        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                } 
                else if (j == m - 1) {
                    matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                }
                else {
                    matrix[i][j] += Math.min(matrix[i + 1][j], Math.min(matrix[i + 1][j - 1], matrix[i + 1][j + 1]));
                    
        }
    }
}

        // return min from the first row
        int min = Integer.MAX_VALUE;
        for (int val : matrix[0]) {
            min = Math.min(min, val);
        }

        return min;
    }
}