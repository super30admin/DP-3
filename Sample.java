// Problem 1
// Time Complexity : O(n)
// Space Complexity : O(1) -> No extra space 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Algorithm
// 1 - get max element
// 2 - initialize changed array with max element + 1 size
// 3 - generate changed array
// 4 - initiliaze choose and dontchoose
// 5 - iterate through changed array
// 6 - dontchoose is max of previous dontchoose and choose
// 7 - choose is previous dontchoose + current element
// 8 - return max of choose and dontchoose
class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        // 1
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        
        // 2
        int[] changedArray = new int[max + 1];
        // 3
        for (int num : nums) {
            changedArray[num] += num;
        }
        
        // 4
        int choose = 0;
        int dontChoose = 0;
        // 5
        for (int i=0; i<changedArray.length; i++) {
            int temp = dontChoose;
            
            // 6
            dontChoose = Math.max(choose, dontChoose);
            // 7
            choose = temp + changedArray[i];
        }
        
        // 8
        return Math.max(dontChoose, choose);
    }
}

// Problem 2
// Time Complexity : O(n x n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Algorithm
// 1 - iterate through i and j
// 2 - calculate min for jth = 0, jth = last element and for in between
// 3 - return min
class Solution {
    public int minFallingPathSum(int[][] A) {
        if (A.length == 0 || A == null || A[0].length == 0) {
            return 0;
        }
        
        // 1
        for (int i=1; i<A.length; i++) {
            for (int j=0; j<A[0].length; j++) {
                // 2
                if (j == 0) {
                    A[i][j] += Math.min(A[i - 1][j], A[i - 1][j + 1]);
                } else if (j == A[0].length - 1) {
                    A[i][j] += Math.min(A[i - 1][j], A[i - 1][j - 1]);
                } else {
                    A[i][j] += Math.min(A[i - 1][j], Math.min(A[i - 1][j - 1], A[i - 1][j + 1]));
                }
            }
        }
        
        // 3
        int min = Integer.MAX_VALUE;
        for (int num : A[A.length - 1]) {
            if (num < min) {
                min = num;
            }
        }
        
        return min;
        
    }
}