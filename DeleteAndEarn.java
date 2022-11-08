package S30_Codes.DP_3;

// Time Complexity : O(maxNum)
//Space Complexity : O(maxNum)


class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max = max(nums);
        int[] cache = new int[max+1];
        int[] tempArr = new int[max+1];

        for(int num : nums){
            tempArr[num] += num;
        }

        return getMaxPoints(1, tempArr, cache);
    }

    private int getMaxPoints(int num, int[] tempArr, int[] cache){
        if(num >= tempArr.length)
            return 0;

        if(cache[num] == 0){
            int select = tempArr[num] + getMaxPoints(num+2, tempArr, cache);
            int notSelect = getMaxPoints(num+1, tempArr, cache);

            cache[num] = Math.max(select, notSelect);
        }
        return cache[num];
    }

    private int max(int[] arr){
        int max = arr[0];

        for(int num : arr){
            max = Math.max(max, num);
        }

        return max;
    }
}