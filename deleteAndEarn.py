class Solution:
    '''
    T = O(N)
    S = O(N)
    '''
    def deleteAndEarn(self, nums: List[int]) -> int:
        c = Counter(nums)
        s = sorted(list(set(nums)))
        earn1, earn2 = 0 , 0 
        
        for i in range(len(s)):
            curr_earn = s[i]*c[s[i]]
            if i > 0 and s[i] == s[i-1] + 1:
                temp = earn2
                earn2 = max( curr_earn + earn1, earn2  )
                earn1 = temp
            else:
                temp = earn2
                earn2 = curr_earn + earn2
                earn1 = temp
        return earn2
            
