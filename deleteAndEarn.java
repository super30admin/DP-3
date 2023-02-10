class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = nums[0];
        
        //find max element 
        for(int n: nums){
            max = Math.max(max, n);
        }
        
        //new array to store sum of all elements
        int[] arr = new int[max+1];
        for(int n: nums){
            arr[n] += n;
        }
        
        int prev = 0;
        int curr = arr[1];
        
        for(int i=2;i<arr.length; i++){
            int temp = curr;
            curr = Math.max(curr, prev + arr[i]);
            prev = temp;
        }
        
        return curr;
    }
}
