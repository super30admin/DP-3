class Solution {
    public int deleteAndEarn(int[] nums) {
        int max =0;
        for(int num:nums){
            if(num>max){
                max=num;
            }
        }

        int[] maxArr = new int[max+1];

        //Store the array frequency
        for(int num:nums){
            maxArr[num]+=num;
        }

        System.out.println(Arrays.toString(maxArr));


        for(int i=2;i<maxArr.length;i++){
            maxArr[i] = Math.max(maxArr[i]+maxArr[i-2],maxArr[i-1]);
        }

        return maxArr[max];
        
    }
}
