//Time Complexity: O(max)
//Space Complexity: O(max)
//Did this code successfully run on Leetcode : Yes
//Approach: Just like the house robber problem where the thief could not rob adjacent houses without alarming the police,
//in this problem, the user has to delete val - 1, val + 1 from the arr upon taking val into the total money
//for eg: if you choose 3, you cannot take 2 and 4 into consideration
//In order to be able to truly have numbers aligned in increasing order, we find the max value in the array and make an array of size max + 1 and fill it in with values
//And then if there is 1 element in the arr, you can only take that, if there are two, you can take the one that has more money to offer
////if there are more than 2, then you will choose the max amount by selecting the max(amount at current + the max amount at i - 2, max amount at i - 1)
/**
 * Returns the max money user can earn
 */
public class DeleteAndEarn {

    /**
     *
     * @param nums the nums array
     * @return     the max money user can earn
     */
    public int deleteAndEarn(int[] nums) {
        int max = -1;
        for (int num: nums) max = Math.max(max, num);

        int[] arr = new int[max + 1];
        for (int num: nums) arr[num] += num;

        int prev = arr[0], curr = Math.max(prev, arr[1]);

        for (int i = 2; i < arr.length; i++) {
            int temp = curr;
            curr = Math.max(curr, prev + arr[i]);
            prev = temp;
        }

        return curr;
    }

    public static void main(String[] args) {
        final DeleteAndEarn deleteAndEarn = new DeleteAndEarn();
        System.out.println(deleteAndEarn.deleteAndEarn(new int[] {2, 1, 8, 1, 2, 4, 4, 6, 4, 4, 7, 3, 3, 7})); //return 34
        System.out.println(deleteAndEarn.deleteAndEarn(new int[] {2,2,3,3,3,4})); //return 9
    }
}
