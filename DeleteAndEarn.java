// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was able to think of hashing but couldn't relate it to house robber problem

class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(nums[i],max);
        }
        int[] arr = new int[max+1];
        for(int i=0;i<nums.length;i++){
            arr[nums[i]]+=nums[i];
        }

        int dp[] = new int[max+1];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        for(int i=2;i<arr.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+arr[i]);
        }
        return dp[arr.length-1];
    }

    public static void main(String[] args){
        DeleteAndEarn de = new DeleteAndEarn();
        int[] nums = new int[]{2,2,3,3,3,4};
        System.out.println(de.deleteAndEarn(nums));
    }
}