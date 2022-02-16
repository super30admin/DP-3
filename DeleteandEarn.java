class DeleteandEarn {
    public int deleteAndEarn(int[] nums) {
        if (nums == null)
            return 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] arr = new int[max + 1];
        for (int num : nums) {
            arr[num] += num;
        }

        int skip = 0, take = 0;
        for (int i = 1; i < arr.length; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + arr[i];
        }

        return Math.max(skip, take);

    }
}