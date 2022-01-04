public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {// TC O(N) + O(max(n))
            return 0;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] arr = new int[max + 1];// SC O(max(n))
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] += nums[i];
        }

        int n = arr.length;
        int skip = 0;

        // int [][] dp = new int[nums.length][2];
        int take = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = skip;
            skip = Math.max(take, skip);
            take = temp + arr[i];

        }
        return Math.max(skip, take);
    }
}
