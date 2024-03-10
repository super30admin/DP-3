class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int maximum = Integer.MIN_VALUE;
        for(int num: nums){
            maximum = Math.max(maximum,num);
        }
        int[] arr = new int[maximum+1];
        for(int num:nums){
            arr[num] += num;
        }
        int prev = arr[0];
        if(arr.length == 1){
            return prev;
        }
        if(arr.length == 2){
            return Math.max(arr[0],arr[1]);
        }
        int current = Math.max(arr[0],arr[1]);
        
        
        for(int i=2;i<arr.length;i++){
            int temp = current;
            current = Math.max(prev + arr[i],current);
            prev = temp;
        } 
        return current;
    }
}