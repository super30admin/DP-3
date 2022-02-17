/*
Time Complexity: O(n)
Space Complexity: O(n)
Run on leetcode: Yes
Attempted after the class

 */
public class DeleteAndEarn {
    public static int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;

        for(int num: nums){
            max = Math.max(num, max);
        }

        int[] arr = new int[max+1];

        for(int i = 0; i<nums.length; i++){
            arr[nums[i]]+= nums[i];
        }

        int[] dp = new int[max+1];

        for(int i = 0; i<dp.length; i++){
            int select = arr[i]+ (i-2 >=0 ? dp[i-2] : 0);
            int notSelect = i-1>=0 ? dp[i-1] : 0;
            dp[i] = Math.max(select, notSelect);
        }
        return dp[max];
    }
    public static void main(String[] args){
        int[] costs = {3,4,2};
        System.out.println("Delete and Earn: "+ deleteAndEarn(costs));
    }
}
