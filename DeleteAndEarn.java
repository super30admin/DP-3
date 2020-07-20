//TC: O(n), n:number of elements in nums array
//SC: O(n)
//Approach:
//1. We reduce the problem to house robber, where we have to see just if either we delete this coin and earn, or we don't.
//2. To reduce the prblem to that level, complication lies in the fact that we don't the array sorted + we don't know the neighbors of any array element.
//3. We take another array of size equal to the maximum element in the given array, and fill this array with the given array elements, in such a way that
// element i goes to the index i, so [1,2,2,3] becomes, [0,1,4,3].
//4. Now, the problem is reduced and we can simply apply DP here where for every element we have 2 cases, choose or don't choose.

class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxNums = 0;
        for(int i = 0; i < nums.length; i++){
            maxNums = Math.max(maxNums, nums[i]);
        }
        int[] nums2 = new int[maxNums+1];
        int[][] dp = new int[maxNums+1][2];
        for(int i : nums){
            nums2[i] += i;
        }
        for(int i = 1; i < maxNums+1; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = nums2[i] + dp[i-1][0];
        }   
        return Math.max(dp[maxNums][0], dp[maxNums][1]);
    }
}
