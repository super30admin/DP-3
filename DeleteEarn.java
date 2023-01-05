public class DeleteEarn {


    //TC  O(max(n,max(nums))
    //SC O(max(nums))
    public static void main(String[] args) {
        int[] nums={2,2,3,3,3,4};
        System.out.println(deleteAndEarn(nums));
    }

    public static int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int num: nums) max = Math.max(num,max);
        int[] dp = new int[max+1];
        for(int i=0; i<n;i++){
            int index = nums[i];
            dp[index] = dp[index]+nums[i];
        }
        int skip =0,take= dp[0];
        for(int i = 1; i<max+1;i++){
            int temp = skip;
            skip = Math.max(skip,take);
            take = temp+dp[i];
        }
        return Math.max(skip,take);
    }
}
