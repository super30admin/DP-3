//Time Complexity - O(max(nums))
//Space Complexity - O(max(nums))

class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] arr = new int[max + 1];
        for (int num : nums) {
            arr[num] += num;
        }

        int prev = arr[0];
        int curr = arr[1];

        for (int i = 2; i < arr.length; i++) {
            int temp = curr;
            curr = Math.max(curr, arr[i] + prev);
            prev = temp;
        }

        return curr;
    }

}
