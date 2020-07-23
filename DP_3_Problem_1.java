
//Time Complexity : O(n)
//Space Complexity: O(1)
//Run successfully on leetcode
//Problem : preprocessing the array

import java.util.Arrays;

public class DP_3_Problem_1 {
    public static int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int max = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(nums[i]>max)
            {
                max = nums[i];
            }
        }
        int[] modified = new int[max+1];
        Arrays.fill(modified,0);
        for(int i = 0 ; i < nums.length ; i ++)
        {
            modified[nums[i]] += nums[i];
        }
        int choose =0;
        int notChoose = 0;
        
        for(int i =1 ; i < modified.length ; i++)
        {
            int temp = Math.max(choose,notChoose);
            choose = notChoose + modified[i];
            notChoose = temp;

        }
        return Math.min(choose,notChoose);


    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 2};
        System.out.println(deleteAndEarn(nums));
    }
}
