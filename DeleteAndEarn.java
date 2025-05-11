/**
 * We are given an array and asked obtain a maximum based on the coditions.
 * Here the decision making parameter is just one, SO we can solve this using creating an array
 * An array of size that is the maximum value in the Array
 * Once we obtain it, its a choose and no choose game
 * We take curr and prev into picture
 * Curr = Holds the curr possible maximum value
 * Prev will have its previous maximum distanced to curr by 1 index.
 * 
 * Time Complexity = O(n)+O(max(num))
 * Space Complexity = O(n)
 */

class deleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num: nums){
            max = Math.max(max, num);
        }

        int[] total = new int[max+1];

        for(int num: nums){
            total[num] += num;
        }

        int prev = total[0];
        int curr = Math.max(total[0], total[1]);

        for(int i=2; i<=max; i++){
            int temp = curr;
            curr = Math.max(curr, total[i]+prev);
            prev = temp;
        }
    return curr;
    }
}