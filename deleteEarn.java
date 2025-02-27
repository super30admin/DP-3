// time:O(max(n, max element)) space:O(max element)

class deleteEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }

        int max =0;
        for(int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        int[] dp = new int[max+1];

        for(int i=0; i<nums.length; i++){
            int idx = nums[i];
            dp[idx] = dp[idx] + idx;
        }

        int notchoose = 0;
        int choose = dp[0];
        for(int i=1; i< max+1; i++){
            int temp = notchoose;
            notchoose = Math.max(notchoose, choose);
            choose = temp + dp[i];
        }
        return Math.max(choose, notchoose);
    }
}
