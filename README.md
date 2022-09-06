# DP-3

## Problem1: Delete and Earn

```Java
// Time Complexity : O(n+k), where k is the max element till which we are iterating
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int deleteAndEarn(int[] nums) {
        //null check
        if(nums == null || nums.length == 0)
            return 0;

        int max = nums[0];

        for(int num : nums){ //O(n)
            max = Math.max(max, num);
        }

        int[] maxArr = new int[max+1];

        for(int num : nums){ //O(n)
            maxArr[num] += num;
        }

        int prev = 0;
        int curr = maxArr[1];

        for(int i = 2; i < maxArr.length; i++){ //O(max element in nums)
            int temp = curr;
            curr = Math.max(curr, prev+maxArr[i]);
            prev = temp;
        }
        return curr;
    }
}
```
## Problem2: Minimum falling path sum

```Java
// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution{
    public int minFallingPathSum(int[][] matrix) {

        //i = 0 start -> i++ => col-1, col, col+1 min check
        //add matrix value
        //return min(matrix[row-1][i]);

        int result = Integer.MAX_VALUE;
        int row = matrix.length;

        for(int i = 1; i < row; i++) {
            for(int j = 0; j < row; j++) {

                int lowBound = Math.max(0, j-1);
                int highBound = Math.min(j+1, row - 1);

                matrix[i][j] += Math.min(matrix[i-1][lowBound],
                        Math.min(matrix[i-1][j],
                                matrix[i-1][highBound]));
            }
        }

        for(int num : matrix[row-1]) {
            result = Math.min(num, result);
        }

        return result;
    }
}
```
