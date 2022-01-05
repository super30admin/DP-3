//TC: O(n)
//SC: O(n)
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        int[] count = new int[max+1];
        for(int i = 0; i < nums.length; i++) {
            count[nums[i]] += nums[i];
        }
        int skip = 0;
        int take = 0;
        for(int i = 1; i < count.length; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + count[i];
        }
        return Math.max(skip, take);
    }
}
