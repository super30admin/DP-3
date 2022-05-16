class delAndearn {
    public int deleteAndearn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] arr = new int[max + 1];
        for (int num : nums) {
            arr[num] += num;
        }
        int choose = arr[0];
        int notChoose = arr[1];
        for (int i = 2; i < arr.length; i++) {
            int temp = choose;
            choose = Math.max(choose, notChoose);
            notChoose = temp + arr[i];
        }
        return Math.max(choose, notChoose);
    }
}