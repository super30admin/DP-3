public class DeleteAndEarn {

    // TC is O(n)+O(m) where n is nums length and m is the max element 
    // SC is O(m) as we are creating new array of m length
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 1) return nums[0];
        int max = 0;
        for(int i=0; i<nums.length;i++){ //find the maximum element to create array of max+1 elements
            max = Math.max(max, nums[i]);
        }
        int[] points = new int[max+1];
        for(int i=0; i<nums.length;i++){ // find the total of number occurences
            points[nums[i]]+=nums[i];
        }
        points[1] = Math.max(points[0],points[1]); 
        for(int i=2; i<points.length;i++){ // dp to choose alternate element
            points[i] = Math.max(points[i-1], points[i-2]+points[i]);
        }
        return points[points.length-1];
    }
}
