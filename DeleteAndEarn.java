//Time Complexity: O(n)
//Space Complexity: O(n)
//Did run on leetcode.

class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int len=nums.length;
        if(len==0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>(); //Taken hashmap to store the sum of equal numbers
        ArrayList<Integer> list = new ArrayList<>();		//list is taken so hashmap order is not lost.
        for(int n:nums)
        {
        	if(!map.containsKey(n))
        	{
        		map.put(n, n);
        		list.add(n);
        	}
        	else
        		map.put(n, map.get(n)+n);
        }
        int C=0, DC = 0; int pre = -1;
        
        for(int key: list)
        {
            int temp;
            if(pre!=key-1)						//if previous number is not one less than the present number, choosing the maximum os choose and don't choose.
            {
                temp = map.get(key)+Math.max(C,DC);		//if equal to previous will get don't choose. then return cmax of choose and don't choose.
                DC = Math.max(C,DC);
                C= temp;
            }
            else
            {
                temp = map.get(key)+DC;
                DC = Math.max(C,DC);
                C = temp;
            }
            pre = key;
        }
        
        return Math.max(C, DC);
    }
}