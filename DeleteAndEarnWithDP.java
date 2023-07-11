// Time Complexity : O(n + max(n))
// Space Complexity : O(max(n))
// Did this code successfully run on Leetcode : Yes

public class DeleteAndEarnWithDP {
    public static int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int max = 0;
        for(int i=0; i< nums.length;i++)
        {
            max = Math.max(max,nums[i]);
        }
        int[] sortedSumArr = new int[max+1];

        for(int i=0; i<nums.length; i++)
        {
            sortedSumArr[nums[i]] =  sortedSumArr[nums[i]] + nums[i];
        }

        int prev = sortedSumArr[0];
        int curr = Math.max(sortedSumArr[0], sortedSumArr[1]);
        int temp = 0;

        for(int i=2; i<sortedSumArr.length; i++)
        {
            temp = curr;
            curr = Math.max(curr, sortedSumArr[i]+prev);
            prev = temp;
        }
        return curr;
     }

    public static void main(String args[]) {
        int nums[] = {1,1,1,2,4,5,5,5,6};
        //deleteAndEarn(nums);
        System.out.println(deleteAndEarn(nums));
    }
}
