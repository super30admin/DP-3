'''
TC: O(n)
SC: O(n)

Intuition: store the counts of values in hmap, get all the keys from hmap and sort them. Then at any given 
number, consider only values until that number

-- look into commits for initial solns (for my reference)
'''
class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        nums_len = len(nums)
        if not nums_len:
            return 0
        
        hmap = dict()
        
        for num in nums:
            hmap[num] = hmap.get(num, 0) + 1
        
        keys = sorted(hmap.keys())
        last_key, sum_until_last = keys[0], keys[0] * hmap[keys[0]]
        sum_until_prev = 0
        
        for idx in range(1, len(keys)):
            new_last, new_sum = keys[idx], max(sum_until_last, sum_until_prev) + keys[idx] * hmap[keys[idx]]
            if keys[idx] - 1 == last_key:
                new_last, new_sum = keys[idx], sum_until_prev + keys[idx] * hmap[keys[idx]]    
            sum_until_prev = max(sum_until_last, sum_until_prev)
            last_key, sum_until_last = new_last, new_sum
        
        return max(sum_until_last, sum_until_prev)