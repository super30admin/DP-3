//o(n) time and  0(1) space
//passed all leetcode case
//used dynamic programming similar to house robbery

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length ==0 ) return 0;
        Arrays.sort(nums);
        int choose = nums[0];
        int notchoose = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                choose += nums[i];
            }else if(nums[i]==nums[i-1]+1){
                int temp = notchoose;
                notchoose = Math.max(choose,notchoose);
                choose = nums[i]+temp;
            }else {
                int temp = notchoose;
                notchoose = Math.max(choose,notchoose);
                choose = nums[i]+Math.max(temp,choose);

            }

        }
        return Math.max(choose,notchoose);

    }
}