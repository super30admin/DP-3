// TC - O(max(n))
// SC - O(max(n))
class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {

        if(nums == null || nums.length == 0) return 0;
        
        int max = 0;
        for(int num : nums) {
            max = Math.max(num, max);
        }
        int[] numArr = new int[max+1];
        for(int num : nums) {
            numArr[num] += num;
        }
        
        int n = numArr.length;      
        int prev = numArr[0];
        int curr = Math.max(numArr[0], numArr[1]);
        for(int i = 2; i < n; i++) {
            int tmp = curr;
            curr = Math.max(curr, prev + numArr[i]);
            prev = tmp;
        }
        return curr;
    }
}