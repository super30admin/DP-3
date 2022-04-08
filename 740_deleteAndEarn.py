# order doesnt matter her 
# hashmap -- with num and freq
# 
# 
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxSum = 0 
        
        def getMaxSum(nums): 
            
            if len(nums)==0: return 0
            if len(nums)==1: return nums[0]
            print("Nums =", nums)   
            forwardSum={} ; maxSum = 0 

            for ele in nums:
                if ele in forwardSum:
                    forwardSum[ele] += ele
                else:
                    forwardSum[ele] = ele

            # the problem has reduced to robHouse 

            l = list(set(nums))
            # print("L =",l)
            for ele in l:
                if (ele+1 not in l) and (ele-1 not in l):
                    maxSum += forwardSum[ele]                
                    forwardSum.pop(ele, None)
                    nums = [ n for n in nums if n!=ele]
                if len(nums)==0:
                    return maxSum
                
            l =  list(set(nums))
            for ele in l: 
                tnums1 = [ i for i in l if i != ele+1 and i !=ele-1 and i !=ele]
                tnums2 = [ i for i in l if i !=ele]
                maxSum += max( forwardSum[ele]  + getMaxSum(tnums1), getMaxSum(tnums2) )
            print("sum :", maxSum)
            return maxSum 
        return getMaxSum(nums)