class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num: nums){ // finding the maximum value in array
            max = Math.max(max, num);
        }
        int[] total = new int[max+1];
        for(int num: nums){
            total[num] += num;
        }
        int prev = total[0];
        int curr = total[1];
        for(int i =2; i < total.length; i++){
            int temp = curr;
            curr = Math.max(curr, prev + total[i]);
            prev = temp;
        }
        return curr;
    }
}

//tc: O(3n) -> O(n)
//sc: O(n)