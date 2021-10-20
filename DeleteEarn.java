
class DeleteEarn {
    public int delEarn(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        int[] hash = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            hash[i] = 0;
        }
        for (int i = 0; i < max; i++) {
            hash[i] += hash[nums[i]];
        }
        int skip = 0, take = 0;
        for (int i = 0; i < max; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = hash[i] + temp;
        }
        return Math.max(skip, take);
    }
}