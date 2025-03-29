// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach - find sum of all occurances of each element and store it in a hashmap. Along with that find min and max element in that array. After that hashmap can be used as input. Also, we converted given problem to house robber problem. Use prev and curr. Initiate Prev as map.get(min), curr = prev, if min+1 is key in map then update curr as max betn prev and map.get(min+1). Loop in range min+2 to max and check if map contains i and update curr and prev accordingly. Finally answer is in curr.


import java.util.HashMap;

public class DeleteAndEarn {

    // public int deleteAndEarn(int[] nums) {
    //     int max = 0;
    //     for(int num: nums) {
    //         max = Math.max(max, num);
    //     }

    //     //create array for points sum
    //     int[] pointsArr = new int[max + 1];
    //     for(int num: nums) {
    //         pointsArr[num] += num;
    //     }

    //     //now problem is like house robber problem
    //     int prev = pointsArr[0]; //stores no choose values from previous
    //     int curr = Math.max(pointsArr[0], pointsArr[1]); //option of choosing current or prev

    //     for(int i = 2; i <= max; i++) {
    //         int temp = curr;
    //         curr = Math.max(curr, pointsArr[i] + prev);
    //         prev = temp;
    //     }

    //     return curr;
    // }

    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + num);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        //no need of input array anymore
        //iterate through map now
        //find prev and curr values as -
        int prev = map.get(min);
        int curr = prev;
        if(map.containsKey(min + 1)) {
            curr = Math.max(prev, map.get(min + 1));
        }

        //iterate through range of min + 2  and max
        //since we already created prev and curr earlier
        for(int i = min + 2; i <= max; i++) {
            int temp = curr;
            if(map.containsKey(i)) {
                curr = Math.max(curr, map.get(i) + prev);
            } else {
                curr = Math.max(curr, 0 + prev);
            }
            prev = temp;
        }

        return curr;
    }

    public static void main(String[] args) {
        DeleteAndEarn solver = new DeleteAndEarn();

        int[] nums1 = {3, 4, 2};
        System.out.println("deleteAndEarn([3,4,2]) => " + solver.deleteAndEarn(nums1));

        int[] nums2 = {2, 2, 3, 3, 3, 4};
        System.out.println("deleteAndEarn([2,2,3,3,3,4]) => " + solver.deleteAndEarn(nums2));
    }
}
