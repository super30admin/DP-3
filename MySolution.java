class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0 ){
            return 0;
        }
        if(nums.length == 1 ){
            return nums[0];
        }
        int maxNum = 0;
        for (int i = 0; i<nums.length; i++){
            if (nums[i]>=maxNum){
                maxNum = nums[i];
            }

        }


       int[] countArr = new int[maxNum + 1];
        for (int i = 0; i<nums.length; i++){
            countArr[nums[i] - 1] +=nums[i] ;
        }

        int skip = 0;
        int take = 0;

        for (int i = 0; i<countArr.length; i++){
            int temp = skip;
            skip = Math.max(skip,take);
            take = countArr[i] + temp;
        }
        return Math.max(skip,take);
        }

    }
