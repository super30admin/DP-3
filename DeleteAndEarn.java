/*In this program, we use dynamic programming to delete and earn maximum points
 * the time complexity of this implementation is O(n)*/
class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int[] freq = new int[10001];
        for (int num : nums) {
            freq[num]++;
        }
        int prev = 0, curr = 0;
        for (int i = 1; i <= 10000; i++) {
            int maxPoints = Math.max(prev + i * freq[i], curr);
            prev = curr;
            curr = maxPoints;
        }
        return curr;
    }
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 3, 3, 4};
        DeleteAndEarn earn = new DeleteAndEarn();
        int maxPoints = earn.deleteAndEarn(nums);
        System.out.println("Maximum points that can be earned: " + maxPoints);
    }
}
