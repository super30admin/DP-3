/**Leetcode Question - 740 - Delete and Earn */
/** Algorithm - Same as the house Robber*/
public class DeleteAndEarn {
    class Solution {
        public int deleteAndEarn(int[] nums) {
            if(nums == null || nums.length ==0){
                return 0;
            }
            int max = 0;
            for(int num : nums){
                max = Math.max(max,num);
            }
            int[] mnums = new int[max + 1];
            for(int num : nums){
                mnums[num] = mnums[num] + num;
            }
            int skip =0, take =mnums[0];
            for(int i =1; i<mnums.length;i++){
                int temp = skip;
                skip = Math.max(skip,take);
                take = temp + mnums[i];
            }
            return Math.max(skip, take);
        }
    }
}
