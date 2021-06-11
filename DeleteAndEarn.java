class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] arr = new int[max + 1];
        for (int j = 0; j < nums.length; j++) {
            int index = nums[j];
            arr[index] += nums[j];
        }
        int skip = 0;
        int take = arr[0];
        for (int k = 0; k < arr.length; k++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + arr[k];
        }
        return Math.max(skip, take);
    }
}