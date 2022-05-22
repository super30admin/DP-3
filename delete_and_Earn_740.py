#TimeComplexity: O(N) 
#SpaceComplexity: O(1) storing it in variable earn and notearn rather than maintaining dparray
#It successfully runs on leetcode
def deleteAndEarn(nums): 
        d={}
        for i in range(max(nums)):
            d[i] = 0
        for i,v in enumerate(nums):
            d[v] = d.get(v,0) + v
        
        earn=0
        notearn=0
        for i in d:
            earn= max(earn,notearn)
            notearn+=d[i]

        
        return max(earn,notearn)

        
        
print(deleteAndEarn([2,3,3,5,5]))
