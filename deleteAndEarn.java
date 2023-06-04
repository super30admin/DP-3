//Pre process the data to be in a ausable
// like take an array of size maximum number in the array
//with respect to that index add the score if we select the 
class Solution {
    public int deleteAndEarn(int[] nums) {
        //null
        if(nums == null || nums.length == 0)return 0;
        int max = 0;
        //We first find maximum number in input array
        for(int num: nums)
        {
            max = Math.max(max,num);
        }
        //Creating a new array of length of max number
        int [] arr = new int[max+1];
        //We assign the scores if we choose the number wrt Index
        for(int i=0;i<nums.length;i++)
        {
            int curr = nums[i];
            arr[curr] += curr;

        }
        //house robber array
        int [] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        for(int i=2;i<arr.length;i++)
        {
            dp[i] = Math.max(dp[i-1],arr[i]+dp[i-2]);
        }
        return dp[arr.length-1];

    }
}