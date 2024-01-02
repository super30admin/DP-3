class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        d = defaultdict(int)
        mn = 10001
        mx = 0
        for n in nums:
            d[n] += 1
            if n > mx:
                mx = n

            if n < mn:
                mn = n
        
        a = d[mn-1] * (mn-1)
        b = d[mn] * mn
        for i in range(mn+1, mx+1):
            a, b = b, max(b, a + i * d[i])

        return b

# Time complexity : O(N)
# Space complexity : O(N)
