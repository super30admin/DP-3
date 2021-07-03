// Time Complexity : O(Max(N,Max in nums))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach


class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }
        
        int[] arr = new int[max + 1]; 
        
        for(int i = 0; i < nums.length; i++) {
            arr[nums[i]] +=nums[i];
        }
        
        int skip = 0;
        int choose = arr[0];
        
        for(int i = 0; i< arr.length; i++) {
            int tempSkip = skip;
            skip = Math.max(skip, choose);
            choose = tempSkip + arr[i];
        }
        
        return Math.max(skip, choose);
        
    }
}

// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 


class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        
        if(matrix.length == 1 && matrix[0].length == 1){
            return matrix[0][0];
        }
         
        for(int i = matrix.length - 2; i >= 0; i--) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(j == 0) {
                    matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                } else if(j == matrix[0].length - 1) {
                    matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                } else {
                    matrix[i][j] += Math.min(matrix[i+1][j], Math.min(matrix[i+1][j-1],matrix[i+1][j+1]));
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i <= matrix[0].length - 1; i++) {
            if(min > matrix[0][i]) {
                min = matrix[0][i];
            }
        }
        return min;
    }
}