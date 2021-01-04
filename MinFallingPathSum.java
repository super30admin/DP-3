// Time Complexity : The time complexity is O(n^2) where n is the length of the array
// Space Complexity : The spave complexity is O(n^2) where n is the length of the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {

    public int minFallingPathSum(int[][] A) {

        // Array which stores the optimal sum at each level
        int[][] dp = new int[A.length+1][A[0].length];

        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        for(int i=0;i<A[0].length;i++){
            dp[0][i] = 0;
        }

        // Traverse through the dp array to fill the optimal sums
        for(int i=1;i<dp.length;i++){

            for(int j=0;j<dp[0].length;j++){

                // The next level should be atmost one step far
                for(int k=j-1;k<=j+1;k++){
                    if(k >=0 && k<dp[0].length){
                        dp[i][j] = Math.min(dp[i][j],dp[i-1][k]);
                    }
                }
                dp[i][j] = A[i-1][j] + dp[i][j];
            }
        }

        int min = Integer.MAX_VALUE;

        // The minimum sum is stored in the last level
        for(int i=0;i<dp[0].length;i++){
            min = Math.min(min,dp[dp.length-1][i]);
        }

        return min;
    }
}

// Time Complexity : The time complexity is 3^n where n is the length of the array
// Space Complexity : The space complexity is O(n) where n is the length of the array since an internal stack is used for recursive calls.
// Did this code successfully run on Leetcode : No(Time Limit Exceeded)
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {

    public int minFallingPathSum(int[][] A) {

        return recursive(A,0,-1);

    }

    public int recursive(int[][] A,int index,int prev){

        if(index == A.length){
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for(int i=0;i<A[0].length;i++){

            // The next level should be atmost one step far
            if(prev != -1){
                if(i >= prev-1 && i <= prev+1){
                    int val = A[index][i] + recursive(A,index+1,i);
                    min = Math.min(min,val);
                }
            }
            else{
                int val = A[index][i] + recursive(A,index+1,i);
                min = Math.min(min,val);
            }
        }

        return min;

    }
}
