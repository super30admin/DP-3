//Prolem-1 Delete and Earn
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/* Here the basic idea is to convert the array into the workable form . To convert the array we try to find the maximum
element in the array. we declare the dp array of size maximum element +1. For iterate through the dp array if we store
the element in given array at that index in the dp array. If element already exists we add to the existing value over there.
In this way we can convert the given problem into house robber array. Now we can delete the adjacent elements as the same
way in house robber. It will lead us to the optimal solution.
*/


class Solution {

    public int deleteAndEarn(int[] nums) {
        int maxValue=0;
        int temp=0;
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        // if(nums.length==2) return Math.max(nums[0],nums[1]);
        for(int i=0;i<nums.length-1;i++){
            temp=Math.max(nums[i],nums[i+1]);
            if(temp>maxValue) maxValue=temp;
        }
        int [] dp=new int[maxValue+1];
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<nums.length;j++){
        //         if(nums[j]==i){
        //         dp[i]=dp[i]+i;
        //             }
        //     }
        // }
        for (int num:nums){
            dp[num]+=num;
        }
        if(dp.length==0) return 0;
        if(dp.length==1) return dp[0];
        if(dp.length==2) return Math.max(dp[0],dp[1]);
        int prev=dp[0];
        temp=0;
        int curr=Math.max(dp[0],dp[1]);
        for(int i=2;i<dp.length;i++){
            temp=curr;
            curr=Math.max(curr,dp[i]+prev);
            prev=temp;
        }
        return curr;
    }
}

//Prolem-2 Minimum Falling PathSum
// Time Complexity :O(n*n)
// Space Complexity :O(n*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :AM trying to find out the optimal approach for this problem.


// Your code here along with comments explaining your approach
/* Here the we start from the top-down approach. For every element we will be having three paths , either left ,bottom
and right.we try to fond out the min among themselves and add it to the sum(sum of that element and previous element in
the original array. In this way we try to move along all the paths. In the lastrow we will we having minimum of sums ,if we
start at the specific index.We try to find the minimum of last row and return that.
*/
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for(int r=0; r<rows; r++){
            if(r==0){
                for(int c=0; c<cols; c++){
                    dp[r][c] = matrix[r][c];
                }
                continue;
            }
            Arrays.fill(dp[r], -1);
        }

        for(int r=1; r<rows; r++){
            for(int c=0; c<cols; c++){
                int up=Integer.MAX_VALUE,left=Integer.MAX_VALUE, right=Integer.MAX_VALUE;

                if(c>0) left=dp[r-1][c-1];
                up=dp[r-1][c];
                if(c != cols-1) right = dp[r-1][c+1];
                int path = Math.min(left, right);
                path = Math.min(path, up);
                dp[r][c] = matrix[r][c] + path;
            }
        }

        int minPath = Integer.MAX_VALUE;
        for(int c=0; c<cols; c++){
            minPath = Math.min(minPath, dp[rows-1][c]);
        }
        return minPath;
    }
}