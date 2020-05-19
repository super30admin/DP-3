//time complexity O(n) + O(max[array])
//space complexity O(max[array])

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num: nums){
            max = Math.max(max, num);
        }
        int[] arr = new int[max+1];
        for(int num: nums){
            arr[num] += num;
        }
        int skip = 0; int take = 0;
        for(int i = 1; i < arr.length; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = arr[i] + temp;
        }
        return Math.max(skip, take);
    }
}
