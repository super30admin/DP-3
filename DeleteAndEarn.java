// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class DeleteAndEarn{
    public static void main(String[] args){
        DeleteAndEarn de = new DeleteAndEarn();
        int[] points = {4,5,2,2,1,2};
        int result=de.deleteAndEarn(points);
        System.out.print("Result: " +result);
    }
    public int deleteAndEarn(int[] nums) {

        //null check
        if(nums.length==0 || nums == null){
            return 0;
        }
        //finding the max integer
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            if(num>max){
                max = num;
            }
        }
        //creating a new array with the max+1 size and storing the integers at their respective indexes in new array from given nums array.
        int[] ar = new int[max+1];
        for(int i=0; i<nums.length;i++){
            ar[nums[i]]+=nums[i];
        }

        //House Robber problem approach (picking an index such that adjacent ones are not counted (Here, they'll be deleted))
        int C=0;
        int DC=0;

        for(int i=0;i<ar.length;i++){
            int temp = DC;
            DC = Math.max(C,DC);
            C=ar[i]+temp;
        }
        //returning the max value between the final Choose and Don't choose values.
        return Math.max(C,DC);
    }
}