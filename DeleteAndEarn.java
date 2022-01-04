public class DeleteAndEarn {

    public static void main(String[] args) {
        int[] nums = {3,4,2};
        System.out.println(deleteAndEarn(nums));
    }

    public static int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        
        int[]  dp = new int[max+1];
        
        for(int i=0; i< nums.length; i++){
            dp[nums[i]] += nums[i];
        }
        int skip = 0, take = 0;
        for(int i=1; i<dp.length; i++){
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + dp[i];
        }
        return Math.max(skip, take);
    }
}
