package Day10;

public class DeleteEarn {

    public int delEar(int[] nums){
        int[] values = new int[10001];

        int skip = 0;
        int take = 0;

        for(int num : nums)
            values[num] += num;

        for(int i=0; i<1001; i++){
            int curr_skip = Math.max(skip, take);
            int curr_take = skip + values[i];

            skip = curr_skip;
            take = curr_take;
        }

        return Math.max(skip,take);

    }

    public static void main(String args[]){
        DeleteEarn obj = new DeleteEarn();

        int nums[] = new int[]{3, 4, 2};

        System.out.println("The maximum earning:"+obj.delEar(nums));
    }
}
