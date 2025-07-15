# TimeComplexity: O(n)
# SpaceComplexity:O(n) ~ can be reduced to O(1)
# Approach : This problem is tricky at start but if you add to dict it will be musch simpleer . classic dp problem always you need to wrry about i-1 and i+1 there aere lot of sub problems here 
# if you are dp[i] worry about items untill i consider only i-1 ,,i+1 will be taken care of 


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        d=defaultdict(int)
        for i in nums: 
            d[i]+=1

        keys=list(d.keys())
        keys.sort()
        dp=[0 for i in range(len(keys))]
        dp[0]=keys[0]*d[keys[0]]
        for i in range(1,len(keys)):
            if keys[i]-1==keys[i-1]: #check for dp[i-2]
                if i>=2:
                    dp[i]=max(dp[i-1],dp[i-2]+keys[i]*d[keys[i]])
                else:
                    dp[i]=max(dp[i-1],keys[i]*d[keys[i]])
            else:
                dp[i]=dp[i-1]+(keys[i]*d[keys[i]])
        return dp[-1]
