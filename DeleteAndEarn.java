// Time Complexity : O(n) + O(m) m is max Element
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num : nums){
            max = Math.max(max, num);
        }
        int[] arr = new int[max+1];
        for(int num : nums){
            arr[num] += num;
        }
        return rob(arr);
    }
    private int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int choose = nums[0];
        int notChoose = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i ++){
            int temp =  nums[i] + choose;
            temp = Math.max(notChoose,temp);
            choose = notChoose;
            notChoose = temp;
        }
        return notChoose;
    }
}
