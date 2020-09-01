public class DeleteEarnRec {

    public int deleteAndEarn(int[] nums) {
        return deleteAndEarnRec(nums, 0);

    }

    public int deleteAndEarnRec(int[] nums, int idx) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] storeTracker = new int[getMax(nums) + 1];

        for (int num : nums) {
            storeTracker[num] += num;

        }
        if (idx >= nums.length)
            return 0;

        int delYes = nums[idx] + deleteAndEarnRec(nums, idx + 2);
        int delNo = deleteAndEarnRec(nums, idx + 1);

        return Math.max(delNo, delYes);

    }

    int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        return max;
    }

    public static void main(String args[]) {
        DeleteEarn obj = new DeleteEarn();
        int arr[] = { 3, 4, 2 };
        System.out.println(obj.deleteAndEarn(arr));

    }

}