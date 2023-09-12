//TC - O(N)
//SC - O(1)

public class DeleteandEarn {
    public static void main(String[] args) {
        DeleteandEarn d = new DeleteandEarn();

        int [] nums = {2,2,3,3,3,4};
        int result = d.deleteAndEarn(nums);
        System.out.println(result);


    }

        public int deleteAndEarn(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }
    
            int maxNumber = Integer.MIN_VALUE;
            for(int i:nums){
                maxNumber = Math.max(maxNumber, i);
            }
            System.out.println(maxNumber);
            int[] dp = new int[maxNumber+1];
    
            for(int i:nums){
                dp[i] += i;
            }
    
            int skip = 0;
            int take = dp[0];
    
            for(int i=1; i<dp.length; i++){
                int temp = skip;
                skip = Math.max(skip, take);
                take = dp[i] + temp;
    
            }
    
            return Math.max(skip, take);
        }
}
