
class Solution {
    public int deleteAndEarn(int[] nums) {
       if(nums == null || nums.length == 0)
           return 0;
        //find max
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>max)
                max = nums[i];
        }    
        // create the array
        int arr[] = new int[max+1];
        //add all the same elements and store at the element index in the array
        for(int i=0;i<nums.length;i++){
            arr[nums[i]]+=nums[i];
        }
        int choose = arr[0],dchoose = 0;
        for(int i=1;i<arr.length;i++){
            int temp = dchoose;
            dchoose = Math.max(choose,dchoose);
            choose = temp+arr[i];
        } 
        return Math.max(choose,dchoose);
    }
}