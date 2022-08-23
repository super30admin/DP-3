#Executed on leetcode
#time complexity - O(nlogn)
#space - O(n)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        c = collections.Counter(nums)
        keys = sorted(c.keys())
        prev = 0
        ans = cur = c[keys[0]] * keys[0]
        for i in range(1, len(keys)):
            if keys[i] == keys[i-1] + 1:
                prev, cur = cur, max(cur, prev + keys[i] * c[keys[i]])
            else:    
                prev, cur = cur, cur + keys[i] * c[keys[i]]
            ans = max(ans, cur)
        return ans
        