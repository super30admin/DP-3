class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxNumber = 0;
        HashMap<Integer, Integer> points = new HashMap<>();
        
        // Precompute how many points we gain from taking an element
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }
        
        // Base cases
        int twoBack = 0;
        int oneBack = points.getOrDefault(1, 0);
        
        for (int num = 2; num <= maxNumber; num++) {
            int temp = oneBack;
            oneBack = Math.max(oneBack, twoBack + points.getOrDefault(num, 0));
            twoBack = temp;
        }
        
        return oneBack;
    }
}