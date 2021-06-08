class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {

        //(O(n) time and O(1) space but solution does not work in all cases will update
        int max = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                nums[i - 1] = 0;
                nums[i + 1] = 0;
            }
        }
        return max;

    }
}