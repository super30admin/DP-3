package DynamicProgramming3;

public class question25_deleteAndEarn {

    /*
    Dynamic Programming
        Time Complexity: O(n)
        Space Complexity: O(1)
     */
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = 0;
        for(int num: nums) {
            max = Math.max(max, num);
        }
        int[] arr = new int[max + 1];
        for(int num: nums){
            arr[num] += num;
        }
        int skip = 0;
        int take = arr[0];

        for(int i = 0 ; i < arr.length ; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + arr[i];
        }
        return Math.max(skip, take);
    }

    public static void main(String[] args) {

    }
}
