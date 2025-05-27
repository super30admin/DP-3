public class DeleteAndEarn {
    static int deleteAndEarn(int[] nums) {
        int max = -1;
        for(int i : nums) {
            if(max < i) {
                max = i;
            }
        }

        int[] arr = new int[max + 1];
        for(int i : nums) {
            arr[i] += i;
        }

        int n = arr.length;
        if(n == 1) return arr[0];

        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);

        for(int i = 2; i < n; i++) {
            int next = curr;
            curr = Math.max(curr, arr[i] + prev);
            prev = next;
        }
        return curr;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,3,3,4};
        System.out.println("maximum number of points => " + deleteAndEarn(nums));
    }
}
