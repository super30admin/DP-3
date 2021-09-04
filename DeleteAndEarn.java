package DP3;
//Time complexity : O(n) as we are calculating min for each element
//Space complexity: O(n)
class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
        }
        int count[] = new int[max+1];
        for(int i=0;i<nums.length;i++){
            count[nums[i]] += nums[i];
        }
        int skip = 0, take = count[0];
        for(int i = 1;i<count.length;i++){
            int temp = skip;
            skip = Math.max(skip, take);
            take = count[i] + temp;
        }
        return Math.max(skip, take);
    }
}