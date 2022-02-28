/*
time complexity: O(max(M,N) where M is the max of all the elements
                and N is the length of the given nums array
space complexity : O(M) where M is the maximum of all elements, in worst case
                  all elements can be unique from 1 to maximum

approach : we first find the count of occurance of each element in the given nums
          and also we find the max of them. then we start from 1 till the maximum
          and then decide should we consider taking that element depending on the
          previous is taken or not.
*/

class Solution {
    public int deleteAndEarn(int[] nums) {

        int max = 0;
        int taken = 0;
        int nottaken = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            map.putIfAbsent(nums[i],0);
            int count = map.get(nums[i]) + 1;
            map.put(nums[i],count);
        }

        taken = map.getOrDefault(1,0);


        for(int i = 2; i <= max; i++){
            int temp = nottaken;
            nottaken = Math.max(taken, nottaken);
            taken = temp + map.getOrDefault(i,0) * i;
        }

        return Math.max(taken, nottaken);

    }
}
