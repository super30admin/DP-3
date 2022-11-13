/**
 * TC: O(max(n,m)) where n is nums length and m max element in nums
 * SC: O(n) where n is max element in nums
 */
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] preprocessed = new int[max];


        for(int i = 0; i < nums.length; i++) {
            preprocessed[nums[i] - 1] += nums[i];
        }

        int skip = 0, notSkip = preprocessed[0];

        for(int i = 1; i < preprocessed.length; i++) {
            int temp = Math.max(skip, notSkip);
            notSkip = skip + preprocessed[i];
            skip = temp;
        }

        return Math.max(skip, notSkip);
    }
}
