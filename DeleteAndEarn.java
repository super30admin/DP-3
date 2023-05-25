
public class DeleteAndEarn {

        public int deleteAndEarn(int[] nums) {

            if(nums == null || nums.length == 0) return 0;

            int maxi = 0;

            // finding maximum element in nums = length of consolidated array
            for(int n: nums){ // O(N)

                maxi = Math.max(n, maxi);
            }

            int[] cons = new int[maxi + 1]; // O(k)

            // Reduced to house robber array is constructed
            for(int num: nums){ // O(N)

                cons[num] += num;
            }

            //finding maximum number of points through cons array
            int prev = cons[0];
            int curr = cons[1];
            int temp;

            for(int i = 2; i < cons.length; i++){  // O(k)

                temp = curr;

                // maximum of not choose existing and retaining earlier current, choose existing + previous alternative
                curr = Math.max(curr, cons[i] + prev);

                prev = temp;
            }
            // get maximum at then end of iterating over cons array updating current points
            return curr;
        }


        /*
        Time Complexity: O(N + k)
        N = length of a given array
        k = maximum element in a given array

        Space Complexity: 0(k) as cons of length k is the auxiliary DS constructed
        */

        public static void main(String[] args){

            DeleteAndEarn object = new DeleteAndEarn();

            int[] arr = {1, 4, 2, 4, 6, 6, 4, 7, 4, 3, 2, 1, 8, 3};

            int maxEarn = object.deleteAndEarn(arr);

            System.out.println("Maximum number of points earned by the " +
                    "deleting operation is " + maxEarn);

        }
}
