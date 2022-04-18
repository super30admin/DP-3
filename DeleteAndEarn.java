// Time Complexity : O(n) n is nums length, as we go through the nums array twice
// Space Complexity :O(n) as we use 1 aux array, n is nums length
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.Arrays;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[] contri = new int[Arrays.stream(nums).max().getAsInt()+1];
        Arrays.fill(contri, 0);
        for(int n : nums){
            contri[n] += n;
        }

        int inc = 0, exl = 0;
        for(int c : contri){
            int temp = Math.max(inc, exl);
            inc = exl+c;
            exl = temp;
        }
        return Math.max(inc, exl);
    }
}
