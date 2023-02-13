//Delete and earn
//time complexity : O(n+max(nums))
//Space complexity : O(max(nums)) 
class Solution {
    public int deleteAndEarn(int[] nums) {
        
        if(nums.length ==0||nums ==null) return 0;
        int max = nums[0];

        for(int num: nums){
            max = Math.max(max,num);
        }

        int[] sumA = new int[max+1];  
        for(int num : nums){
            sumA[num]+=num;
        }

        int prev = 0;
        int curr = sumA[1];

        for(int i =2; i<max+1 ; i++){
            int temp = curr;
            curr = Math.max(curr,prev+sumA[i]);
            prev = temp;
        }

        return curr;
    }
}

//Minimum Falling path sum

//Time Complexity O(m*n)
//Space complexity : O(m*n) where m=n
class Solution {
    public int minFallingPathSum(int[][] matrix) {

        if(matrix.length==0||matrix ==null)  return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int minSum = Integer.MAX_VALUE;
        
        int[][] dp = new int[m][n];

        for(int j=0; j< n ; j++){
            dp[m-1][j] = matrix[m-1][j];
        }

        for(int i =m-2;i>=0; i--){
            System.out.println("Reached");
            for(int j = 0; j<n; j++){

                if(j==0){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j],dp[i+1][j+1]);
                }
                else if(j==n-1){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j-1],dp[i+1][j]);
                } else {
                dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j-1],Math.min(dp[i+1][j],dp[i+1][j+1]));
                }

                if(i==0){
                minSum = Math.min(minSum,dp[0][j]);
                }
            }
        }

        if(m==1) return dp[0][0];
        return minSum;
    }
}
