# Time Complexity : O(n)
#Space Complexity : O(n)
# #// Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :NO

    def deleteAndEarn(self, nums: List[int]) -> int:
        cc=collections.Counter(nums)
        mx=max(cc)
        comp=[]
        for i in range(mx+1):
            if i in cc:
                comp.append(cc[i]*i)
            else:
                comp.append(0)
        memo=[-1 for _ in range(mx+1)]
        def dp(i):
            if i<0:
                return 0 
            elif memo[i]>=0:
                return  memo[i]
            else:
                res=max(dp(i-2)+comp[i],dp(i-1))
                memo[i]=res
                return res
        return dp(mx)