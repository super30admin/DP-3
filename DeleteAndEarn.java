public class DeleteAndEarn {
    public static int deleteAndEarn(int[] nums) {
        int max=nums[0];
        for(int each:nums){
            max = Math.max(max,each);
        }
        // create array of length-->max number in nums+1
        // this array stores sum for that number index wise
        int[] temp = new int[max+1];
        for(int each:nums){
            temp[each]+=each;
        }
        int[] dp = new int[max+1];
        dp[0] = 0;
        dp[1] = temp[1];
        // max(not choose, choose)
        for(int i=2;i<=max;i++){
            dp[i] = Math.max(dp[i-1],temp[i]+dp[i-2]);
        }
        return dp[max];
    }

    public static void main(String[] args) {
        System.out.println(DeleteAndEarn.deleteAndEarn(new int[]{2,2,3,3,3,4}));
    }
}
