//Problem 1
// Time Complexity : O(Max(length of nums, max element in nums))
// Space Complexity : O(n)

class Solution1 {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        //get the max value in nums and create a dp array of that size+1
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
        }
        int[] dp = new int[max+1];
        
        //populate the dp array with sum of every integer at their index
        for(int num : nums){
            dp[num] += num;
        }
        
        //house robber problem
        //choose and dont choose
        int c = 0, dc = 0;
        for(int i : dp){
            int temp = dc;
            dc = Math.max(c, dc);
            
            c = temp + i;
        }
        //return the max for choose and don't choose
        return Math.max(c, dc);
    }
}


//Problem 1
// Time Complexity : O(m*n)
// Space Complexity : O(1)
class Solution2 {
    public int minFallingPathSum(int[][] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        
        for(int i = 1; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                //1st coloumn
                if(j == 0){
                    //move to 1 row above i and choose the min between the j colomn and j+1 colomn
                    A[i][j] += Math.min(A[i - 1][j], A[i - 1][j + 1]);
                }
                //last coloumn
                else if( j == A[0].length-1){
                    //move to 1 row above i and choose the min between the j colomn and j-1 colomn
                    A[i][j] += Math.min(A[i - 1][j], A[i - 1][j - 1]);

                }
                //everything else
                else{
                    //move to 1 row above i and choose the min between the j colomn, j+1 colomn and j-1 colomn
                    A[i][j] += Math.min(A[i - 1][j], Math.min(A[i - 1][j + 1], A[i - 1][j - 1]));

                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int nums : A[A.length - 1]){
            min = Math.min(min, nums);
        }
        return min;
    }
}