public class DP {
// Time Complexity : N
// Space Complexity : 1
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :yes, for space i am always using an auxillary array of size 10001
//irrespective of input hence according to me space complexity is constant. Is my understanding correct?
 //Problem1: (https://leetcode.com/problems/delete-and-earn/)
 public int deleteAndEarn(int[] nums) {
        int[] arr = new int[10001];
        for(int i =0;i<nums.length;i++){
            arr[nums[i]]=arr[nums[i]]+ nums[i]; 
        }
        for(int i =2;i<arr.length;i++){
            arr[i]=Math.max(arr[i-1],arr[i]+arr[i-2]);
        }
        return arr[arr.length-1];

}
// Time Complexity : N^2
// Space Complexity : N^2
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
 //Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)   
 public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i =0;i<matrix[0].length;i++){
            dp[dp.length-1][i]= matrix[matrix.length-1][i];
        }
       for(int i =dp.length-2;i>=0;i--){
           for(int j =0;j<dp[0].length;j++){
                dp[i][j]=matrix[i][j]+ Math.min(dp[i+1][j],Math.min(dp[i+1][Math.max(0,j-1)],dp[i+1][Math.min(dp.length-1,j+1)]));
           }
       }
       int result =Integer.MAX_VALUE;
       for(int i =0;i<dp.length;i++){
           result = Math.min(result,dp[0][i]);
       }

       return result;
}
 
}
